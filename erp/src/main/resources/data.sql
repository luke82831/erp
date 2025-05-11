-- User Table
CREATE TABLE ERP_USER (
       USER_ID INT AUTO_INCREMENT PRIMARY KEY,
       USER_NAME VARCHAR(50),
       PASSWORD VARCHAR(50),
       EMPLOYEE_ID INT,
       ROLE_ID INT,
       LAST_LOGIN_TIME TIMESTAMP NOT NULL,
       STATUS VARCHAR(50)
);

-- Role Table
CREATE TABLE ERP_ROLE_PERMISSION (
       ROLE_ID INT AUTO_INCREMENT PRIMARY KEY,
       ROLE_NAME VARCHAR(50)
);

-- Suppliers Table
CREATE TABLE ERP_SUPPLIERS (
       SUPPLIER_ID INT AUTO_INCREMENT PRIMARY KEY,
       SUPPLIER_NAME VARCHAR(100),
       SUPPLIER_CONTACT_PERSON VARCHAR(50),
       SUPPLIER_TELEPHONE VARCHAR(50),
       SUPPLIER_EMAIL VARCHAR(100),
       SUPPLIER_ADDRESS VARCHAR(100),
       SUPPLIER_BUSINESS_ID_NUMBER VARCHAR(20),
       SUPPLIER_PAYMENT_TERM TEXT,
       SUPPLIER_TYPE VARCHAR(50)
);

-- Employee Table
CREATE TABLE ERP_EMPLOYEE (
       EMPLOYEE_ID INT AUTO_INCREMENT PRIMARY KEY,
       EMPLOYEE_NAME VARCHAR(255),
       DEPARTMENT VARCHAR(100),
       POSITION VARCHAR(100),
       START_DATE DATE,
       EMPLOYEE_PHONE VARCHAR(50),
       EMPLOYEE_EMAIL VARCHAR(255),
       EMPLOYEE_ADDRESS VARCHAR(255),
       SALARY BIGINT,
       BANK_ACCOUNT BIGINT
);

-- Warehouse Table
CREATE TABLE ERP_WAREHOUSE (
       WAREHOUSE_ID INT AUTO_INCREMENT PRIMARY KEY,
       WAREHOUSE_NAME VARCHAR(100),
       WAREHOUSE_ADDRESS VARCHAR(255),
       CONTACT_PERSON VARCHAR(100)
);

-- Insert User
INSERT INTO ERP_USER (
       USER_NAME,
       PASSWORD,
       EMPLOYEE_ID,
       ROLE_ID,
       LAST_LOGIN_TIME,
       STATUS
       ) VALUES
       ('WU', '123456', 1, 1, TIMESTAMP '2025-04-14 15:16:17', 'AVAILABLE');

-- Insert Roles
INSERT INTO ERP_ROLE_PERMISSION (
       ROLE_NAME
        ) VALUES
        ('ADMIN'),
        ('MANAGER'),
        ('USER'),
        ('GUEST');

-- Insert Suppliers
INSERT INTO ERP_SUPPLIERS (
       SUPPLIER_NAME,
       SUPPLIER_CONTACT_PERSON,
       SUPPLIER_TELEPHONE,
       SUPPLIER_EMAIL,
       SUPPLIER_ADDRESS,
       SUPPLIER_BUSINESS_ID_NUMBER,
       SUPPLIER_PAYMENT_TERM,
       SUPPLIER_TYPE
       )VALUES
       ('自行採購', 'WU', '+000000', 'example1@gmail.com', '2號8樓', 'A123456789', '月結', '內部供應商'),
       ('company1', 'Jane Smith', '+11111', 'example2@gmail.com', 'Market St', '123456789', 'Cash on Delivery', 'Food Supplier'),
       ('company2', 'Alan Walker', '+2222', 'example3@gmail.com', 'London', '234567891', 'Net 60 days', 'Textile'),
       ('company3', 'Emily Chen', '+333', 'example4@gmail.com', 'Taipei', '876543210', 'Prepaid', 'Hardware'),
       ('company4', 'Michael Green', '+444', 'example5@gmail.com', '888 Energy Rd', '345678912', 'Net 45 days', 'Energy Supplier'),
       ('company5', 'Michael Green', '+555', 'example6@gmail.com', '888 Energy Rd', '345678912', 'Net 45 days', 'Energy Supplier');

-- Insert Employees
INSERT INTO ERP_EMPLOYEE (
       EMPLOYEE_NAME,
       DEPARTMENT,
       POSITION,
       START_DATE,
       EMPLOYEE_PHONE,
       EMPLOYEE_EMAIL,
       EMPLOYEE_ADDRESS,
       SALARY,
       BANK_ACCOUNT)
VALUES (
       'boy',
       '資訊部',
       '專案經理',
       '2025-05-04',
       '09123456789',
       'test01@example.com',
       'taipei',
       50000,
       123456789012
);

-- Insert Warehouse
INSERT INTO ERP_WAREHOUSE (
       WAREHOUSE_NAME,
       WAREHOUSE_ADDRESS,
       CONTACT_PERSON
       )
       VALUES (
       '工作室',
       '高雄市',
       '高雄先生'
       );