--Name: Michael Bristol 
--Date: March 14, 2011
--Course: ITEC 320 Principles of Procedural Programming 
--
--Purpose: This program will calculate the students overall grade in the class
--The input will be consit of the name, program scores, quiz scores, test scores
--and finally the fianl exam score which will all be from standard input. 
--After each category will be weighted , averaged and given points following
--the calculations. It will then assign a letter grade matching the points 
--from a 10 point scale. If there is a missing quiz or program they will 
--recieve a zero. If a test is missing test will include the final exam.
--
--Input:
--Bob
--40 40
--40 40 40 40
--40 40
--40
--Adam
--100 100
--90 90 90 90
--80 80
--70
--Bill
--50 50
--50 50 50 50
--50 50
--50
--Jill
--100 50
--30 40 50 
--50 
--90


--
--
--
--Output:
--The outputed result will have the highest Grade first then go in decending order
--Name: Adam            
--Overall Average: 87.0
--Letter Grade: B
--Category     Weight  Average Points  
--Programs      40.0    100.0   40.0   
--Quizzes       10.0     90.0    9.0   
--Tests         30.0     80.0   24.0   
--Final Exam    20.0     70.0   14.0   
--
--
--
--
--

with ada.text_io; use ada.text_io;
with ada.float_text_io; use ada.float_text_io;
with ada.integer_text_io; use ada.integer_text_io;
with ada.characters.handling; use ada.characters.handling;

procedure grades is 
		
	maxStudent: constant := 100; -- sets the max number of students for the
	--array
	nameSize: constant := 70; -- set the max length the students name can be 

	type Grade is (A,B,C,D,F); --enumeration type 
	package Grade_IO is new enumeration_io(Grade);--defined the 
	--enumeration type and set it for use or calling
	use Grade_IO;

	--Holds a record of a student and this student will have all these variables
	type studentInfo is record 
		name: String (1 .. nameSize);
		programScores: Integer;
		quizScores: Integer;
		testScores: Integer;
		finalExam: Integer;
		quizPoint: Float := 0.0;
		programPoint: Float := 0.0;
		testPoint: Float := 0.0;
		finalPoint: Float := 0.0;
		my_grade: Grade;
		average : Float := 0.0;
		programAverage: Float := 0.0;
		quizAverage: Float := 0.0;
		testAverage: Float := 0.0;
		finalAverage: Float := 0.0;
		programAveragetotal: Float := 0.0;
		quizAveragetotal: Float := 0.0;
		testAveragetotal: Float := 0.0;
		finalAveragetotal: Float := 0.0;
			 program_Ammount: Integer;
	        program_Weight: Integer;
	        quiz_Ammount: Integer;
	        quiz_Weight: Integer;
	        test_Ammount: Integer;
	        test_Weight: Integer;
	        final_Ammount: Integer;
	        final_Weight: Integer;

	end record;

--makes a array of records to store the studentsInfo in 
	type studentArray is array (1 .. maxStudent) of studentInfo;

--Stores the array of students and does a count to see how many 
	--valid students are in the array
	type student_List is record 
		my_Student: studentArray;
		count: Natural :=0;
	end record;

