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




print "Content-type: text/html\n\n";

	



q3 = "SELECT Name FROM images " 
q4 = "SELECT image FROM images"
try:
	# Execute the SQL command

	r3 =cursor.execute(q3)
	row3 = cursor.fetchone()
	r4 = cursor.execute(q4)
	row4 = cursor.fetchone()
	# Commit your changes in the database
	db.commit()
except:
	# Rollback in case there is any error
	db.rollback()




	


		
print "<H3> Images Uploaded</H3>"
print row3
print row4;
	
	



# disconnect from server
db.close()

