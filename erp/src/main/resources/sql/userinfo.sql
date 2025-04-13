CREATE TABLE USERINFO (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    UserName VARCHAR(255),
    PassWord VARCHAR(255),
    EmployeeId INT,
    RoleId INT,
    LastLoginTime DATE,
    Status VARCHAR(255)
);

INSERT INTO USERINFO (UserName, PassWord, EmployeeId, RoleId, LastLoginTime, Status)
VALUES ('luke82831@gmail.com', '123456', 1, 1, '2025-04-13', 'ACTIVE');