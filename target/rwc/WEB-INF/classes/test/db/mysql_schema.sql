/* Instruction */
DROP TABLE if EXISTS instruction;
CREATE TABLE `instruction` (
  `instruction_id` int(11) NOT NULL AUTO_INCREMENT,
  `instruction_name` varchar(255) DEFAULT NULL,
  `instruction_txt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`instruction_id`)
);

/* Section */
DROP TABLE if EXISTS section;
CREATE  TABLE IF NOT EXISTS `reading_writing_center`.`section` (
  `section_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `has_child` INT(11) NULL DEFAULT NULL ,
  `section_name` VARCHAR(255) NULL DEFAULT NULL ,
  `instruction_id` INT(11) NULL DEFAULT NULL ,
  `parent_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`section_id`) ,
  UNIQUE INDEX `section_id` (`section_id` ASC) ,
  INDEX `FK756F7EE512368A12` (`instruction_id` ASC) ,
  INDEX `FK756F7EE565B386CD` (`parent_id` ASC) ,
  INDEX `fk_section_instruction1` (`instruction_id` ASC) ,
  CONSTRAINT `fk_section_instruction1`
    FOREIGN KEY (`instruction_id` )
    REFERENCES `reading_writing_center`.`instruction` (`instruction_id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = latin1

/* question */
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

/* Resource */
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

/* Progres */
drop table if exists progress;
CREATE  TABLE IF NOT EXISTS `reading_writing_center`.`progress` (
  `progress_id` INT(11) NOT NULL ,
  `user_id` INT(11) NULL DEFAULT NULL ,
  `section_id` INT NULL DEFAULT NULL ,
  PRIMARY KEY (`progress_id`) ,
  INDEX `fk_progress_users1` (`user_id` ASC) ,
  INDEX `fk_progress_section1` (`section_id` ASC) ,
  CONSTRAINT `fk_progress_users1`
    FOREIGN KEY (`user_id` )
    REFERENCES `reading_writing_center`.`users` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_progress_section1`
    FOREIGN KEY (`section_id` )
    REFERENCES `reading_writing_center`.`section` (`section_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1

/* users */
CREATE  TABLE IF NOT EXISTS `reading_writing_center`.`users` (
  `user_id` INT(11) NOT NULL ,
  `user_name` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`user_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1