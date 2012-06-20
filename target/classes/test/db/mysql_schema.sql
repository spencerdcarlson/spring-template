drop table if exists question;

CREATE table question ( 
question_id integer primary key auto_increment,
question varchar(45) not null,
answer varchar(45) not null,
options varchar(45) not null
);