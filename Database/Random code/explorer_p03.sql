-- Create the Explorers schema 

DROP TABLE Room_Treasure;
DROP TABLE Explorer_Treasure; 
DROP TABLE Room;
DROP TABLE Explorer;
DROP TABLE Treasure;

CREATE TABLE Room
(
	rid		NUMBER
,	Name		VARCHAR2(20)
,	Descr		VARCHAR2(30)
,	Next		NUMBER 
, CONSTRAINT Room_PK PRIMARY KEY (rid)
); 

CREATE TABLE Explorer
(
	eid			NUMBER
,	Name			VARCHAR2(20)
,	Username		VARCHAR2(20)
,	Room_Num		NUMBER
,	Max_Item_Count		NUMBER 
,	Max_Bag_Weight		NUMBER
,	Max_Item_Weight		NUMBER
, CONSTRAINT Exp_PK PRIMARY KEY (EID)
);

-- Sequence to manage Explorer identifiers 
	DROP SEQUENCE eid_seq; 

 CREATE SEQUENCE eid_seq
 MINVALUE     0
  START WITH   0
  INCREMENT BY 1;

CREATE TABLE Treasure
(
	tid			NUMBER
,	Name		VARCHAR2(20)
,	Descr		VARCHAR2(30)
,	Value		NUMBER
,	Weight		NUMBER(8,3)
, CONSTRAINT Tres_PK PRIMARY KEY (tid)
); 

CREATE TABLE Room_Treasure
(
	rid		NUMBER
,	tid		NUMBER
, CONSTRAINT Room_Tres_PK PRIMARY KEY (rid, tid)
, CONSTRAINT RID_Room_Tres_FK FOREIGN KEY (rid) REFERENCES Room 
, CONSTRAINT TID_Exp_Room_FK  FOREIGN KEY (tid) REFERENCES Treasure
);

CREATE TABLE Explorer_Treasure
(
	eid		NUMBER
,	tid		NUMBER
, CONSTRAINT Exp_Tres_PK PRIMARY KEY (eid, tid)
, CONSTRAINT EID_Exp_Tres_FK FOREIGN KEY (eid) REFERENCES Explorer
, CONSTRAINT TID_Exp_Tres_FK FOREIGN KEY (tid) REFERENCES Treasure
);

-- Load explorer 

INSERT INTO Explorer (EID, Name, Username, Room_Num, Max_Item_Count, Max_Bag_Weight, Max_Item_Weight)
VALUES (eid_seq.nextval, 'Zeek', 'jpittges', 1, 2, 6, 6.5);
INSERT INTO Explorer (EID, Name, Username, Room_Num, Max_Item_Count, Max_Bag_Weight, Max_Item_Weight)
VALUES (eid_seq.nextval, 'Bristol', 'mdbristol', 1, 3, 20, 4.5);
INSERT INTO Explorer (EID, Name, Username, Room_Num, Max_Item_Count, Max_Bag_Weight, Max_Item_Weight)
VALUES (eid_seq.nextval, 'bob', 'test1', 1, 4, 6, 6.5);
-- VALUES (eid_seq.nextval, 'Zeek', 'jpittges', 1, 2, 6, 6.5);

-- Load rooms 

INSERT INTO Room (rid, Name, Descr, Next)
VALUES (1, 'the Start Room', 'A cold, dark place', 2);

INSERT INTO Room (rid, Name, Descr, Next) 
VALUES (2, 'Davis 216', 'A place of higher learning', 3);

INSERT INTO Room (rid, Name, Descr, Next) 
VALUES (3, 'Davis 225', 'A lab like no other', 4);

INSERT INTO Room (rid, Name, Descr, Next)
VALUES (4, 'the End Room', 'A warm, bright place', -1);

-- Load treasures 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1000, 'Golden key', 'Unlocks the first room', 1, 0.1); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1001, 'iPod', 'Plays music', 100, 0.5); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1002, 'DVD Player', 'Plays videos', 150, 5.5); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1003, 'iPad', 'Mini tablet PC', 300, 2.0); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1004, 'Plasma TV', '70-inch flat panel television', 200, 50); 

-- Load treasures into rooms 

INSERT INTO Room_Treasure (rid, tid)
VALUES (1, 1000); 

INSERT INTO Room_Treasure (rid, tid)
VALUES (1, 1001); 

INSERT INTO Room_Treasure (rid, tid)
VALUES (2, 1002); 

INSERT INTO Room_Treasure (rid, tid)
VALUES (3, 1003); 

INSERT INTO Room_Treasure (rid, tid)
VALUES (4, 1004); 



COMMIT; 


