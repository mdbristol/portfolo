--Database I (340)
--E06 trigger
Drop table Purchase_Orders;
Drop table Products;

Create table Products
(
	ProdID	Integer
,	Descr	VarChar(25)
,	In_Stock	Integer
,	Order_Amt	Integer
,	Constraint PKproduct Primary Key (ProdID,Order_Amt)
,	Constraint ckOrder	CHECK (Order_Amt > 0)
);


Create table Purchase_Orders
(
	ProdID Integer
,	PO_Date date
,	PO_Qty Integer
,	Constraint PKpurchase Primary Key (ProdID)
,	Constraint FKprod Foreign Key (ProdID,PO_Qty) references Products
,	Constraint CKqty Check (PO_Qty > 0)
);

Create Or Replace Trigger tr_Product_PO
After Update of In_Stock
ON Products 
For EACH ROW 

When (New.In_Stock < 10 ) 
Declare 
	reorder_threshold integer :=10;
Begin
	
	
	dbms_output.put_line('New purchase order insert');
	Insert into Purchase_Orders Values (:old.ProdID,SYSDATE, :old.Order_Amt);

		

	
End;
/

	