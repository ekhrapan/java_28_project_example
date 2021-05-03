CREATE DATABASE java_28_db;
USE java_28_db;

CREATE TABLE schools(
	id INT AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE students(
	id INT AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    school_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (school_id) REFERENCES schools(id)
);