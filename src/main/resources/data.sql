CREATE TABLE IF NOT EXISTS students(
students_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50),
last_name VARCHAR(50),
cpr varchar (50)
);

CREATE TABLE IF NOT EXISTS lessons(
lesson_id INT AUTO_INCREMENT PRIMARY KEY,
description VARCHAR(250)
fk_student INT
fk_teacher INT
);

CREATE TABLE IF NOT EXISTS teachers(
teacher_id INT AUTO_INCREMENT PRIMARY KEY,
teacher_firstname VARCHAR(50),
teacher_lastname varchar (50)
);

INSERT INTO students (first_name, last_name) VALUES ('Charles', 'Person');

INSERT INTO teachers (teacher_firstname, teacher_lastname) VALUES ('Emil', 'Andersen');

INSERT INTO lessons (description, fk_student, fk_teacher) VALUES ('Math', 1, 1);
INSERT INTO lessons (description) VALUES ('English');