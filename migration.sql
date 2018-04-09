USE omelete_db;

DROP TABLE IF EXISTS jobs;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS RestProfile;
DROP TABLE IF EXISTS EmpProfile;
DROP TABLE IF EXISTS WorkHistory;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE RestProfile(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    name VARCHAR(240) NOT NULL,
    logo VARCHAR(240) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE EmpProfile(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    name VARCHAR(240),
    photo VARCHAR(240),
    video VARCHAR(240),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE jobs (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    rest_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (rest_id) REFERENCES RestProfile(id)
);

CREATE TABLE WorkHistory(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    emp_prof_id INT UNSIGNED NOT NULL,
    name VARCHAR(240),
    position VARCHAR(240),
    hire_date DATE,
    to_date DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (emp_prof_id) REFERENCES EmpProfile(id)
);