#!/usr/bin/python
# -*- coding: UTF-8 -*-
import cgi
# enable debugging
import cgitb 

cgitb.enable()

import MySQLdb

# Open database connection
db = MySQLdb.connect("php.radford.edu","mdbristol","mbrad2009","mdbristol", port=3306 )

# prepare a cursor object using cursor() method
cursor = db.cursor()




def header(title):
    print "Content-type: text/html\n\n";
    print "<HTML>\n<HEAD>\n<TITLE>%s</TITLE>\n</HEAD>\n<BODY>\n" % (title)
	

def footer():
    print "</BODY></HTML>"

form = cgi.FieldStorage()
q = "SELECT username FROM user WHERE username ='" + form["login"].value + "'" 
q2 = "SELECT password FROM user WHERE username  ='" + form["login"].value + "'" 

try:
	# Execute the SQL command
	r =cursor.execute(q)
	row = cursor.fetchone()
	r2 = cursor.execute(q2)
	row2 = cursor.fetchone()
	
	# Commit your changes in the database
	db.commit()
except:
	# Rollback in case there is any error
	db.rollback()




if not form:
	
    header("Login Response")
	

elif form.has_key("login") and form["login"].value != "" and form.has_key("password") :
	if form["login"].value == row[0] and form["password"].value == row2[0]:
		header("Connected ...")
		print "<center><hr><H3>Welcome back," , form["login"].value, ".</H3><hr></center>"
		print r"""<form><input type="hidden" name="session" value="%s"></form>""" % (form["login"].value)
		print "<H3><a href=https://php.radford.edu/cgi-bin/cgiwrap?user=mdbristol&script=/spike/homepage.py>Click here to start browsing</a></H3>"
		
	else:
		header("No success!")
		print "<H3>Please go back and enter a valid login.</H3>"
else: 
	header("No success!")
	print "<H3>Please go back and enter a valid login.</H3>"
	
footer()


# disconnect from server
db.close()

