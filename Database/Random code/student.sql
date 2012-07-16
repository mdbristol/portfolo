--Database I (ITEC 340)
-- Creates and drops the student table 

Drop TABLE student ;

Create table student 
(
	sid   Integer 
,	first Varchar(25)
,	last  Varchar(25)
,	phone Char(8)
,	rank  char(2)
,	Constraint PKstudent PRIMARY KEY(sid,last)
);
Insert Into student values ( 101, 'Mary' , 'Smith' , '775-2384' , 'FR'); 
Insert Into Student Values( 102, 'Steve', 'Jones' , '851-1587' , 'JR');
Insert Into student values(	103 , 'Bob' , 'Jones' , '851-1587' , 'SR');

Drop table student_services;
Create table student_services
(
	sid		Integer 
,	service	Varchar(25)
,	rate	Number(4,3)
,	Constraint ck_rate Check (rate >= 7.50)
,	Constraint PKstudent_services PRIMARY KEY (sid , service)
,	Constraint FKsid FOREIGN KEY (sid) REFERENCES student
);
Insert Into student_services values (101, 'Babysitting', 7.50);
Insert Into student_services values (102, 'Lawncare',8.00);
Insert Into student_services values (102, 'Shoveling', 8.00);
Insert Into student_services values (103, 'Lawncare', 9.50);
Insert Into student_services values (104, 'bobcare' , 4.00);
Drop table customers;

Create table customers 
(
	custID	Integer 
,	first	varchar(10)
,	last 	varchar(15)
,	street 	varchar(15)
,	city	varchar(15)
,	phone	char(8)
,	Constraint PKcustomers PRIMARY KEY(custID)
);
Insert Into customers values (2002, 'Jim', 'Brown' , ' 13 Main St' , 'Bburg' , '555-1212');
Insert Into customers values (2007, 'Judy' , 'Jetson' , '151 Row St' , 'Bburg' , '555-8325');
Insert Into customers values (2010, 'Kelly' , 'Jones' , '238 High St' , 'Cburg' , '851-1789');

Drop table services;

Create table services
(
	name	Varchar(25)
,	min_time	Varchar(10) not null
,	Constraint PKservices PRIMARY KEY (name)
);

Insert Into services values ('Babysitting' , ' 2 hours');
Insert Into services values ('Lawncare' , ' 2 hours');
Insert Into services values ('Shoveling' , '2.5 hours');
Insert Into services values ('careing' , null);
Insert Into services values ('Lawncare' , ' 4 hours');
Drop table jobs;

Create table jobs 
(
	sid	Integer
,	custID	Integer 
,	service	Varchar(15)
,	starttime	Date
,	status	Varchar(10)
,	rating	Integer
,	Constraint ck_rating check (rating between 0 and 4)
,	Constraint PKjobs PRIMARY KEY (sid,custID)
,	Constraint FKcustID FOREIGN KEY (custID) REFERENCES customers
);

Insert Into jobs values ( 101 , 2007 , 'Babysitting' , '28-Jul-2010' , 'Closed' , 4 );
Insert Into jobs values ( 102 , 2003 , 'Lawncare' , '31-Jul-2010' , 'Confirmed' , null);
Insert Into jobs values ( 102 , 2010 , 'Lawncare' , '02-Aug-2010' , 'Pending' , null);
Insert Into jobs values	( null, 2003 , 'Lawncare' , '03-Aug-2010', null);
Update services 
	Set min_time = '2.5 hours'
	where name = 'Babysitting';

Delete from student_services 
	where sid = 102 and service ='Shoveling';
Update jobs 
	set status = 'Confirmed'
	where sid = 102 and custID = 2010;
Insert into student_Services 
	values (101, 'Tutoring' , 8.00);
Insert into services 
	values ('Tutoring' , '1 hours');

