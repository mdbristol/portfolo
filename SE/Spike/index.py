#!/usr/bin/python
# -*- coding: UTF-8 -*-
import cgi
# enable debugging
import cgitb 

cgitb.enable()

print "Content-type: text/html\n\n";

print '''

	<html>

	<head>
	<title>Login page</title>
	</head>

	<body>

	<h1><center><FONT COLOR = "#FF0000" >User Login to RU Pict Cloud </FONT> </center></h1>
	<center><img src="http://cdn.slashgear.com/wp-content/uploads/2011/04/cloud_0.jpg" alt="RU Pict Cloud"/></center>
	<center><table border="0">
	<form method="POST" action="https://php.radford.edu/cgi-bin/cgiwrap?user=mdbristol&script=/spike/login.py">
	<tr><td>Username</td><td>:</td><td><input type="text" name="login" size="20"></td></tr>
	<tr><td>Password</td><td>:</td><td><input type="password" name="password" size="20"></td></tr>
	<tr><td>&nbsp;</td><td>&nbsp;</td><td><input type="submit" value="Login"></td></tr>
	</form>
	</table></center>

	</body>

	</html> 
	'''
	
