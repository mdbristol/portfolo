-- Maintaining Views 

SET ECHO ON 

-- Clean up the database 
DROP SYNONYM LV;
DROP SYNONYM MV;
DROP VIEW Baseball_Product_Sales_LV;
DROP MATERIALIZED VIEW Baseball_Product_Sales_MV;  


-----------------------------------------------------------------------------
-- 1. Create a Logical View for sales of baseball products 
-----------------------------------------------------------------------------

CREATE VIEW Baseball_Product_Sales_LV AS
(  SELECT  day_key, prod_key, Sales_Amount, Units_Sold
   FROM      Sales_Fact 
   WHERE  prod_key IN (1001, 1003, 1004, 1005, 1006, 1008, 1010)
);  

CREATE SYNONYM LV FOR Baseball_Product_Sales_LV; 


-------------------------------------------------------------------------------------------------------
-- 2. Create a Materialized View for sales of baseball products refreshed on demand (deferred update) 
-------------------------------------------------------------------------------------------------------

CREATE MATERIALIZED VIEW Baseball_Product_Sales_MV
   REFRESH ON DEMAND  AS
(  SELECT day_key, prod_key, cust_key, OrderID, Sales_Amount, Units_Sold
   FROM     Sales_Fact
   WHERE  prod_key IN (1001, 1003, 1004, 1005, 1006, 1008, 1010)
); 

CREATE SYNONYM MV FOR Baseball_Product_Sales_MV; 


----------------------------------------------------------------------------------------
-- 3. Execute Qbt, Qlv, and Qmv producing R1bt, R1lv, and R1mv 
----------------------------------------------------------------------------------------

-- Qbt:  query against base table (Sales_Fact) 

SELECT  SUM(Units_Sold) 
FROM      Sales_Fact 
WHERE  prod_key IN (1001, 1003, 1004, 1005, 1006, 1008, 1010); 

-- Qlv: query against the logical view 

SELECT SUM(Units_Sold)  FROM  LV; 

-- Qmv: query against the materialized view  

SELECT SUM(Units_Sold)  FROM  MV;   


-- ############################
-- 4. Verify R1bt = R1lv = R1mv 
-- ############################

---------------------------------------------------------------------------------------------  
-- 5. Change the contents of the base table and commit the changes.  
---------------------------------------------------------------------------------------------  

INSERT INTO Sales_Fact (Day_key, Prod_key, Cust_key, OrderID, Units_Sold, Sales_Amount)
VALUES  (20, 1005, 10003, 3016, 10, 124.75); 

COMMIT;  

----------------------------------------------------------------------------------------
-- 6. Execute Qbt, Qlv, and Qmv producing R2bt, R2lv, and R2mv 
----------------------------------------------------------------------------------------

-- Qbt 

SELECT  SUM(Units_Sold) 
FROM      Sales_Fact 
WHERE  prod_key IN (1001, 1003, 1004, 1005, 1006, 1008, 1010); 

-- Qlv 

SELECT SUM(Units_Sold)  FROM  LV; 

-- Qmv 

SELECT SUM(Units_Sold)  FROM  MV;   

-- #############################################
-- 7. Verify R2bt = R2lv <> R2mv AND R2mv = R1mv 
--
-- 8. Explain these results 
-- #############################################

-----------------------------------------------
-- 9. Refresh the materialized view 
-----------------------------------------------

EXECUTE DBMS_MVIEW.REFRESH('Baseball_Product_Sales_MV');   

------------------------------------------------------------------------------------------
-- 10. Execute Qbt, Qlv, and Qmv producing R3bt, R3lv, and R3mv 
------------------------------------------------------------------------------------------

-- Qbt 

SELECT  SUM(Units_Sold) 
FROM      Sales_Fact 
WHERE  prod_key IN (1001, 1003, 1004, 1005, 1006, 1008, 1010); 

-- Qlv 

SELECT SUM(Units_Sold)  FROM  LV; 

-- Qmv 

SELECT SUM(Units_Sold)  FROM  MV;   

-- #############################
-- 11. Verify R3bt = R3lv = R3mv 
--
-- 12. Explain these results 
-- #############################

----------------------------------------------------------------------------------------------------
-- 13. Alter the materialized view to refresh on commit  (immediate update)  
----------------------------------------------------------------------------------------------------

ALTER MATERIALIZED VIEW Baseball_Product_Sales_MV REFRESH ON COMMIT;  

-----------------------------------------------------------------------------------------------  
-- 14. Change the contents of the base table and commit the changes.  
-----------------------------------------------------------------------------------------------  

INSERT INTO Sales_Fact (Day_key, Prod_key, Cust_key, OrderID, Units_Sold, Sales_Amount)
VALUES  (20, 1005, 10003, 3017, 5, 62.38); 

COMMIT;  

------------------------------------------------------------------------------------------
-- 15. Execute Qbt, Qlv, and Qmv producing R4bt, R4lv, and R4mv 
------------------------------------------------------------------------------------------

-- Qbt 

SELECT  SUM(Units_Sold) 
FROM      Sales_Fact 
WHERE  prod_key IN (1001, 1003, 1004, 1005, 1006, 1008, 1010); 

-- Qlv 

SELECT SUM(Units_Sold)  FROM  LV; 

-- Qmv 

SELECT SUM(Units_Sold)  FROM  MV;   

-- #############################
-- 16. Verify R4bt = R4lv = R4mv 
--
-- 17. Explain these results 
-- #############################

----------------------------------------------------------------
-- 18. Create an index on the materialized view 
----------------------------------------------------------------

CREATE INDEX ix_mv ON Baseball_Product_Sales_MV (OrderID); 

--------------------------------------------------------
-- 19. Create an index on the logical view 
--------------------------------------------------------

CREATE INDEX ix_lv ON Baseball_Product_Sales_LV (OrderID); 

-- ################################################################  
-- 20. Explain why Oracle created an index on the materialized view
-- ... but would not create an index on the logical view 
-- ################################################################  


