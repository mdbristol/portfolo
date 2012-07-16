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

print '''

	<html>

	<head>
	<title>Login page</title>
	</head>

	<body>

	<h1><center><FONT COLOR = "#FF0000" >User Profile </FONT> </center></h1>
	<form method="POST" action="https://php.radford.edu/cgi-bin/cgiwrap?user=mdbristol&script=/spike/profileupdate.py">
	<tr><td>First</td><td>:</td><td><input type="text" name="first" size="20"></td></tr> <br />
	<tr><td>Last</td><td>:</td><td><input type="text" name="last" size="20"></td></tr> <br />
	<tr><td>Birthday</td><td>:</td><td><input type="test" name="birth" size="20"></td></tr> <br />
	<tr><td>Age</td><td>:</td><td><input type="text" name="age" size="20"></td></tr> <br />
	<tr><td>Hobbies</td><td>:</td><td><input type="text" name="hob" size="100"></td></tr> <br />
	<tr><td>&nbsp;</td><td>&nbsp;</td><td><input type="submit" value="Update"></td></tr> <br />
	</form>
	</table></center>

	</body>

	</html> 
	'''
	
q = "SELECT * FROM profile " 

try:
	# Execute the SQL command

	r =cursor.execute(q)
	row = cursor.fetchone()

	# Commit your changes in the database
	db.commit()
except:
	# Rollback in case there is any error
	db.rollback()
	
print row
	
