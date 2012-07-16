INSERT INTO `reading_writing_center`.`instruction` 
(`instruction_id`, `instruction_name`, `instruction_txt`) 
VALUES (1, 'Instruction #1', 'Fill in the blank');
INSERT INTO `reading_writing_center`.`instruction` 
(`instruction_id`, `instruction_name`, `instruction_txt`) 
VALUES (2, 'Instruction #2', 'Choose the right answer');

INSERT INTO `reading_writing_center`.`section` 
(`section_id`, `has_child`, `section_name`, `instruction_id`, `parent_id`) 
VALUES (1, 1, 'R and W', 1, NULL);
INSERT INTO `reading_writing_center`.`section` 
(`section_id`, `has_child`, `section_name`, `instruction_id`, `parent_id`) 
VALUES (2, 1, 'Lab 1', 1, 1);
INSERT INTO `reading_writing_center`.`section` 
(`section_id`, `has_child`, `section_name`, `instruction_id`, `parent_id`) 
VALUES (3, 1, 'Lab 2', 1, 1);
INSERT INTO `reading_writing_center`.`section` 
(`section_id`, `has_child`, `section_name`, `instruction_id`, `parent_id`) 
VALUES (4, 0, 'Section 1-1', 1, 2);
INSERT INTO `reading_writing_center`.`section` 
(`section_id`, `has_child`, `section_name`, `instruction_id`, `parent_id`) 
VALUES (5, 0, 'Section 1-2', 2, 2);
INSERT INTO `reading_writing_center`.`section` 
(`section_id`, `has_child`, `section_name`, `instruction_id`, `parent_id`) 
VALUES (6, 0, 'Section 2-1', 1, 3);
INSERT INTO `reading_writing_center`.`section` 
(`section_id`, `has_child`, `section_name`, `instruction_id`, `parent_id`) 
VALUES (7, 0, 'Section 2-2', 2, 3);

INSERT INTO `reading_writing_center`.`question` 
(`question_id`, `question_answer`, `question_options`, `question_txt`, `section_id`) 
VALUES (1, 'opA', 'opA//opB', 'This is question 1//question 1', 2);
INSERT INTO `reading_writing_center`.`question` 
(`question_id`, `question_answer`, `question_options`, `question_txt`, `section_id`) 
VALUES (2, 'option2', 'option 1//option 2', 'This is question 2//question 2', 2);
INSERT INTO `reading_writing_center`.`question` 
(`question_id`, `question_answer`, `question_options`, `question_txt`, `section_id`) 
VALUES (3, 'at', 'by//at', 'This is question 3//question 3', 3);
INSERT INTO `reading_writing_center`.`question` 
(`question_id`, `question_answer`, `question_options`, `question_txt`, `section_id`) 
VALUES (4, 'yahoo', 'yeah//yahoo', 'This is question 4//question 4', 3);

INSERT INTO `reading_writing_center`.`resource` (`resource_name`, `section_id`) VALUES ('1A-1', 2);
INSERT INTO `reading_writing_center`.`resource` (`resource_name`, `section_id`) VALUES ('1A-2', 2);
INSERT INTO `reading_writing_center`.`resource` (`resource_name`, `section_id`) VALUES ('1A-1', 3);
INSERT INTO `reading_writing_center`.`resource` (`resource_name`, `section_id`) VALUES ('1A-2', 3);

