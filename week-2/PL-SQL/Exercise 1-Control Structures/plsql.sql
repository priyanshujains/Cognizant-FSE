-- Step 1: Create Tables

-- Creating table to store customer details
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,                -- Date of birth
    Balance NUMBER,          -- Current balance in account
    LastModified DATE,
    IsVIP CHAR(1)            -- New column added to mark VIP customers (Y/N)
);

-- Creating table to store accounts of customers
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),  -- Example: Savings or Checking
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Creating table for storing transactions like deposits/withdrawals
CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),  -- Example: Deposit or Withdrawal
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

-- Creating table for loan details
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,   -- In percent, e.g. 8 means 8%
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Creating employee table (not used in scenarios, but required)
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

-- Step 2: Insert Sample Data

-- Inserting customers with different ages and balances
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (1, 'Aman Verma', TO_DATE('1958-08-15', 'YYYY-MM-DD'), 25000, SYSDATE, NULL);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (2, 'Priya Nair', TO_DATE('2002-03-12', 'YYYY-MM-DD'), 9500, SYSDATE, NULL);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (3, 'Rahul Singh', TO_DATE('1960-11-05', 'YYYY-MM-DD'), 12000, SYSDATE, NULL);


-- Inserting accounts for each customer
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 25000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Savings', 9500, SYSDATE);


-- Inserting example transactions
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, SYSDATE, 5000, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, SYSDATE, 3000, 'Withdrawal');


-- Inserting loan details (one loan is due soon for testing reminders)
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 400000, 8, SYSDATE, SYSDATE + 15);  -- Due soon

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 2, 150000, 10, SYSDATE, ADD_MONTHS(SYSDATE, 36));

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (3, 3, 250000, 7.5, SYSDATE, ADD_MONTHS(SYSDATE, 60));


-- Inserting employees (optional, not used)
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Neha Sharma', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Rohit Mehta', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));



-- Exercise 1: Control Structures

-- Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
-- 	Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.
-- Scenario 2: A customer can be promoted to VIP status based on their balance.
-- 	Question: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.
-- Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
-- 	Question: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.


-- Step 3: Scenario 1 - Apply 1% discount to senior citizens (age > 60)
SET SERVEROUTPUT ON;

DECLARE
    -- Declare cursor to get customer ID and age
    CURSOR customer_cursor IS
        SELECT CUSTOMERID, 
               TRUNC(MONTHS_BETWEEN(SYSDATE, DOB) / 12) AS AGE
        FROM CUSTOMERS;

    -- Variables to hold values from cursor
    var_customer_id CUSTOMERS.CUSTOMERID%TYPE;
    var_age NUMBER;
BEGIN
    -- Loop through each customer
    FOR customer_record IN customer_cursor LOOP
        var_customer_id := customer_record.CUSTOMERID;
        var_age := customer_record.AGE;

        IF var_age > 60 THEN
            -- Apply 1% discount if age is more than 60
            UPDATE LOANS
            SET INTERESTRATE = INTERESTRATE - 1
            WHERE CUSTOMERID = var_customer_id;
        ELSE
            -- Print message if no discount applied
            DBMS_OUTPUT.PUT_LINE('Customer ID: ' || var_customer_id || ' | Age: ' || var_age);
            DBMS_OUTPUT.PUT_LINE('No change in loan interest.');
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Loan discount process complete.');
END;
/

-- Step 4: Scenario 2 - Set VIP if balance > 10,000

SET SERVEROUTPUT ON;

DECLARE
    -- Cursor to get customer ID and balance
    CURSOR customer_cursor IS
        SELECT CUSTOMERID, BALANCE
        FROM CUSTOMERS;

    -- Variables to hold data from cursor
    var_customer_id CUSTOMERS.CUSTOMERID%TYPE;
    var_balance CUSTOMERS.BALANCE%TYPE;
BEGIN
    -- Loop through each customer
    FOR customer_record IN customer_cursor LOOP
        var_customer_id := customer_record.CUSTOMERID;
        var_balance := customer_record.BALANCE;

        IF var_balance > 10000 THEN
            -- Set IsVIP to TRUE
            UPDATE CUSTOMERS
            SET ISVIP = '1'
            WHERE CUSTOMERID = var_customer_id;
            DBMS_OUTPUT.PUT_LINE('Customer ID ' || var_customer_id || ' marked as VIP.');
        ELSE
            -- Set IsVIP to FALSE
            UPDATE CUSTOMERS
            SET ISVIP = '0'
            WHERE CUSTOMERID = var_customer_id;
            DBMS_OUTPUT.PUT_LINE('Customer ID ' || var_customer_id || ' is not a VIP.');
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status update complete.');
END;
/

-- Step 5: Scenario 3 - Send reminders if loan is due within 30 days

SET SERVEROUTPUT ON;

DECLARE
    -- Cursor to get loans due within 30 days and customer info
    CURSOR loan_cursor IS
        SELECT L.LOANID, L.CUSTOMERID, C.NAME, L.ENDDATE
        FROM LOANS L
        JOIN CUSTOMERS C ON L.CUSTOMERID = C.CUSTOMERID
        WHERE L.ENDDATE BETWEEN SYSDATE AND SYSDATE + 30;

    -- Variables to hold data from cursor
    v_loan_id LOANS.LOANID%TYPE;
    v_customer_id LOANS.CUSTOMERID%TYPE;
    v_customer_name CUSTOMERS.NAME%TYPE;
    v_end_date LOANS.ENDDATE%TYPE;
    v_found BOOLEAN := FALSE;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loan_id, v_customer_id, v_customer_name, v_end_date;
        EXIT WHEN loan_cursor%NOTFOUND;

        v_found := TRUE;
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || v_loan_id || 
                             ' for ' || v_customer_name || 
                             ' (ID: ' || v_customer_id || 
                             ') is due on ' || TO_CHAR(v_end_date, 'DD-Mon-YYYY'));
    END LOOP;
    CLOSE loan_cursor;

    -- If no loans found
    IF NOT v_found THEN
        DBMS_OUTPUT.PUT_LINE('No loans are due in the next 30 days.');
    END IF;
END;
/
