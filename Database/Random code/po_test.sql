SET SERVEROUTPUT ON;

Insert Into Products Values (1, 'xbox360', 12, 10);
Insert Into Products Values (2, 'ps3', 12 ,10);
Insert Into Products Values (3, 'wii', 12, 10);

Select * from Products;


Update Products 
Set In_Stock = 11
Where ProdID = 1;

Update Products 
Set In_Stock = 8 
Where ProdID = 1;


Update Products 
Set In_Stock = 10
Where ProdID = 2;


Update Products 
Set In_Stock = 5 
Where ProdID = 3;

Update Products 
Set In_Stock = 2 
Where ProdID = 3;

Select * from Products;

Select * from Purchase_Orders;



Rollback;




