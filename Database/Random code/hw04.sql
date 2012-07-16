-- hw04
--Michael Bristol
--Database 1

Drop VIEW home_winner;
Drop TABLE Team;
Drop TABLE Game;




Create TABLE Team
(
	Name	VarChar(15)
,	City	VarChar(10)
,	State	VarChar(2)
,	Constraint pk_team PRIMARY KEY (City,State)
,	Constraint uk_name Unique (Name)
);


Insert Into Team Values ('BobCats' , 'chantilly' ,'va');
Insert Into Team Values('Tigers','oak hill' , 'va');
Insert Into Team Values('Baers' ,'oakton','va');
Insert Into Team Values('TeamPhil' , 'uptown' ,'ma');
Insert Into Team Values('Rage' ,'bristol' , 'tn');
Insert Into Team Values('bob' ,'bristol' ,'tn');
Insert Into Team Values('Tigers', 'dallas' ,'tx');


Create TABLE Game
(
	Home	VarChar(15)
,	Visiting	VarChar(15)
,	Date_Played	Date
,	Home_Score	Integer
,	Visiting_Score	Integer
,	Constraint pk_game PRIMARY KEY (Home,Visiting)
,	Constraint uk_date UNIQUE (Date_Played)
--,	Constraint fk_home FOREIGN KEY (Home) REFERENCES Team
);
Insert Into Game Values ('BobCats','Tigers', '01-Jun-2011', 9 ,6); 
Insert Into Game Values ('Baers','TeamPhil', '01-Jun-2011', 8 , 10);
Insert Into Game Values('Rage', 'BobCats' , '02-Aug-2011', 8 , 5);
Insert Into Game Values('Baers' , 'Tigers' , '03-Jan-2011', 6 , 7 );
Insert Into Game Values ('Rage', 'TeamPhil' , '04-Dec-2011', 4 , 3);
Insert Into Game Values ('BobCats' , 'Baers' , '01-Jun-2011' , 5 , 7);

--Questions  ? 
--create a column named Winner ?  
--view home team winners 
-- How to i compute who won and record that ?
--Constraint for max players on team ? 54 players 
Create VIEW home_winner AS
(
Select Home, Date_PLayed, Home_Score, Visiting_Score from Game 
WHERE Home_Score > Visiting_Score 
);

--Create VIEW Winning_Team AS
--(
--Select    Date_Played,Home_Score, Visiting_Score
--FROM  Game );



Select Home, count(*) as num_Wins  from home_winner group by Home order by num_Wins desc;
