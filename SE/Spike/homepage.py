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
<title>HomePage</title>
</head>

<body>
<center><img src="http://3.bp.blogspot.com/_Pvczjr_7004/TFwRXhXPsJI/AAAAAAAABxw/Nsg_IyOBOQw/s1600/Home+Icon.jpg" alt="HomePage"/></center>
<h1><center>Welcome to the RU PICT CLOUD </center></h1>
<h3><center><a href=https://php.radford.edu/cgi-bin/cgiwrap?user=mdbristol&script=/spike/profile.py>Profile</center></a></H3>
<h3><center><a href=https://php.radford.edu/cgi-bin/cgiwrap?user=mdbristol&script=/spike/Upload.py>Upload</center></a></H3>
<h3><center><a href=https://php.radford.edu/cgi-bin/cgiwrap?user=mdbristol&script=/spike/Album.py>Album</center></a></H3>
<h3><center><a href=https://php.radford.edu/cgi-bin/cgiwrap?user=mdbristol&script=/spike/search.py>Search</center></a></H3>

</body>

</html>

		'''
	
