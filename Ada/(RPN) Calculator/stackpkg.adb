--Name: Michael Bristol
--Date: 4/14/2011
--Course: Itec 320 Principles of Procedural Programming
--
--Purpose: To write the package body for the specification of stackpkg
--Stackpkg will pop,push, or top depending on the clients implemtation.
--
--   
package body stackpkg is 

	--Purpose: Perform a check on the stack to determine if the stack is empty
	--Parameters: s, is the stack being sent in from the client
	--Precondition: The stack has been made 
	--Postcodition: Return true or false
	function isEmpty (s : Stack) return Boolean is 
	begin 
	return	s.top = 0;
	end IsEmpty;
	--Purpose: Perform a check on the stack to determine if the stack is full
	--Parameters: s,is the stack being sent in from the client 
	--Precondition: There are already values in the stack
	--Postcondition: Return true or false
	function isFull (s: Stack) return Boolean is 
	begin
		return s.top = Size;
	end isFull;

	--Purpose: Return the top value on the stack
	--Parameters: s, is the stack made by the client 
	--Precondition: there are values in the stack
	--Postcondition: return the top of the stack
	function top (s: Stack) return ItemType is 
	begin 
		if isEmpty(s) then 
			raise Stack_Empty;
		else	
		return s.Elements(s.top);
	end if;
	end top;

	--Purpose: Will add the value the client enter to the stack 
	--Parameters:  item, is the type of value entered by user(Bignum)
	--Precondition: Is a value entered 
	--Postcondition: Adds the value to the stack

	procedure push (item: ItemType; s: in out Stack) is 
	begin 
		if isFull(s) then 
			raise Stack_Full;
		else 
			s.top := s.top + 1;
			s.Elements(s.Top) :=item;
		end if;
	end push;
	--Purpose: Will delete the top value of the stack
	--Parameters:  s, is the stack made by the client 
	--Precondition: There is a top value in the stack
	--Postcondition: The top value is removed 

	procedure pop (s: in out Stack) is 
	begin 
		if isEmpty(s) then 
			raise Stack_Empty;
		else
			s.top := s.top - 1;
		end if;
	end pop;

end stackpkg;
