DROP TABLE IF EXISTS access;  
CREATE TABLE access (
userid INT AUTO_INCREMENT PRIMARY KEY,  
fullname VARCHAR(100) NOT NULL,  
username VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL
);
