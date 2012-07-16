DROP TABLE if EXISTS instruction;
CREATE TABLE `instruction` (
  `instruction_id` int(11) NOT NULL AUTO_INCREMENT,
  `instruction_name` varchar(255) DEFAULT NULL,
  `instruction_txt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`instruction_id`)
);

DROP TABLE if EXISTS section;
CREATE TABLE `section` (
  `section_id` int(11) NOT NULL AUTO_INCREMENT,
  `has_child` int(11) DEFAULT NULL,
  `section_name` varchar(255) DEFAULT NULL,
  `instruction_id` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`section_id`),
  UNIQUE KEY `section_id` (`section_id`),
  KEY `FK756F7EE512368A12` (`instruction_id`),
  KEY `FK756F7EE565B386CD` (`parent_id`),
  CONSTRAINT `FK756F7EE565B386CD` FOREIGN KEY (`parent_id`) REFERENCES `section` (`section_id`),
  CONSTRAINT `FK756F7EE512368A12` FOREIGN KEY (`instruction_id`) REFERENCES `instruction` (`instruction_id`)
);

drop table if exists question;
CREATE TABLE `question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `question_answer` varchar(255) DEFAULT NULL,
  `question_options` varchar(255) DEFAULT NULL,
  `question_txt` varchar(255) DEFAULT NULL,
  `section_id` int(11) NOT NULL,
  `reference` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  UNIQUE KEY `question_id` (`question_id`),
  KEY `FKBA823BE642E22B2` (`section_id`),
  CONSTRAINT `FKBA823BE642E22B2` FOREIGN KEY (`section_id`) REFERENCES `section` (`section_id`)
) ;

drop table if exists resource;
CREATE TABLE `resource` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT ,
  `resource_type` varchar(255) DEFAULT NULL ,
  `resource_name` varchar(255) DEFAULT NULL ,
  `secttion_id` int(11) NOT NULL ,
  PRIMARY KEY (`resource_id`) 
  UNIQUE KEY `resource_id` (`resource_id`),
  KEY `FKBA823BE642E22B3` (`secttion_id`),
  CONSTRAINT `FKBA823BE642E22B3` FOREIGN KEY (`secttion_id`) REFERENCES `section` (`secttion_id`)
  );