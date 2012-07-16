Set SERVEROUTPUT ON 

Drop procedure grabtest;

CREATE OR REPLACE PROCEDURE grabtest IS 


Begin 

		DBMS_OUTPUT.PUT_LINE('Begining test');
		grab(1,1000);
	    DBMS_OUTPUT.PUT_LINE('Testing if the obective was grabbed');
		
		grab(1,1001);
		
END;
/

show errors