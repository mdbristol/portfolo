

--Outer Join Problems 


--Write four queries to join the Students table with the Enrollments table using an inner join,
 --a left outer join, a right outer join, and full outer join respectively. 
 --Your results should list the term along with the student’s ID, first, and last name. 
 --Sort your results by term and student ID.  Submit all four queries and explain the results. 
 ----Do not simply explain how the joins work;
 --analyze the results and explain how the joins produced the results. 



--inner join 

Select SID, First, Last, Enrollments.term from Students Inner join Enrollments ON Students.SID = Enrollments.SID Order by term, SID; 

--This Inner join produced reulsts based on the SID and that only produced rows that had all the requirements needed. So for example the could be students who do not have 
-- there sid or even first name written down, or they many not be enrolled in school at the time. So the result table will only have students listed who have all the requirements listed.

--LEft outer join 

Select SID, First, last, Enrollments.term from Student Left Join Enrollments ON Student.SID = ENrollments.SID Order by term, SID;


--This join instead of just producing the results from the inner join will take the matching rows like the inner join table but will also produce anything from the Student table that was 
-- not matched from the requirements. 
--Right Outer Join

Select SID, First, last, Enrollments.term from Student Right Join Enrollments ON Student.SID = Enrollments.SID Order by term, SID;


--Does everything from the left join but instead of putting the non match values from the Student table the non match values from the right table are placed. 
--Full Outer Join

Select SID, First, Last, term from Student FULL JOIN Enrollments ON Student.sid = Enrollments.SID Order by term, SID;

--Takes both tables and gives everything from each table and puts it into the result table even if the the matching keys dont match in both tables. 