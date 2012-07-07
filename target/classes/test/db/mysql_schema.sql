drop table if exists question;
CREATE table question (
	question_id integer primary key auto_increment,
	section_id integer not null,
	question_txt varchar(200) not null,
	question_answer varchar(45) not null,
	question_options varchar(45) not null
);
DROP TABLE if EXISTS section;
CREATE TABLE section (
	section_id INT(11) NOT NULL PRIMARY KEY,
	parent_id INT(11) NOT NULL,
	section_name VARCHAR(45) NOT NULL,
	instruction_id INT(11) DEFAULT NULL,
	has_child INT(1) NOT NULL
);
