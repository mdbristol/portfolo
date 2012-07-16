import os
import unittest

#TestInput.py tests the reciving of input from a user
#it then sends the input back to the user for confirmation

class TestInput(unittest.TestCase):
		#Variable to determine acceptance of disclaimer
		#warningInput = 'test'
		#Boolean variable to determine of Discalimer Accepted
		#discAccepted = False
		#Prompt for input for warningInput
		#warningInput = raw_input('Enter 'D' to Accept Disclaimer: ')
	assert disclaimer('D') == True
	assert disclaimer('Q') == False 
	assert disclaimer('^H') == False 
	assert disclaimer('%C') == False
	assert disclaimer('') == False
	assert disclaimer('23528623894560923570wegjbv03vn408%gn02vn04nb890 %&**%%^n3g02n38vnh234ng30vn%%%2bn3 2 0g2j0vn2804nh80n') == False
	assert disclaimer('*26^@312CV@3b#B3v2V@#') == False
	assert disclaimer() == False
	
	assert disclaimerOutput(False) == 'Disclaimer Not Accepted. Exiting System.'
	assert disclaimerOutput(True) == 'Disclaimer Accepted.'
	
	
	#if not warningInput == 'D':
	#	print 'Disclaimer Not Accepted. Exiting System.'
	#	sys.exit(0)
	#else:
	#	print 'Disclaimer Accepted.'