--Name: Michael Bristol
--Date: January 25, 2011
--Course: Itec 320 Principles of Procedural Programming 
--
--Purpose: The program is to calculate the numbers of wins/ties for Teams A 
--And B. It is also to calculate information from the orginal player 
--as well as several different pairing pairings of the the original players.
--This program will also calculate the average win for each team.  
--sample case:
-- Main input case 
-- 6       21
-- 15      15
-- 25      40
-- 9       28
-- 6       24 
--
--Help received: Used Dr.Okie's notes, used the text book,wikibook.org,
--

with ada.text_io; use ada.text_io;
with ada.integer_text_io; use ada.integer_text_io;
with ada.exceptions; use ada.exceptions;
with ada.float_text_io; use ada.float_text_io;


procedure pairings is

	
	maxValue: constant Natural :=100; --sets max number of pairs for the array
	maxValue2: constant Natural := 1000; -- sets max score 
	

	type Int_Array is array (1 .. maxValue) of Natural; --sets the range for array

	subtype maxRange is Natural range 1 .. maxValue2;--sets the range for the type


    --Purpose:Read in values from a file or from the command line and seprates,
	--them into two seperate arrays. Raises exceptions on data that does not meet
	--the requirments.
	--Parameters: takes in two arrays that have been defined and the counter
	--PreCondition: a,b have no values in there arrays
	--PostCondition: a,b will each contain half the inputted values


	procedure fillArrays(a,b:  out Int_Array; c: out Natural)   is
		n1,n2: Integer;
		too_Large, too_Small: Exception;
	begin
			--second begin is for the exceptions lines
		begin
			c :=1;--beings the number of elements at one
			while (not End_Of_File) loop
				
				get(n1);
				get(n2);
				if n1   < 1  then 
					raise too_Small;
				elsif n1   > 1000 then
					raise too_Large;
				elsif n2 < 1 then 
					raise too_Small;
				elsif n2 > 1000 then 
					raise too_Large;
				else
				a(c) := n1;
				b(c) := n2;
				c := c + 1;--everytime an element is added will increase 
			

				end if;
			end loop;

				
		exception
		when data_error => 
			put_line("non-numeric input");
		when end_error =>
			put_line("end of file reached");
		when constraint_error =>
			put_line("integer not a natural");
		when too_Large | too_Small =>
			put_line(" Invalid Score  Range ");
		end;
         c := c -1;		--to get the correct bounds 
	end fillArrays;

    --Purpose: Determine the number of wins for teamA
	--Parameters: a,b: Arrays and the counter c
	--PreCondition: a,b,c have values 
	--PostCondition: Returns an integer for the number of wins.


	function calcWinA(a,b: Int_Array; c: Integer)  return integer is
		totalwinB: Integer :=0;

	begin
		for i in 1 .. c loop
			if a(i) >  b(i) then
				totalwinB := totalwinB + 1;
			end if;					
		end loop;
		return totalwinB;
	end calcWinA;

		

	
    --Purpose: Determine the number of wins for teamB
	--Parameters: a,b: Arrays and the counter c
	--PreCondition: a,b,c have values 
	--PostCondition: Returns an integer for the number of wins.



	function calcWinB(a,b: Int_Array; c: Integer) return integer is 
		totalwinA: Integer :=0;
	begin 
		for i in 1 .. c loop
			if a(i) < b(i) then 
				totalwinA := totalwinA + 1;
			end if;
		end loop;
		return totalwinA;
	end calcWinB;

     
    --Purpose: Determine the number of ties of teamA and TeamB
	--Parameters: a,b: Arrays and the counter c
	--PreCondition: a,b,c have values 
	--PostCondition: Returns an integer for the number of wins.


	function totalTie(a,b: Int_Array; c: Integer) return integer is 
		Tie: Integer :=0;
	begin
		for i in 1 .. c loop 
			if a(i) = b(i) then 
				Tie := tie + 1;
			end if;
		end loop;
		return Tie;
	end totalTie;

  	 
    --Purpose: Determine the average ammount of win values for teamA.
	--Parameters: a,b: Arrays and the counter c
	--PreCondition: a,b,c have values 
	--PostCondition: Returns an float for the the average.


	function averageA(a,b: Int_Array; c: Integer) return float is
		avgA: Float; 
		avgTotal: Integer :=0;
		maxLength: Integer :=0 ;
	begin 
		for i in 1 .. c loop 
			if a(i) > b(i) then 
				avgTotal := (a(i)-b(i)) + avgTotal;
				maxLength := maxLength + 1;
         
			end if;
		end loop;
			if avgTotal = 0 then
				avgA := 0.0;
			else
			avgA := float(avgTotal) / float(maxLength);
			end if;
		return avgA;
		end averageA;


    --Purpose: Determine the average ammount of win values for teamB.
	--Parameters: a,b: Arrays and the counter c
	--PreCondition: a,b,c have values 
	--PostCondition: Returns an float for the the average.

    function averageB(a,b: Int_Array; c: Integer) return float is 
		avgB: Float;
		avgTotal: Integer :=0;
		maxLength: Integer := 0;
	begin 
		for i in 1 .. c loop
			if a(i) < b(i) then 
				avgTotal := (b(i)-a(i)) + avgTotal;
				maxLength := maxLength +1;
            	
			else
				avgB :=0.0; 
			
			end if;
		end loop;
			if avgTotal = 0 then 
				avgB := 0.0;
			else
			avgB := float(avgTotal) / float(maxLength);
			end if;
		return avgB;
	end averageB;

    --Purpose:Determins the lowest value in a given array
	--Parameters: array,c
	--PreCondition: array contains 1 or more values , counter
	--PostCondition: Returns maxRange - which will contain the lowest value in,
	--the given array

	function lowestVIndex(arry: Int_Array; c: Natural) return maxRange is 
		lowIndex: maxRange;
	begin 
		lowIndex:= 1;
		for i in arry'first+1..c loop 
			if arry(i) < arry(lowIndex) then 
				lowIndex:=i;
			end if;
		end loop;
		return lowIndex;
	end lowestVIndex;

    --Purpose:Determins the highest value in a given array
	--Parameters: arry, c 
	--PreCondition: array contains 1 or more values, counter 
	--PostCondition: Returns maxRange - which will contain the highest value in
	--the given array`

	function highestVIndex(arry: Int_Array; c: Natural) return maxRange is 
		highIndex: maxRange;
	begin 
		highIndex:=1;
		for i in arry'first+1 ..c loop 
			if arry(i) > arry(highIndex) then 
				highIndex:=i;
			end if;
		end loop;
		return highIndex;
	end highestVIndex;

    --Purpose:Removes the lowest of highest value of the given array.
	--Parameters: array,removeIndex,c -values are being sent in 
	--PreCondition: arry - contains 1 or more values, removeIndex-none
	--PostCondition: Return tempA - Int_array -contains new array with the 
	--highest or lowest value 

	function removeArrayElement(arry: Int_Array; c: Natural; removeIndex: maxRange) return Int_Array is 
	tempA: Int_Array;
	begin
		for i in 1 .. c loop
			if i<removeIndex then 
				tempA(i) := arry(i);
			elsif i> removeIndex then 
				tempA(i - 1) :=arry(i);
			end if;
		end loop;
		return tempA;
	end removeArrayElement;

    --Purpose: Takes the inputed array and sorts it so that the lowest
	--values are on top.
	--Parameters: a,c
	--PreCondition: a-contains 1 or more values
	--PostCondition: Returns an array with sorted values

	function accendingOrder(a: Int_Array; c: Natural) return Int_Array is 
		temp: maxRange;
		tempA: Int_Array;
	begin 
		tempA := a;
		for i in reverse 1 ..c loop
			for j in tempA'First .. i loop
				if tempA(i) < tempA(j) then 
					temp := tempA(j);
					tempA(j) := tempA(i);
					tempA(i) := temp;
				end if;
			end loop;
		end loop;
		return tempA;
	end accendingOrder;


    --Purpose: Takes the inputed array and sorts its so that the highest 
	--values are on top.
	--Parameters: a,c
	--PreCondition: a-contains 1 or more values
	--PostCondition: Returns an array with sorted values


	function decendingOrder(a: Int_Array; c: Natural) return Int_Array is 
		temp: maxRange;
		tempA: Int_Array;
	begin 
		tempA := a;
		for i in reverse 1 ..c loop
			for j in tempA'First .. i loop
				if tempA(i) > tempA(j) then 
					temp := tempA(j);
					tempA(j) := tempA(i);
					tempA(i) := temp;
				end if;
			end loop;
		end loop;
		return tempA;
	end decendingOrder;

    --Purpose: Determine the win,loses,tie and average scores from the original
	--input.
	--Parameters: a,b,c
	--PreCondition: a,b are Arrays with values contained
	--PostCondition: Prints out the Results of TeamA and TeamB

	procedure originialP(a,b: in Int_Array; c: in Natural) is 
	begin
		--prints out the arrays
		for i in 1 .. c loop
			put(a(i));
			put(b(i));
			new_line;
		end loop;
	put_line("Original pairings:");
	put_line("  Wins for A:   " & Integer'image( calcWinA(a,b,c)));
	put_line("  Wins for B:   " & Integer'image( calcWinB(a,b,c)));
	put_line("  Ties:         " & Integer'image( totalTie(a,b,c)));
	put("  Average A win: " );
	put(averageA(a,b,c), fore=>0,aft=>1,exp=>0);
	new_line;
	put("  Average B win: " );
	put(averageB(a,b,c), fore=>0, aft=>1, exp =>0);
	new_line;
	new_line;
			
	end originialP;

    --Purpose:Determine the win,loses,tie and average scores with team with the
	--most wins losing its best player and the team with the lowest amount of 
	--wins losing its worse player.
	--Parameters: a,b,c
	--PreCondition: a,b contain values in a array 
	--PostCondition: Prints out the new results with each team having lost 
	--a player.

	procedure reducedTP(a,b: in out Int_Array; c: in out Natural) is 
		
		lowestTeamIndex, highestTeamIndex: maxRange;
	begin 
		--determines which team has the most wins
			if calcWinA(a,b,c) > calcWinB(a,b,c) then 
				lowestTeamIndex := lowestVIndex(b,c);
				highestTeamIndex:= highestVIndex(a,c);

				a:=removeArrayElement(a,c,highestTeamIndex);
				b:=removeArrayElement(b,c,lowestTeamIndex);
				c := c-1;

			elsif calcWinA(a,b,c) < calcWinB(a,b,c) then
	
				highestTeamIndex:= highestVIndex(b,c);
				lowestTeamIndex:= lowestVIndex(a,c);

				a:= removeArrayElement(a,c, lowestTeamIndex);
				b:= removeArrayElement(b,c, highestTeamIndex);
				c := c-1;
			end if;

	--prints out the arrays
	for i in 1 .. c loop
		put(a(i));
		put(b(i));
		new_line;
	end loop;
	put_line("Reduced team pairings:");
	put_line("  Wins for A:   " & Integer'image( calcWinA(a,b,c)));
	put_line("  Wins for B:   " & Integer'image( calcWinB(a,b,c)));
	put_line("  Ties:         " & Integer'image( totalTie(a,b,c)));
	put("  Average A win: " );
	put(averageA(a,b,c), fore=>0,aft=>1,exp=>0);
	new_line;
	put("  Average B win: " );
	put(averageB(a,b,c), fore=>0, aft=>1, exp =>0);
	new_line;
	new_line;		

	end reducedTP;

--Purpose: Takes the array with the most wins and puts it into accending Order,
	--puts the array with the least wins into decending Order. Then it will 
	--compare the two arrays again and find the wins,loses,ties and average.
	--Parameters: a, b: values are they arrays, c: value is the counter
	--Precondition: a,b are unsorted and contains values.
	--c: coutains the exect number of elements in the array.
	--Postcondition: Prints out the new Arrays and the Results
	
	procedure reducedBWP(a,b: in out Int_Array; c: in out Natural) is 
		
		
	begin 
		--Determins which team has the mose wins and then sorts the 
		--arrays according.
			if calcWinA(a,b,c) > calcWinB(a,b,c) then 
                a :=accendingOrder(a,c);
				b := decendingOrder(b,c);

				
			elsif calcWinA(a,b,c) < calcWinB(a,b,c) then
				
				a := decendingOrder(a,c);
				b := accendingOrder(b,c);
				
			end if;

	--prints out the the new sorted array
	for i in 1 .. c loop
		put(a(i));
		put(b(i));
		new_line;
	end loop;
	put_line("Reduced Best Worst team pairings:");
	put_line("  Wins for A:   " & Integer'image( calcWinA(a,b,c)));
	put_line("  Wins for B:   " & Integer'image( calcWinB(a,b,c)));
	put_line("  Ties:         " & Integer'image( totalTie(a,b,c)));
	put("  Average A win: " );
	put(averageA(a,b,c), fore=>0,aft=>1,exp=>0);
	new_line;
	put("  Average B win: " );
	put(averageB(a,b,c), fore=>0, aft=>1, exp =>0);
	new_line;
	new_line;		

	end reducedBWP;


--Purpose: Takes both arrays and sets them agaist each other with both 
	--having been sorted in decending order. They will then calculate the wins,
	--loses,ties, and averages for the teams.
	--Parameters: a,b: values in arrays. c: number of elements in array
	--PreCondition: a,b are unsorted arrays and contain values. c: elements,
	--in array.
	--PostCondition: Returns sorted arrays and calculated results
	procedure reducedBB(a,b: in out Int_Array; c: in out Natural) is 
		
		
	begin 
		--sorts arrays so that there max values are on top
		a := decendingOrder(a,c);
		b := decendingOrder(b,c);
				

		
		--prints out the sorted arrays
	for i in 1 .. c loop
		put(a(i));
		put(b(i));
		new_line;
	end loop;
	put_line("Reduced Best Vs Best Pairing:");
	put_line("  Wins for A:   " & Integer'image( calcWinA(a,b,c)));
	put_line("  Wins for B:   " & Integer'image( calcWinB(a,b,c)));
	put_line("  Ties:         " & Integer'image( totalTie(a,b,c)));
	put("  Average A win: " );
	put(averageA(a,b,c), fore=>0,aft=>1,exp=>0);
	new_line;
	put("  Average B win: " );
	put(averageB(a,b,c), fore=>0, aft=>1, exp =>0);
	new_line;
	new_line;		

	end reducedBB;




--main variables 

	teamA,teamB : Int_Array;
	count: Natural;


begin


	--starts the program 
    	fillArrays(teamA,teamB,count);
		originialP(teamA,teamB,count);
		reducedTP(teamA,teamB,count);
		reducedBB(teamA,teamB,count);
		reducedBWP(teamA,TeamB,count);


	
	

end pairings;

