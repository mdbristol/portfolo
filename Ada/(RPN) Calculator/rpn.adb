--Name: Michael Bristol
--Date: April 14 2011
--Course: Itec 320 Principles of Procedural Programming
--
--Purpose: This project purpose is to implement a simple interactive 
--reverse polish notation (RPN) calculator. We are to write and use 
--the implementatopm of the stackpkg.adb and bignum.adb and write 
--the body of the codes for each.
--We then will write the client which would be called rpn.adb.
--We are also to use look_ahead to determine whether the next item in the
--input is a bignnum,
--an operation, or white space. Three operations are used in the project,
-- +,* and P. + and * do what they always do and the P will pop the stack.
--
--input/output
--10
--20+p
--30
--  2   6   *   4 
--  +   p
--  16
--  9 8 * +
--  raised RPN.BIGNUM_STACK.STACK_EMPTY
--
--
--
--
--
--
--Help Recived: Material from Dr.Okie and notes and http://www.stacken.kth.se/~foo/rpn/#Ada
--
--
--


with ada.text_io; use ada.text_io;
with ada.integer_text_io; use ada.integer_text_io;
with ada.float_text_io; use ada.float_text_io;
with ada.characters.handling; use ada.characters.handling;

with stackpkg;
with bignumpkg; use bignumpkg;--holds big integers 



procedure rpn is 

	package MyStkPkg is new stackpkg(Size => 100,ItemType => bignum);--makes a 
	--new stack from stackpkg with the stack holding 100 of bignum types
	
	use MyStkPkg;

	--Main Variables 
	count, sum : natural;
	c: Character;
	EOL: Boolean;
	b1,b2,b: BigNum;
	MyStk : MyStkPkg.Stack;
	temp1, temp2: natural;
	result : BigNum;
	operation: Character;

begin 

	while not end_of_file loop
	
--loops after each line is found 
	loop
		look_ahead(c,EOL);--determines if a bignum or character
		if EOL then 
			skip_line;
			exit when EOL;
		elsif is_digit(c) then 
				Get(b);
			--	count := count+1;

				MyStkPkg.push(b,MyStk);
				
		else
			get(c);--IF anything but an bignum then get character  
			if c = 'p' then
				b1:= top(MyStk);
				Put(b1,10);
				put("|");
				pop(MyStk);
				new_line;
				--top and save that value in a big num variable 
				--pop the top
				--top the next value and save the big num variale 
				--pop the top
				--Send both to bignumpkg "+"
				--Returns the result 
				--Push that result on to the stack
			elsif c ='+' then

				b1 := top(MyStk);
				pop(MyStk);

				b2 := top(MyStk);
				pop(MyStk);
				result := "+" (b1,b2);
				MyStkPkg.push(result,MyStk);
				--top and save that value in a big num variable 
				--pop the top
				--top the next value and save the big num variale 
				--pop the top
				--Send both to bignumpkg "*"
				--Returns the result 
				--Push that result on to the stack
	
			elsif c = '*' then

				b1 := top(MyStk);
				pop(MyStk);

				b2 := top(MyStk);
				pop(MyStk);
				result := "*"(b1,b2); 
				MyStkPkg.push(result,MyStk);
			
			
			
			end if;
		end if;	
		
		
		end loop;
	end loop;
	end rpn;
