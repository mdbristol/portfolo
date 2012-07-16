---test driver for p03


Insert INTO Explorer_Treasure Values (1,1002);
Insert INTO Explorer_Treasure Values (1,1003);

Insert INTO Explorer_Treasure Values(2,1004);
Insert INto Explorer_Treasure Values(2,1003);
Insert Into Explorer_Treasure Values(2,1002);
Insert INto Explorer_Treasure Values (2,1001);
Insert INto Explorer_Treasure Values (2,1000);



Insert INTO Explorer_Treasure Values(3,1004);
Insert INto Explorer_Treasure Values(3,1003);
Insert Into Explorer_Treasure Values(3,1002);
Insert INto Explorer_Treasure Values (3,1001);
Insert INto Explorer_Treasure Values (3,1000);

rollback;


