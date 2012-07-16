-- This is the implementation for the BigNum abstract data type, which supports
-- arithmetic with VERY LARGE natural values.  The operations provided
-- work as one would expect for natural numbers.

with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;

package body BigNumPkg is

    -- Currently the implementation uses a base 10 system for
    -- storing numbers and performing arithmetic operations.
    --
    InternalBase : constant Positive := 10;

	--Purpose: Coonvert the integer into a character
	--Parameters: i, integer or bignum
	--PreCondition: gets an integer 
	--PostCondition:return a character
	function convertIC(i: integer) return Character is 
	c: Character;
	begin
		c := Character'Val(i);
		return c;
	end convertIC;
	
	
	--Purpose: Takes the characters and puts them into a string 
	--Parameters: takes in a bignum 
	--PreCondition: has the final result of the bignums
	--PostCondition: returns a string 
    function toString(X: BigNum) return String is
		theString: String(1 .. Size);
    begin
			for i in 0 .. Size -1 loop 
				theString(i + 1) := convertIC(x);
			end  loop;
        return theString(1 .. Size);
    end toString;

    function "<"  (X, Y : BigNum) return Boolean is
    begin
        for I in 0..Size-1 loop
            if X(I) < Y(I) then
                return True;
            elsif X(I) > Y(I) then
                return False;
            end if;
        end loop;
        return False;
    end "<";

    function ">"  (X, Y : BigNum) return Boolean is
    begin
        return not (X < Y or X = Y);
    end ">";

    function "<=" (X, Y : BigNum) return Boolean is
    begin
        return X = Y or X < Y;
    end "<=";

    function ">=" (X, Y : BigNum) return Boolean is
    begin
        return not (X < Y);
        -- return Standard.">="(X, Y); -- Causes error on intel platform
    end ">=";

    -- To add two numbers, start in the right most part of the two
    -- arrays and add column by column working toward the left.  The
    -- value of carry indicates how much of a previous column's value
    -- should be carried forward to the next column's.
    --
    function "+" (X, Y : BigNum) return BigNum is
        Carry : Natural := 0;
        Sum : Integer;
        Result : BigNum := (others => 0);
    begin
        for I in reverse 0..Size-1 loop
            Sum := Carry + X(I) + Y(I);

            -- Determine the amount of carry.
            if Sum >= InternalBase then
                Sum := Sum - InternalBase;
                Carry := 1;
            else
                Carry := 0;
            end if;

            Result(I) := Sum;
        end loop;

        -- The result is too big if the left-most column gave
        -- a carry.
        if Carry > 0 then
            raise BigNumOverFlow;
        end if;
        return Result;
    end "+";

    -- Currently implemented as repeated addition.  This make "*" slow,
    -- but at least the result is correct. :-)
    --Code to use for small numbers if big nums dont work 
   -- function "*" (X, Y : BigNum) return BigNum is
     --   Count, Result : BigNum := Zero;
   -- begin
     --   while Count /= Y loop
       --     Count := Count + One;
         --   Result := Result + X;
        --end loop;
       -- return Result;
    --end "*";

    -- Skips leading whitespace (spaces, tabs, end of lines) before
    -- the data to be read.
    --
	--
	
	function "*" (x,y : BigNum) return BigNum is 
	Carry: Natural := 0; --used to determine the carry over
	Sum: Natural :=0; --result of multiplication
	tempB,tempA,result: Bignum := zero;--temp bignums  
	tempNum: Natural :=0;
	sLeft: Natural :=0;
	begin

		--goes through the the the first bignum (x)
		--then goes through the second bignum(y)
	for i in reverse 0 .. size-1 loop
		for j in reverse 0 .. size-1 loop

			Sum := x(i) * y(j) + carry;
			tempNum := Sum mod InternalBase;

			if(j-sLeft >= 0 and Sum /= 0) then 
				tempB(j-sLeft) := tempNum;
				carry := Sum/InternalBase;
			end if;
		end loop;

	result := result + "+" (tempB,tempA);
	sLeft := sLeft +1; 
	tempB := zero; --resets 
	end loop; 
	return result;

	end "*";

--
    procedure Get (Item : out BigNum) is
        Letter : Character;
        LineEnd : Boolean;
        LastI : Natural := 0;
    begin
        -- Skip leading whitespace
        loop
            if End_Of_File then
                raise DATA_ERROR;
            elsif End_Of_Line then
                Skip_Line;
            else
                Look_Ahead(Letter, LineEnd);

                -- exit if find a digit
                exit when Letter in '0'..'9';
                -- Original version skipped leading zeros, as follows:
                -- exit when Letter in '1'..'9';

                Get(Letter);
                if Letter /= ' ' and Letter /= ASCII.HT
                    and Letter /= '0' then
                    raise DATA_ERROR;
                end if;
            end if;
        end loop;

        -- Read in digits of number
        for I in 0..Size-1 loop
            exit when End_Of_Line;
            Look_Ahead(Letter, LineEnd);
            exit when LineEnd;
            exit when Letter not in '0'..'9';
            Get(Item(I), Width => 1);
            LastI := I;
        end loop;

        -- If there's still more digits, then raise DATA_ERROR.
        Look_Ahead(Letter, LineEnd);
        if Letter in '0'..'9' then
            raise DATA_ERROR;
        end if;

        -- Shift digits to the left within the array
        for I in reverse 0..LastI loop
            Item(I+Size-1-LastI) := Item(I);
        end loop;
        for I in 0..Size-2-LastI loop
            Item(I) := 0;
        end loop;
    end Get;

    -- Writes a BigNum to the output, padding with leading spaces
    -- if the width given is larger than the length of the number
    -- (leading zeros are not printed).
    --
    procedure Put (Item : BigNum; Width : Natural := 1) is
        First : Integer := Size-1;
    begin
        -- Determine where the first digit of the number is,
        -- and thus the length of the number.
        for I in 0..Size-1 loop
            if Item(I) /= 0 then
                First := I;
                exit;
            end if;
        end loop;

        -- Put any leading blanks that are necessary.
        for I in Size-First+1..Width loop
            Put(' ');
        end loop;
		--write out the digits of the number
		for I in First..Size-1 loop
			Put(Item(I), Width => 1);
		end loop;
	end Put;
	end BigNumPkg;
