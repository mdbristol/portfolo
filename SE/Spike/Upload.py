#!/usr/bin/python
# -*- coding: UTF-8 -*-
import cgi
# enable debugging
import cgitb 

cgitb.enable()

print "Content-type: text/html\n\n";

print '''
<HTML>
<BODY> </BODY>
<title>Uploading A File</title>
<FORM ACTION="https://php.radford.edu/cgi-bin/cgiwrap?user=mdbristol&script=/spike/Upload.py" METHOD="post" ENCTYPE="multipart/form-data">
<table>
<tr>
<td>
<font face=verdana size=1 color=#003366> File to Upload:  
</td>
<td>
<INPUT size=70 TYPE="file" NAME="file">
</td>
</tr>
<td>
<input type=hidden name="serial_number" value="1234567890">
</td>
<td>
<INPUT TYPE="submit" NAME="Submit" VALUE="Upload">
</td>
</tr>
</table>
</FORM>
</BODY>
</HTML>

		'''
	
