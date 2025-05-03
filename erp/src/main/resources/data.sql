---- User
CREATE TABLE ERP_USER_INFO(
       USER_ID INT PRIMARY KEY,
       USER_NAME VARCHAR(50),
       PASSWORD VARCHAR(50),
       EMPLOYEE_ID INT,
       ROLE_ID INT,
       LAST_LOGIN_TIME TIMESTAMP NOT NULL,
       STATUS VARCHAR(50)
);

---- Suppliers
CREATE TABLE ERP_SUPPLIERS_INFO(
       SUPPLIER_ID INT PRIMARY KEY,
       SUPPLIER_NAME VARCHAR(100),
       SUPPLIER_CONTACT_PERSON VARCHAR(50),
       SUPPLIER_TELEPHONE VARCHAR(50),
       SUPPLIER_EMAIL VARCHAR(100),
       SUPPLIER_ADDRESS VARCHAR(100),
       SUPPLIER_BUSINESS_ID_NUMBER VARCHAR(20),
       SUPPLIER_PAYMENT_TERM VARCHAR(MAX),
       SUPPLIER_TYPE VARCHAR(50)

);

-- User
INSERT INTO ERP_USER_INFO (USER_ID, USER_NAME, PASSWORD, EMPLOYEE_ID, ROLE_ID, LAST_LOGIN_TIME, STATUS)
VALUES(1, '吳泓儒', '123456', 1, 1, TIMESTAMP'2025-04-14T15:16:17', 'AVAILABLE' );

-- Suppliers
INSERT INTO ERP_SUPPLIERS_INFO (
    SUPPLIER_ID,
    SUPPLIER_NAME,
    SUPPLIER_CONTACT_PERSON,
    SUPPLIER_TELEPHONE,
    SUPPLIER_EMAIL,
    SUPPLIER_ADDRESS,
    SUPPLIER_BUSINESS_ID_NUMBER,
    SUPPLIER_PAYMENT_TERM,
    SUPPLIER_TYPE
) VALUES
(1, '自行採購', '吳泓儒', '+886939789576', 'luke82831@gmail.com', '新北市蘆洲區三民路581-2號8樓', 'A129286932', '月結', '內部供應商'),
(2, '東匯玩具', 'Jane Smith', '+1-987-654-3210', 'janesmith@freshfoods.com', '5678 Market St, Townsville', '987654321', 'Cash on Delivery', 'Food Supplier'),
(3, '夥伴玩具', 'Alan Walker', '+44-20-7946-0958', 'alanw@globaltextiles.com', '10 Downing St, London', '234567891', 'Net 60 days', 'Textile'),
(4, 'maki', 'Emily Chen', '+886-2-1234-5678', 'emilyc@fastenersinc.com', '5F, No.99, Section 1, Taipei', '876543210', 'Prepaid', 'Hardware'),
(5, '龍芳有限公司', 'Michael Green', '+1-555-789-0123', 'michaelg@greenenergy.com', '888 Energy Rd, Greentown', '345678912', 'Net 45 days', 'Energy Supplier'),
(6, '雙緯企業', 'Michael Green', '+1-555-789-0123', 'michaelg@greenenergy.com', '888 Energy Rd, Greentown', '345678912', 'Net 45 days', 'Energy Supplier');

