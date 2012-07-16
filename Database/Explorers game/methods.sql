Set SERVEROUTPUT ON 

Drop procedure grab;
--Drop procedure getExpRoom;
CREATE OR REPLACE PROCEDURE grab
( exp IN Explorer.eid%type ,
tres IN Treasure.tid%type , 
v_currentRoom Explorer.Room_Num%type;) IS

Ex Exception;
ExMessage varchar(200);
numRows Integer(10);



begin 
	
	
	
	Delete Room_Treasure Where rid = v_currentRoom and tid = tres;
	numRows := sql%Rowcount; 
	If numRows = 1 then 
	
		Insert INTO Explorer_Treasure Values (exp,tres);
		commit;
		DBMS_OUTPUT.PUT_LINE('Treasure loaded to explorer bag');
	end if;
	
	
Exception 
	when No_Data_Found then
		rollback;
	when Too_Many_Rows then 
		rollback;
	when others then 
		rollback;
		DBMS_OUTPUT.PUT_LINE('Grabbing of bag failed: ' || sqlerrm);
END;
/

Create or Replace procedure getExpRoom( exp IN Explorer.eid%type , result OUT Explorer.Room_Num%type) IS
Ex Exception;
ExMessage varchar(200);


--Begin

	--Select Room_Num

show errors