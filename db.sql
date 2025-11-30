00000CREATE TABLE patients
(
patientId INT PRIMARY KEY,
firstName TEXT NOT NULL,
lastName TEXT NOT NULL,
patientDOB DATE NOT NULL
);

INSERT INTO patients (patientId, firstName, lastName, patientDOB) VALUES
(1, 'Micheal', 'Byrant', '1980-04-27'),
(2, 'Oscar', 'Bird', '1973-05-11'),
(3, 'Marty', 'Freidman', '1965-04-22'),
(4, 'Varg', 'Vikernes', '1972-08-11'),
(5, 'Frank', 'Kilmister', '1984-05-16');

-- check if patients are in table
SELECT * FROM patients;
0