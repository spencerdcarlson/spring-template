drop table if exists question;

CREATE table question (
	question_id integer primary key auto_increment,
	section_id integer not null,
	question_txt varchar(200) not null,
	question_answer varchar(45) not null,
	question_options varchar(45) not null
);