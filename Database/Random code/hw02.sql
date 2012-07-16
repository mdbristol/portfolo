---Daatbase I (ITEC 340)
-- Hw02 

Drop TABLE Results;
Drop TABLE Candidate;
Drop TABLE Primary;
Drop TABLE Party;

Create table Party
(
	Name VarChar(25)
,	Platform VarChar(25) not null
,	Color VarChar(5)	
,	Mascot VarChar(10)
,	Constraint PKParty PRIMARY KEY (Name)
,	Constraint ck_color check (Color = 'red' or Color = 'blue')
,	Constraint UniqueMascot Unique (Mascot)
);

	Insert Into Party Values( 'Democrat' , 'Liberal' , 'blue' , 'donkey');
	Insert Into Party Values( 'Republican' , 'Conservative' , 'red' , 'elephant');
--Test so that the color can only be blue or red
	Insert Into Party Values ('Green Party' , 'Free' , 'green' ,'dog');
--Test to make sure that no two have the same Mascot 
	Insert Into Party Values ('Same Party' , 'same' , 'blue' , 'donkey');

Create table Primary
(
	Name VarChar(25)
,	State Char(2)
,	Date1 Date
, 	Constraint PKPrimary PRIMARY KEY (Date1,State)
);

	Insert Into Primary Values ('Florida Primary' , 'FL' , '31-Jan-2012' );
	Insert Into Primary Values ('Iowa Straw Poll', 'IA' , '13-Aug-2011' );
	Insert Into Primary Values ('Iows Caucuses', 'IA' , '06-Feb-2012' );
	Insert Into Primary Values ('New Hamppshire Primary', 'NH' , '14-Feb-2012' );
	Insert Into Primary Values ('Nevada Caucuses', 'NV', '18-Feb-2012' );
	Insert Into Primary Values ('Utah Primary', 'UT' ,'26-Jun-2012' );

Create table Candidate 
(
	Name VarChar(25)
,	DOB Date
,	Party VarChar(25)
,	Home Char(2)
,	Status VarChar(10)	not null
,	Constraint PKCandidate PRIMARY KEY (Name)
,	Constraint FKCandidate FOREIGN KEY (Party) References Party
,	Constraint ck_status check (Status = 'Active' or Status = 'Inactive')
);

Insert Into Candidate Values ( 'Mitt Romney' , '12-Mar-1947' , 'Republican' , 'MA' , 'Active');
Insert Into Candidate Values ( 'Tim Pawlenty' , '27-Nov-1960', 'Republican' , 'MN' , 'Inactive');
Insert Into Candidate Values ( 'Michele Bachmann' ,'06-Apr-1956' , 'Republican' , 'MN' , 'Active' );
Insert Into Candidate Values ( 'Rick Perry' , '04-Mar-1950' , 'Republican' , 'TX' , 'Active');
--Testing if each candidate has either a active or inactive status
Insert Into Candidate Values ('bob test' , '05-Mar-4897' , 'Republican' ,  'VA' , null);
Insert Into Candidate Values ('mike bristol' , '09-Jan-2011' , 'Republican' , 'VA' , 'not active');

Create table Results
(
	Candidate VarChar(25)
,	State Char(2)
,	Date1 Date
,	Percentage Integer
,	Constraint PKResults PRIMARY KEY (Candidate,State, Date1)
--,	Constraint FKResults FOREIGN KEY (Candidate) References Candidate
,	Constraint FKResults1 FOREIGN KEY (Date1,State) References Primary
);

	Insert Into Results Values ('Michele Bachmann' , 'IA' , '13-Aug-2011' , 28);
	Insert Into Results Values ('Tim Pawlenty' , 'IA' , '13-Aug-2011' , 13);

--Should null values be allowed in the percentage column in the Results table ?
--In real life there could be candidates that do not get any percentage of the votes 
--so there should be null values allowned. 


--New Events 
Insert Into Candidate Values ('Sarah Palin' , '03-Jun-1950' , 'Democrat', 'AX', 'Active');
Delete from Results 
	where Candidate = 'Michele Bachmann';
Update Candidate 
	Set Status = 'Inactive'
	where Name = 'Michele Bachmann' and Status ='Active';
Update Primary 
	Set Date1 = '01-Mar-2012'
	where Name = 'Florida Primary';
Delete Primary 
	where Name = 'Utah Primary';
Insert Into Party Values ('Independent' ,'Moderate' , null , null);
Update Candidate 
	Set Party = 'Independent'  
	where Name ='Tim Pawlenty';
Update Candidate 
	Set Status = 'Active'
	where name ='Tim Pawlenty';