--Purpose: Will Read in from a file and get the corresponding values and 
	--put them into the record to be used later. Then will take each record of
	--each student and add it to the array. Also the will raise an exception 
	--if data is not correct or end of file is reached to soon.
	--Parameters: some_Student which is a record 
	--Precondition: The input contain the information of the student
	--Post-Condition: The Array will contain mult records of different students
	--and is not sorted.

	procedure get_inputData(some_Student: in out student_List) is 
		s: studentInfo;	-- stores an student as its populated 	
		EOL: Boolean ;-- finds when the line has reached end of line
		c: Character; --needed for EOL
		n: Integer := 0; --needed for Eol
		count: Integer := 0;

	begin
		begin 
			--gets the number of scores and there weights 
			get(s.program_Ammount);
			get(s.program_Weight);
			get(s.quiz_Ammount);
			get(s.quiz_Weight);
			get(s.test_Ammount);
			get(s.test_Weight);
			get(s.final_Ammount);
			get(s.final_Weight);
			skip_line;	
			

			while not end_of_file loop
					get(s.name); --gets the name of the student 
					skip_line;					
					s.programAverage :=0.0; --resets the average for a
					--new student 
					s.quizAverage := 0.0;
						s.testAverage := 0.0;
					n:=0;		
					s.finalAverage := 0.0;
					count:=0;			 
				--Will loop intill there are no more scores in the catergory,
					--everytime it goes through the loop will add its score 
					--to the overall average.
				 		look_ahead(c,EOL);

				for x in 1 .. s.program_Ammount loop		
						if EOL then 

							skip_line;
						elsif is_digit(c) then
						get(n);
							s.programScores :=n;
					 
						else 
							get(c);
							
						end if;
			s.programAverage := s.programAverage +
						float(s.programScores );
				end loop;
					skip_line;
								look_ahead(c,EOL);
		
				for x in 1 .. s.quiz_Ammount loop
						
						if EOL then 
							--will add the missing scores as zeros 
							while( count < s.quiz_Ammount) loop
								s.quiz_Ammount:= 0;
								count:= count +1;
							end loop;
							skip_line;
						elsif is_digit(c) then
					--adds a zero to missing scores 	
					--		if count > s.quiz_Ammount then 
					--		n:= 0; 
					--		else
								get(n);
								s.quizScores :=n;
					--	count:= count +1;		
					--		end if;
						else 
							get(c);
						end if;
				
							s.quizAverage := s.quizAverage +
						float( s.quizScores)  ;
				
				
				end loop;
		--		put(count);
					skip_line;
							look_ahead(c,EOL);
				for x in 1 .. s.test_Ammount loop 
									if EOL then 
							skip_line;
						elsif is_digit(c) then
						get(n);
						
						else 
							get(c);
						end if;
						s.testScores :=n;
							s.testAverage := s.testAverage +
						float( s.testScores)  ;


				end loop;
						skip_line;
										for x in 1 .. s.final_Ammount loop
						get(s.finalExam);
						s.finalAverage := s.finalAverage + float(s.finalExam) ;
					end loop;
			
					--moves up one place on the array and then sets that array 
					--with the records information of that student 
					some_Student.count := some_Student.count +1;	
		       		some_Student.my_Student(some_Student.count) := s;

					
				
		    end loop;
		-- makes the program not crash or cause errors 
		exception 
			when data_error => 
				put_line("Not correct input");
			when end_error =>
				put_line("end of file reached");
			when constraint_error => 
				put_line("not the right type");
		end;
	end get_inputData;

--Purpose: Given an array of records of studentINfo sort from highest grades 
	--to lowest grade.
	--Pre-condition: Array contains records 
	--Post-Condtion: Returns a soretd array

	function sortArray( unsortedlist: student_List; count: Integer)
		return student_list is
		temp: studentInfo;
		tempAry: student_List;

	begin
		tempAry:=unsortedlist;
		for x in 1 .. count loop
			for j in 1 .. x loop
				if tempAry.my_Student(x).my_Grade < 
					tempAry.my_Student(j).my_Grade then 

					temp := tempAry.my_Student(j);
					tempAry.my_Student(j) := tempAry.my_Student(x);
					tempAry.my_Student(x) := temp;
				end if;
			end loop;
		end loop;
		return tempAry;
	end sortArray;



--Purpose: Is to take all the information gather from each student from 
	--there record and determine there overall scores and grades.
	--Parameters: some_Student which is a record 
	--PreCondition: The array is filled with records of students scores 
	--Post-Condition: Will add the overall scores to the students record 
	--and prepare them to be printed out for later. Also the array is now
	--sorted.
	procedure calcData (some_Student:in  out student_List) is
	s: studentInfo;
	

		

	begin
		for x in 1 .. some_Student.count loop --loops for everyplace in the
			--array
		s := some_Student.my_Student(x);


	--determines the average grades for each students catogory	
	some_Student.my_Student(x).programAverage := s.programAverage /
	float( s.program_Ammount);

	some_Student.my_Student(x).quizAverage := s.quizAverage /
	float(s.quiz_Ammount);

	some_Student.my_Student(x).testAverage := s.testAverage / 
	float(s.test_Ammount);

	some_Student.my_Student(x).finalAverage :=s.finalAverage / 
	float(s.final_Ammount);
	
