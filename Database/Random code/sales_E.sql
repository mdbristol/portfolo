-- Data Warehousing, Data Mining, and Reporting (ITEC 442) 
--
-- 1. Create the Sales star schema 
-- 2. Load the Day dimension 
-- 3. Load the Customer and Product dimensions 
-- 4. Load the Sales_Fact table 
-- 

-- Display comments and statements when script is executed  
SET ECHO ON; 	

-- Drop the Sales schema 
DROP TABLE Sales_Fact;
DROP TABLE Day_dim;
DROP TABLE Product_dim; 
DROP TABLE Customer_dim;

-- Create the Sales schema 
CREATE TABLE Day_dim
(
  Day_key		NUMBER 
, Date_str		VARCHAR2(11)
, Day_num		NUMBER(2) CHECK (Day_num BETWEEN 1 AND 31) 
, Month   		VARCHAR2(10)  
, Year			NUMBER(4) NOT NULL  
, Is_holiday	CHAR(1) CHECK (Is_holiday IN ('Y', 'N'))
, Is_Weekday	CHAR(1) CHECK (Is_weekday IN ('Y', 'N'))
, CONSTRAINT DayPK PRIMARY KEY (Day_key)
); 

CREATE TABLE Product_dim
(
  Prod_key		NUMBER 
, ProdID		NUMBER 
, Description	VARCHAR2(18)  
, Department	VARCHAR2(12)
, Category		VARCHAR2(12)
, Brand			VARCHAR2(20)
, CONSTRAINT ProdPK PRIMARY KEY (Prod_key)
); 

DROP SEQUENCE Prod_key_seq; 

CREATE SEQUENCE Prod_key_seq 
  --START WITH 1000
  START WITH 999
  INCREMENT BY 1; 

CREATE TABLE Customer_dim
(
  Cust_key		NUMBER  
, CustID		NUMBER  	
, First			VARCHAR2(15) 
, Last			VARCHAR2(15) 
, City			VARCHAR2(15)
, State			CHAR(2)
, Zip_code		CHAR(5)
, Gender		CHAR(1)
, Occupation	VARCHAR2(8)
, CONSTRAINT CustPK PRIMARY KEY (Cust_key)
); 

DROP SEQUENCE Cust_key_seq; 

CREATE SEQUENCE Cust_key_seq 
  --START WITH 10000
  START WITH 9999
  INCREMENT BY 1; 

-- (Daily) Sales  

CREATE TABLE Sales_Fact
(
  Day_key	NUMBER 
, Prod_key	NUMBER  
, Cust_key	NUMBER  
, OrderID	NUMBER  
, Units_Sold   	NUMBER(5) NOT NULL 
, Sales_Amount	NUMBER(8,2) NOT NULL  
, CONSTRAINT SalesPK PRIMARY KEY (Day_key, Prod_key, Cust_key, OrderID) 
, CONSTRAINT DayFK   FOREIGN KEY (Day_key)  REFERENCES Day_dim 
, CONSTRAINT ProdFK  FOREIGN KEY (Prod_key) REFERENCES Product_dim 
, CONSTRAINT CustFK  FOREIGN KEY (Cust_key) REFERENCES Customer_dim 
);


