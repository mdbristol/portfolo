-- ----------------------------------------------
-- DROP SEQUENCES
-- ----------------------------------------------
DROP SEQUENCE transcationNum_seq;

-- ----------------------------------------------
-- DROP TRIGGERS
-- ----------------------------------------------
DROP TRIGGER tr_HashPassword_IB;
DROP TRIGGER tr_TransactionNo_IB

-- ----------------------------------------------
-- DROP PROCEDURES
-- ----------------------------------------------
DROP PROCEDURE sp_UpdatePassword
DROP PROCEDURE sp_LoginConfirmation
DROP PROCEDURE sp_TransferTransaction

-- ----------------------------------------------
-- DROP CONSTRAINTS
-- ----------------------------------------------
ALTER TABLE BankCustomers DROP CONSTRAINT BankCustomers_Phone_CC;
ALTER TABLE Accounts DROP CONSTRAINT Accounts_CustID_FK;
ALTER TABLE Transactions DROP CONSTRAINTS Transactions_AccountNo_FK;

-- ----------------------------------------------
-- DROP TABLES
-- ----------------------------------------------
DROP TABLE BankCustomers;
DROP TABLE Accounts;
DROP TABLE Transactions;

-- ----------------------------------------------
-- ALTER SESSION
-- ----------------------------------------------
ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YYYY HH12:MI AM';

-- ----------------------------------------------
-- CREATE Customers
-- ----------------------------------------------
CREATE TABLE BankCustomers (
	CustID VARCHAR(11) NOT NULL CONSTRAINT BankCustomers_CustID_PK PRIMARY KEY,
	Password VARCHAR(20) NOT NULL,
	Lname VARCHAR(50) NOT NULL,
	Fname VARCHAR(50) NOT NULL,
	Phone VARCHAR(16) NOT NULL,
	CONSTRAINT BankCustomers_Phone_CC CHECK( REGEXP_LIKE(Phone, '^[01]?[- .]?\(?[2-9]\d{2}\)?[- .]?\d{3}[- .]?\d{4}$')));

-- ----------------------------------------------
-- Create Accounts
-- ----------------------------------------------
CREATE TABLE Accounts (
	AccountNo VARCHAR(11) NOT NULL CONSTRAINT Accounts_AccountNo_PK PRIMARY KEY,
	CustID VARCHAR(11) NOT NULL,
	AccountType VARCHAR(8) NOT NULL,
	Description VARCHAR(100) NOT NULL,
	Balance NUMBER NOT NULL,
	CONSTRAINT Accounts_CustID_FK FOREIGN KEY(CustID) REFERENCES BankCustomers(CustID));

-- ----------------------------------------------
-- CREATE Transactions
-- ----------------------------------------------	
CREATE TABLE Transactions (
	TransNo VARCHAR(11) NOT NULL CONSTRAINT Transactions_TransNo_PK PRIMARY KEY,
	TDate TIMESTAMP,
	AccountNo VARCHAR(11) NOT NULL,
	Despription VARCHAR(25) NOT NULL,
	Amount NUMBER NOT NULL,
	CONSTRAINT Transactions_AccountNo_FK FOREIGN KEY(AccountNo) REFERENCES Accounts(AccountNo));

-- -----------------------------------------------
-- SEQUENCES
-- -----------------------------------------------
CREATE SEQUENCE transcationNum_seq
START WITH 10000001
INCREMENT BY 1;
	
-- -----------------------------------------------
-- TRIGGERS
-- -----------------------------------------------
CREATE OR REPLACE TRIGGER tr_HashPassword_IB
BEFORE INSERT
ON BankCustomers
FOR EACH ROW
DECLARE
	pword BankCustomers.Password%TYPE;
BEGIN
	SELECT ora_hash(:NEW.Password) INTO pword FROM DUAL;
	:NEW.Password:=pword;
END;
/

CREATE OR REPLACE TRIGGER tr_TransactionNo_IB
BEFORE INSERT
ON Transactions
FOR EACH ROW
BEGIN
	SELECT transcationNum_seq.nextval INTO :NEW.TransNo FROM dual;
