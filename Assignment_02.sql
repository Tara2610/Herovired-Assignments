-- Exercise 1
CREATE DATABASE OnlineConsultationAndTherepy;

CREATE TABLE Doctor
(Doc_id INT PRIMARY KEY NOT NULL, Doc_name VARCHAR(20) NOT NULL,Doc_dep_id INT NOT NULL, Doc_specialization VARCHAR(30) NOT NULL, Doc_gender VARCHAR(10) NOT NULL, Doc_contact INT, Doc_status VARCHAR(20) NOT NULL);
CREATE TABLE Appointments
(App_id INT PRIMARY KEY NOT NULL, Patient_id INT NOT NULL, Doc_id INT NOT NULL, App_date DATE NOT NULL, App_status VARCHAR(20) NOT NULL); 
CREATE TABLE Patient
(Patient_id INT PRIMARY KEY NOT NULL, Patient_name VARCHAR(20) NOT NULL, Patient_DOB DATE NOT NULL, Patient_gender VARCHAR(10) NOT NULL, Patient_contact INT NOT NULL, Patient_email VARCHAR(20));
CREATE TABLE Reviews
(Review_id INT PRIMARY KEY NOT NULL, Patient_id INT, Doc_id INT NOT NULL, Review_date DATE, Rating_1_to_5 INT NOT NULL, Comments VARCHAR(100), Anonymous BOOL NOT NULL);

INSERT INTO Doctor VALUES
(101, 'Dr.jaya', 1001, 'Gynocologist', 'Female', 1234567890, "Active" ),
(102, 'Dr.Ram', 1002, 'ENT', 'male', 1234567891, "Active" ),
(103, 'Dr.Anne', 1003, 'Dermatologist', 'Female', 1234567892, "Active" ),
(104, 'Dr.Bharat', 1004, 'Physician', 'Male', 1234567893, "Retired" ),
(105, 'Dr.Aria', 1005, 'Therapist', 'Female', 1234567894, "On leave" );

INSERT INTO Appointments VALUES
(1234, 3201, 101, '2022-05-20',"Completed"),
(1235, 3202, 102, '2023-05-20',"Scheduled"),
(1236, 3203, 103, '2023-05-03',"Completed"),
(1237, 3201, 104, '2022-03-26',"Cancelled"),
(1238, 3204, 105, '2022-10-26',"Completed");

INSERT INTO Patient VALUES
(3201, 'Tara', '2003-10-26', 'Female', 0987654321, 'tara@gmail.com'),
(3202, 'Sansa', '1997-11-26', 'Female', 0987654322, 'sansa@gmail.com'),
(3203, 'John', '2000-03-22', 'Male', 0987654323, 'john@gmail.com'),
(3204, 'Bharat', '2004-08-26', 'Male', 0987654324, 'bharat1@gmail.com'),
(3205, 'Pranjal', '1999-02-10', 'Male', 0987654325, 'pranjal@gmail.com');

INSERT INTO Reviews VALUES
(260, 3201, 101,'2022-05-22', 4, 'Got a detailed diagnosis at a reasonable price', FALSE),
(261, 3203, 103,'2023-05-05', 5, 'Glad i visited. My skin is finally improving', TRUE),
(262, 3204, 105,'2022-11-20', 4, 'Made me feel like its a safe place for me share my thoughts and feelings.', FALSE);

-- Exercise 2
CREATE TABLE Contact_table
(id INT PRIMARY KEY NOT NULL, Email VARCHAR(20) NOT NULL, fname VARCHAR(20) NOT NULL, lname VARCHAR(20), company VARCHAR(10) NOT NULL, Active_flag INT NOT NULL, opt_out INT NOT NULL);

INSERT INTO Contact_table VALUES
(123, 'a@a.com','Kian', 'Seth', 'ABC', 1,1),
(133, 'b@a.com','Neha', 'Seth', 'ABC', 1,0),
(234, 'c@c.com','Puru', 'Malik', 'CDF', 0,0),
(342, 'd@d.com','Sid', 'Maan', 'TEG', 1,0);

-- Question 1
SELECT * FROM Contact_table WHERE Active_flag = 1;

-- Question 2
UPDATE Contact_table SET Active_flag = 0 WHERE opt_out = 1;

-- Question 3
DELETE FROM Contact_table WHERE company = 'ABC';

-- Question 4
INSERT INTO Contact_table VALUES (658, 'mili@gmail.com', 'mili',NULL,'DGH',1,1);

-- Question 5
SELECT DISTINCT company FROM Contact_table;

-- Question 6
UPDATE Contact_table SET fname = 'niti' WHERE fname = 'mili';


-- Execise 3
CREATE TABLE customer
(customer_id INT PRIMARY KEY NOT NULL, cust_name VARCHAR(20), city VARCHAR(20), grade INT, salesman_id INT NOT NULL);
CREATE TABLE salesman
(salesman_id INT NOT NULL PRIMARY KEY, name VARCHAR(20), city VARCHAR(20), commission INT);
INSERT INTO customer VALUES
(3002, 'Nick Rimando', 'New York', 100, 5001),
(3007, 'Brad Davis', 'New York', 200, 5001),
(3005, 'raham Zusi', 'New York', 200, 5002),
(3008, 'Julian Green', 'New York', 300, 5002),
(3004, 'Fabian Johnson', 'New York', 300, 5006),
(3009, 'Geoff Cameron', 'New York', 100, 5003),
(3003, 'Jozy Altidor', 'Moscow', 200, 5007),
(3001, 'Brad Guzan', 'London', NULL, 5005);
INSERT INTO salesman VALUES
(5001, 'James Hoog', 'New York', 0.15),
(5002, 'James Hoog', 'Paris', 0.13),
(5005, 'James Hoog', 'London', 0.11),
(5006, 'James Hoog', 'Paris', 0.14),
(5007, 'James Hoog', 'Rome', 0.13),
(5003, 'James Hen', 'San jose', 0.12);

SELECT c.cust_name, c.city AS customer_city, c.grade, s.name AS salesman, s.city AS salesman_city 
FROM customer c JOIN salesman s ON c.salesman_id = s.salesman_id WHERE grade < 100
ORDER BY c.customer_id ASC;













