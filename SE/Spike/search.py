#!/usr/bin/python
# -*- coding: UTF-8 -*-
import cgi
# enable debugging
import cgitb 

cgitb.enable()

import MySQLdb



print "Content-type: text/html\n\n";

print '''

	<html>

	<head>
	<title>Login page</title>
	</head>

	<body>

	<h1><center><FONT COLOR = "#FF0000" >Search for a User Profile </FONT> </center></h1>
	<form method="POST" action="https://php.radford.edu/cgi-bin/cgiwrap?user=mdbristol&script=/spike/searchupdate.py">
	<tr><td>First</td><td>:</td><td><input type="text" name="first" size="20"></td></tr> <br />
	<tr><td>Last</td><td>:</td><td><input type="text" name="last" size="20"></td></tr> <br />
	<tr><td>&nbsp;</td><td>&nbsp;</td><td><input type="submit" value="Search"></td></tr> <br />
	</form>
	</table></center>

	</body>

	</html> 
	'''
	



	