END;
/

-- -----------------------------------------------
-- PROCEDURES
-- -----------------------------------------------
CREATE OR REPLACE PROCEDURE sp_UpdatePassword 
	(vCustomerID IN BankCustomers.CustID%TYPE, 
	vOldPword IN VARCHAR2,
	vNewPword IN VARCHAR2, 
	vResultCode OUT VARCHAR2)
IS
	vOldPwordHash BankCustomers.Password%TYPE;
	vStoredHash BankCustomers.Password%TYPE;
	vNewPwordHash BankCustomers.Password%TYPE;
	InvalidPassword EXCEPTION;
BEGIN
	SELECT ora_hash(vOldPword) INTO vOldPwordHash FROM DUAL;
	SELECT ora_hash(vNewPword) INTO vNewPwordHash FROM DUAL;
	SELECT Password INTO vStoredHash FROM BankCustomers WHERE CustID = vCustomerID;
	IF vOldPwordHash = vStoredHash THEN
		UPDATE BankCustomers SET Password = vNewPwordHash WHERE CustID = vCustomerID;
		vResultCode := 'Success';
		COMMIT;
	ELSE
		RAISE InvalidPassword;
	END IF;
EXCEPTION
	WHEN InvalidPassword THEN
		ROLLBACK;
		vResultCode := 'InvalidPassword';
	WHEN OTHERS THEN
		ROLLBACK;
		vResultCode := 'DBFailure';
		DBMS_output.put_Line(SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE sp_LoginConfirmation 
	(vCustomerID IN BankCustomers.CustID%TYPE, 
	vPword IN VARCHAR2, 
	vResultCode OUT VARCHAR2)
IS
	vPwordHash BankCustomers.Password%TYPE;
	vStoredHash BankCustomers.Password%TYPE;
	InvalidCredentials EXCEPTION;
BEGIN
	SELECT ora_hash(vPword) INTO vPwordHash FROM DUAL;
	SELECT Password INTO vStoredHash FROM BankCustomers WHERE CustID = vCustomerID;
	IF vPwordHash = vStoredHash THEN
		vResultCode := 'ValidCredentials';
		COMMIT;
	ELSE
		RAISE InvalidCredentials;
	END IF;
EXCEPTION
	WHEN InvalidCredentials THEN
		vResultCode := 'InvalidCredentials';
	WHEN OTHERS THEN
		vResultCode := 'DBFailure';
		DBMS_output.put_Line(SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE sp_TransferTransaction 
	(vCustomerID IN BankCustomers.CustID%TYPE , 
	vFromAccount IN Accounts.AccountNo%TYPE, 
	vToAccount IN Accounts.AccountNo%TYPE, 
	vAmountTransfer IN Accounts.Balance%Type, 
	vResultCode OUT VARCHAR2)
IS
	vFromAccountBalance Accounts.Balance%TYPE;
	vToAccountBalance Accounts.Balance%TYPE;
	vNumAccounts Number(3);
	NSF EXCEPTION;
	ANF EXCEPTION;
	CF EXCEPTION;
	ResourceBusy EXCEPTION;
	PRAGMA exception_init(ResourceBusy,-54);
BEGIN
	SELECT count(*) INTO vNumAccounts FROM Accounts WHERE CustID = vCustomerID AND (AccountNo = vFromAccount OR AccountNo = vToAccount);
	
	IF vNumAccounts = 0 THEN
		RAISE ANF;
	ELSIF vNumAccounts = 1 THEN
		RAISE CF;
	ELSIF vNumAccounts = 2 THEN
		SELECT Balance INTO vFromAccountBalance FROM Accounts WHERE CustID = vCustomerID AND AccountNo = vFromAccount;
		
		IF (vFromAccountBalance - vAmountTransfer) < 0 THEN
			RAISE NSF;
		ELSE
			SELECT Balance INTO vToAccountBalance FROM Accounts WHERE CustID = vCustomerID AND AccountNo = vToAccount;
			
			UPDATE Accounts SET Balance = vToAccountBalance + vAmountTransfer WHERE CustID = vCustomerID AND AccountNo = vToAccount;
			INSERT INTO Transactions VALUES(NULL, SYSDATE, vToAccount, 'Transfer', vAmountTransfer);
			
			UPDATE Accounts SET Balance = vFromAccountBalance - vAmountTransfer WHERE CustID = vCustomerID AND AccountNo = vFromAccount;
			INSERT INTO Transactions VALUES(NULL, SYSDATE, vFromAccount, 'Transfer', 0-vAmountTransfer);
			
			COMMIT;
			vResultCode := 'Success';
		END IF;
	END IF;
EXCEPTION
	WHEN NSF THEN
		vResultCode := 'NonsufficientFunds';
	WHEN ANF THEN
		vResultCode := 'AccountNotFound';
	WHEN CF THEN
		vResultCode := 'CrossTransfer';
	WHEN ResourceBusy THEN
		ROLLBACK;
		vResultCode := 'CannotAcquireLocks';
	WHEN OTHERS THEN
		ROLLBACK;
		vResultCode := 'DBFailure';
		DBMS_output.put_Line(SQLERRM);
END;
/

-- -----------------------------------------------
-- INSERT BankCustomers
-- -----------------------------------------------
INSERT INTO BankCustomers VALUES ('123', 'hounddog11', 'Smith', 'Jerry', '540-555-1111');
INSERT INTO BankCustomers VALUES ('321', '123rover123', 'Jones', 'Mark', '540-555-2222');

-- -----------------------------------------------
-- INSERT Accounts
-- -----------------------------------------------
INSERT INTO Accounts VALUES ('12', '123', 'Checking', 'Primary Checking', 900.00);
INSERT INTO Accounts VALUES ('14', '123', 'Savings', 'Christmas Club', 1000.00);
INSERT INTO Accounts VALUES ('11', '321', 'Checking', 'Primary Checking', 800.00);
INSERT INTO Accounts VALUES ('18', '321', 'Checking', 'Money Markert Checking', 1000.00);
INSERT INTO Accounts VALUES ('20', '321', 'Savings', 'Passbook Savings', 1200.00);

-- -----------------------------------------------
-- INSERT  Transactions
-- -----------------------------------------------
INSERT INTO Transactions VALUES ('', TO_DATE('01-NOV-2010 11:29 AM', 'DD-MON-YYYY HH12:MI AM'), '12', 'Deposit', 1000.00);
INSERT INTO Transactions VALUES ('', TO_DATE('05-NOV-2010 09:45 AM', 'DD-MON-YYYY HH12:MI AM'), '14', 'Deposit', 1000.00);
INSERT INTO Transactions VALUES ('', TO_DATE('06-NOV-2010 02:30 PM', 'DD-MON-YYYY HH12:MI AM'), '11', 'Deposit', 1000.00);
INSERT INTO Transactions VALUES ('', TO_DATE('07-NOV-2010 02:30 PM', 'DD-MON-YYYY HH12:MI AM'), '18', 'Deposit', 1000.00);
INSERT INTO Transactions VALUES ('', TO_DATE('07-NOV-2010 02:44 PM', 'DD-MON-YYYY HH12:MI AM'), '20', 'Deposit', 1000.00);
INSERT INTO Transactions VALUES ('', TO_DATE('08-NOV-2010 04:41 AM', 'DD-MON-YYYY HH12:MI AM'), '12', 'Check 319', -100.00);
INSERT INTO Transactions VALUES ('', TO_DATE('10-NOV-2010 10:11 AM', 'DD-MON-YYYY HH12:MI AM'), '20', 'Transfer', 200.00);
INSERT INTO Transactions VALUES ('', TO_DATE('10-NOV-2010 10:11 AM', 'DD-MON-YYYY HH12:MI AM'), '11', 'Transfer', -200.00);
COMMIT;