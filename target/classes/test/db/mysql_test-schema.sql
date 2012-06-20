DROP TABLE if EXISTS question;

/* Test can't use AUTO_INCREMENT for primary key */
CREATE TABLE question ( 
question_id INTEGER PRIMARY KEY,
question varchar(45) NOT NULL,
answer varchar(45) NOT NULL,
options varchar(45) NOT NULL
);

