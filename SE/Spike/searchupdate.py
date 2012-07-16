#!/usr/bin/python
# -*- coding: UTF-8 -*-
import cgi
# enable debugging
import cgitb 

cgitb.enable()

import MySQLdb

print "Content-type: text/html\n\n";
# Open database connection
db = MySQLdb.connect("php.radford.edu","mdbristol","mbrad2009","mdbristol", port=3306 )

# prepare a cursor object using cursor() method
cursor = db.cursor()





form = cgi.FieldStorage()
q = "SELECT * FROM profile WHERE First ='" + form["first"].value + '"'



	# Execute the SQL command
	r =cursor.execute(q)
	row = cursor.fetchone()



	
	


print "Here is the profile of" , form["first"].value

print row

# disconnect from server
db.close()