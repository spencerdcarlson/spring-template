drop table if exists question;

CREATE TABLE question (
 question_id INT NOT NULL ,
 question VARCHAR(45) NOT NULL ,
 answer VARCHAR(45) NOT NULL ,
 options VARCHAR(45) NOT NULL,
 PRIMARY KEY (question_id) );