-- ###########################################
-- 2. Load the Day dimension table 
-- ###########################################

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (1, '19-Jul-2010', 19, 'July', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (2, '20-Jul-2010', 20, 'July', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (3, '21-Jul-2010', 21, 'July', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (4, '22-Jul-2010', 22, 'July', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (5, '23-Jul-2010', 23, 'July', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (6, '24-Jul-2010', 24, 'July', 2010, 'N', 'Y');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (7, '25-Jul-2010', 25, 'July', 2010, 'N', 'Y');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (8, '26-Jul-2010', 26, 'July', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (9, '27-Jul-2010', 27, 'July', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (10, '28-Jul-2010', 28, 'July', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (11, '29-Jul-2010', 29, 'July', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (12, '30-Jul-2010', 30, 'July', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (13, '31-Jul-2010', 31, 'July', 2010, 'N', 'Y');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (14, '1-Aug-2010', 1, 'August', 2010, 'N', 'Y');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (15, '2-Aug-2010', 2, 'August', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (16, '3-Aug-2010', 3, 'August', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (17, '4-Aug-2010', 4, 'August', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (18, '5-Aug-2010', 5, 'August', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (19, '6-Aug-2010', 6, 'August', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (20, '7-Aug-2010', 7, 'August', 2010, 'N', 'Y');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (21, '8-Aug-2010', 8, 'August', 2010, 'N', 'Y');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (22, '9-Aug-2010', 9, 'August', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (23, '10-Aug-2010', 10, 'August', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (24, '11-Aug-2010', 11, 'August', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (25, '12-Aug-2010', 12, 'August', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (26, '13-Aug-2010', 13, 'August', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (27, '14-Aug-2010', 14, 'August', 2010, 'N', 'Y');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (28, '15-Aug-2010', 15, 'August', 2010, 'N', 'Y');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (29, '16-Aug-2010', 16, 'August', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (30, '17-Aug-2010', 17, 'August', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (31, '18-Aug-2010', 18, 'August', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (32, '19-Aug-2010', 19, 'August', 2010, 'N', 'N');

INSERT INTO Day_dim (day_key, date_str, day_num, month, year, is_holiday, is_weekday)
VALUES (33, '20-Aug-2010', 20, 'August', 2010, 'N', 'N');


-- #################################################
-- 3. Load the Customer and Product dimension tables 
-- #################################################

-- Load Customer Dimension 

INSERT INTO Customer_Dim (Cust_key, CustID, First, Last, City, State, Zip_code, Gender, Occupation)
VALUES (Cust_key_seq.nextval, 500, 'Steve', 'Smith', 'Charlotte', 'NC', '28201', 'M', 'Player');

INSERT INTO Customer_Dim (Cust_key, CustID, First, Last, City, State, Zip_code, Gender, Occupation)
VALUES (Cust_key_seq.nextval, 501, 'Robin', 'Williams', 'Hollywood', 'CA', '91618', 'M', 'Actor');

INSERT INTO Customer_Dim (Cust_key, CustID, First, Last, City, State, Zip_code, Gender, Occupation)
VALUES (Cust_key_seq.nextval, 502, 'Steve', 'Francis', 'Houston', 'TX', '77005', 'M', 'Player');

INSERT INTO Customer_Dim (Cust_key, CustID, First, Last, City, State, Zip_code, Gender, Occupation)
VALUES (Cust_key_seq.nextval, 503, 'LeBron', 'James', 'Miami', 'FL', '33111', 'M', 'Player');

INSERT INTO Customer_Dim (Cust_key, CustID, First, Last, City, State, Zip_code, Gender, Occupation)
VALUES (Cust_key_seq.nextval, 504, 'Dwayne', 'Wade', 'Miami', 'FL', '33114', 'M', 'Player');

INSERT INTO Customer_Dim (Cust_key, CustID, First, Last, City, State, Zip_code, Gender, Occupation)
VALUES (Cust_key_seq.nextval, 505, 'Chris', 'Bosh', 'Miami', 'FL', '33111', 'M', 'Player');

INSERT INTO Customer_Dim (Cust_key, CustID, First, Last, City, State, Zip_code, Gender, Occupation)
VALUES (Cust_key_seq.nextval, 506, 'Phil', 'Jackson', 'Los Angeles', 'CA', '90013', 'M', 'Coach');

INSERT INTO Customer_Dim (Cust_key, CustID, First, Last, City, State, Zip_code, Gender, Occupation)
VALUES (Cust_key_seq.nextval, 507, 'Sammy', 'Sosa', 'Chicago', 'IL', '60646', 'M', 'Player');

INSERT INTO Customer_Dim (Cust_key, CustID, First, Last, City, State, Zip_code, Gender, Occupation)
VALUES (Cust_key_seq.nextval, 508, 'Bobby', 'Cox', 'Atlanta', 'GA', '30302', 'M', 'Coach');

INSERT INTO Customer_Dim (Cust_key, CustID, First, Last, City, State, Zip_code, Gender, Occupation)
VALUES (Cust_key_seq.nextval, 509, 'Alfonso', 'Soriano', 'Chicago', 'IL', '60609', 'M', 'Player');

INSERT INTO Customer_Dim (Cust_key, CustID, First, Last, City, State, Zip_code, Gender, Occupation)
VALUES (Cust_key_seq.nextval, 510, 'Sandra', 'Bullock', 'Hollywood', 'CA', '91618', 'F', 'Actor');

INSERT INTO Customer_Dim (Cust_key, CustID, First, Last, City, State, Zip_code, Gender, Occupation)
VALUES (Cust_key_seq.nextval, 511, 'Lisa', 'Leslie', 'Los Angeles', 'CA', '90013', 'F', 'Player');

INSERT INTO Customer_Dim (Cust_key, CustID, First, Last, City, State, Zip_code, Gender, Occupation)
VALUES (Cust_key_seq.nextval, 512, 'Kim', 'Mulkey', 'Waco', 'TX', '76705', 'F', 'Coach');


-- Load Product Dimension

INSERT INTO Product_Dim (Prod_key, ProdID, Description, department, category, brand)
VALUES (Prod_key_seq.nextval, 10, 'Jersey', 'apparel', 'basketball', 'Champion'); 

INSERT INTO Product_Dim (Prod_key, ProdID, Description, department, category, brand)
VALUES (Prod_key_seq.nextval, 11, 'Cap', 'apparel', 'baseball', 'Champion'); 

INSERT INTO Product_Dim (Prod_key, ProdID, Description, department, category, brand)
VALUES (Prod_key_seq.nextval, 12, 'Backpack', 'apparel', 'hiking', 'Rawlings'); 

INSERT INTO Product_Dim (Prod_key, ProdID, Description, department, category, brand)
VALUES (Prod_key_seq.nextval, 13, 'Penant', 'memorabilia', 'baseball', 'Nike'); 

INSERT INTO Product_Dim (Prod_key, ProdID, Description, department, category, brand)
VALUES (Prod_key_seq.nextval, 14, 'Baseball', 'equipment', 'baseball', 'Rawlings'); 

INSERT INTO Product_Dim (Prod_key, ProdID, Description, department, category, brand)
VALUES (Prod_key_seq.nextval, 15, 'Bat', 'equipment', 'baseball', 'Louisville Slugger'); 

INSERT INTO Product_Dim (Prod_key, ProdID, Description, department, category, brand)
VALUES (Prod_key_seq.nextval, 16, 'Glove', 'equipment', 'baseball', 'Nike'); 

INSERT INTO Product_Dim (Prod_key, ProdID, Description, department, category, brand)
VALUES (Prod_key_seq.nextval, 17, 'T-Shirt', 'apparel', 'hiking', 'Champion'); 

INSERT INTO Product_Dim (Prod_key, ProdID, Description, department, category, brand)
VALUES (Prod_key_seq.nextval, 18, 'Autograph Picture', 'memorabilia', 'baseball', 'Nike'); 

INSERT INTO Product_Dim (Prod_key, ProdID, Description, department, category, brand)
VALUES (Prod_key_seq.nextval, 19, 'Shot Chart', 'memorabilia', 'basketball', 'Rawlings'); 

INSERT INTO Product_Dim (Prod_key, ProdID, Description, department, category, brand)
VALUES (Prod_key_seq.nextval, 20, 'Score Card', 'memorabilia', 'baseball', 'Nike'); 

INSERT INTO Product_Dim (Prod_key, ProdID, Description, department, category, brand)
VALUES (Prod_key_seq.nextval, 21, 'Basketball shoes', 'equipment', 'basketball', 'Nike'); 


-- ###########################################
-- 4. Load the Sales_Fact table 
-- ###########################################


INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10001, 1000, 2, 3001, 1, 23.07);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10000, 1000, 1, 3000, 2, 46.14);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10006, 1001, 3, 3008, 1, 26.37);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10005, 1001, 3, 3007, 4, 105.48);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10002, 1001, 2, 3002, 3, 79.11);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10001, 1001, 2, 3001, 3, 79.11);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10003, 1002, 3, 3011, 4, 118.76);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10002, 1002, 2, 3001, 1, 29.69);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10001, 1002, 2, 3001, 2, 59.38);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10001, 1004, 3, 3009, 6, 52.74);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10004, 1004, 3, 3005, 5, 43.95);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10003, 1004, 3, 3004, 7, 61.53);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10003, 1004, 3, 3003, 10, 87.90);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10005, 1005, 3, 3012, 1, 34.98);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10005, 1006, 3, 3012, 3, 59.97);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10003, 1007, 3, 3011, 2, 24.94);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10000, 1007, 3, 3010, 12, 149.64);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10003, 1007, 3, 3004, 2, 24.94);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10005, 1009, 3, 3006, 10, 12.50);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10003, 1009, 3, 3004, 12, 15.00);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10010, 1001, 18, 3012, 1, 26.37);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10010, 1011, 18, 3012, 3, 415.00);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10012, 1011, 18, 3013, 5, 615.89);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10011, 1011, 18, 3014, 8, 1038.57);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10011, 1000, 18, 3014, 5, 115.35);

INSERT INTO Sales_Fact (Cust_key, Prod_key, Day_key, OrderID, Units_Sold, Sales_Amount)
VALUES (10011, 1001, 18, 3014, 1, 22.98);

-- ########################################
-- 5. Verify the counts in each table 
-- ########################################

SET ECHO OFF; 

SELECT SUM(day)   AS Day_Dim_Count, 
       SUM(cust)  AS Customer_Dim_Count, 
	   SUM(prod)  AS Product_Dim_Count, 
	   SUM(sales) AS Sales_Fact_Count
FROM   (SELECT count(*) AS day, 0 AS cust, 0 AS prod, 0 AS sales
	    FROM   Day_Dim
		UNION
		SELECT 0, count(*), 0, 0
	    FROM   Customer_Dim 
	    UNION
		SELECT 0, 0, count(*), 0
		FROM   Product_Dim
		UNION
		SELECT 0, 0, 0, count(*)
		FROM   Sales_Fact); 