--determines the number of points earned in each catogory 
	some_Student.my_Student(x).programPoint :=((float(s.program_Weight)) *
	(float(some_Student.my_Student(x).programAverage)))/100.0;

	some_Student.my_Student(x).quizPoint := ((float(s.quiz_Weight))*
	(float(some_Student.my_Student(x).quizAverage)))/100.0; 

	some_Student.my_Student(x).testPoint :=  ((float(s.test_Weight))*
	(float(some_Student.my_Student(x).testAverage)))/100.0; 


	some_Student.my_Student(x).finalPoint := s.finalAverage *
	float(s.final_Weight) / 100.0;

	--determines the overall average grade for the student 
	some_Student.my_Student(x).average:= some_Student.my_Student(x).programPoint +
	some_Student.my_Student(x).quizPoint + some_Student.my_Student(x).testPoint +
	some_Student.my_Student(x).finalPoint;


	--determines the letter grades from the total points earned
	if(some_Student.my_Student(x).average >= 90.0) then 
		some_Student.my_Student(x).my_grade:= A;
	elsif(some_Student.my_Student(x).average >= 80.0) then 
		some_Student.my_Student(x).my_grade:= B;
	elsif(some_Student.my_Student(x).average >= 70.0) then 
		some_Student.my_Student(x).my_grade:= C;
	elsif(some_Student.my_Student(x).average >= 60.0) then 
		some_Student.my_Student(x).my_grade:= D;
	else
		some_Student.my_Student(x).my_grade:= F;
	end if;
	
	
	end loop;

	--Calls a function to sort the array and will return the new array 

	some_Student := sortArray(some_Student,some_Student.count);
	end calcData;

--Purpose: Take all the information from the student record and print them out.
	--Parameters: the_Student is a record that holds the array that contains 
	--the records of each student
	--Pre-condition: Array is sorted and all information for each student 
	--has been inputed and calculated.
	--Post-condition: Students overall grades is printed 
	procedure put_Student(the_Student: student_List)  is 
		s: studentInfo;
		
	begin 
			
		 

--while there are students in the array print out 
		for x in 1 .. the_Student.count loop 
			s := the_Student.my_Student(x);
		new_line;

			
			new_line;
			put("Name: " );
			put(s.name);
			new_line;
			put("Overall Average: ");
			put(s.average,fore => 0, aft => 1, exp =>0);
			new_line;
			put("Letter Grade: ");
			put(s.my_Grade);
			new_line;
			put_line("Category     Weight  Average  Points");
			put("Programs      ");
			put(float(s.program_Weight), fore =>0, aft =>1,exp=>0);
			put("    ");
			put(s.programAverage, fore => 0, aft =>1, exp => 0);
			put("    ");
			put(s.programPoint, fore =>0, aft =>1, exp =>0);
			new_line;
			put("Quizzes       ");
			put(float(s.quiz_Weight), fore =>0, aft =>1,exp=>0);
			put("    ");
			put(s.quizAverage, fore => 0, aft =>1, exp => 0);
			put("    ");
			put(s.quizPoint, fore =>0, aft =>1, exp =>0);
			new_line;
			put("Tests         ");
			put(float(s.test_Weight), fore =>0, aft =>1,exp=>0);
			put("    ");
			put(s.testAverage, fore => 0, aft =>1, exp => 0);
			put("    ");
			put(s.testPoint, fore =>0, aft =>1, exp =>0);
			new_line;
			put("Final Exam    ");
			put(float(s.final_Weight), fore =>0, aft =>1,exp=>0);
			put("    ");
			put(s.finalAverage, fore => 0, aft =>1, exp => 0);
			put("    ");
			put(s.finalPoint, fore =>0, aft =>1, exp =>0);
			new_line;


		
	
		end loop; 







	end put_Student;

	--main variables 
	the_Student: student_List;

begin
	--main procudure 
	get_inputData(the_Student);
	calcData(the_Student);
	put_Student(the_Student);

end grades;


