--Name: Michael Bristol
--Date: January 25, 2011
--Course: Itec 320 Principles of Procedural Programming 
--
--Purpose: This assignment purpose is to implement a single-operation, postfix calculator.
--The Calculator will input two integers and a single letter.
--After it reads in the line inputed by the user it will calculate the answer. 
--The Operations will include plus, minus,divide, times, gcd and lcm.
--Or simple as p,m,t,d,g,l.
--This file will also come with a datefile.txt that can be ran instead to provide test data.
--sample case:
--1   1  p

--1+1=2
--3   4  t 
--3*4=12
--Help received: Used Dr.Okie's notes, used the text book
--


with ada.text_io; use ada.text_io;
with ada.integer_text_io; use ada.integer_text_io;
with ada.float_text_io; use ada.float_text_io;

procedure postcalc is
	a: Integer;		--First integer
	b: Integer;		--Second integer 
	c: Character;	--operation to be used 
	gcd: Integer;  --greatest common denominator 
	g1: Integer; --frist integer for gcd
	g2: Integer; ---second integer for gcd
	sum: Integer;  --calulates the first and second integer 


begin

	while not ada.text_io.end_of_file loop   --stops program when reaches the end of the file
		
--Gets the first integer then the second
			get(a);
			get(b);
			loop  --get the third input which is a character and detects white space
				get(c);
				exit when c /= ' ';
			end loop;
			skip_line; 
			
--initalizes the two Integers to help for the gcd			
			g1 := a;
			g2 := b;
--Decides what happens after the input of c is found			
			case c is
				--adds the first two integers and prints out the total	
				when 'p' =>
					sum := a + b;
					put(a'img& " +" &b'img& " = ");
					put(sum,width => 1);
				--subtracts the first two integers and prints out the total	
				when 'm' =>
					sum := a - b;
					put(a'img& " -" &b'img& " = ");
					put(sum,width =>1);
				--multiplys the first two integers and prints out the total
				when 't' => 
					sum := a * b;
					put(a'img& " *" &b'img& " = ");
					put(sum,width =>1);
				--divides the first two integers and prints out the total	
				when 'd' =>
	

						if a = 0 and b = 0  then 
							put(a'img& " /"&b'img& " = 0");
						elsif b = 0 then 
							put("cant divide by a zero denominater");
						else
							sum := a / b;
							put(a'img& " /"&b'img& " = ");
							put(sum,width=>1);
						
					end if;
				--takes the first two integers to calculate the greatest common denominater 
					--then prints out the answer
				when 'g' =>
					while b/=0 loop
					gcd :=b;
					b:=a mod b;
					a:= gcd;
			       if gcd < 0 then 
					   gcd:= gcd *(-1);
			       end if;
			   		end loop;
	
					put(g1'img& " g" &g2'img& " = ");
					put(gcd, width =>1);
					--multiplys the first two integers and then divide by the gcd
					--then print out the answer
				when 'l' =>
					sum := (a * b) / gcd;
					put(a'img& " l" &b'img& " = ");
					put(sum,width =>1);
					--when any other character is inputed then print out this
				when others => put("Invalid operator ");
			end case;
			new_line;			

	end loop;


end postcalc;

