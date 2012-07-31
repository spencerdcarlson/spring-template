/* ::instruction:: */
/* | instruction_id | instruction_name | instruction_txt | */
INSERT INTO `instruction` VALUES 
(1,'1A & 1B','Important: Use only a #2 or HB pencil on your red answer sheet. Be sure to put your name, ID number, and test form on the answer sheet. Be careful not to fold, bend, or tear your answer sheet.'),
(2,'1A Section 1, 1B Section 1','INSTRUCTIONS: On your red answer sheet, mark \"A\" if the sentence is correct or \"B\" if it contains an apostrophe error. Please do not write on this test booklet'),
(3,'1A Section 2, 1B Section 2','INSTRUCTIONS: Fill in the blank by choosing the correct contraction, plural, or possesive form from the choices provided, and mark the correct answer on your red answer sheet.');

/* ::section:: */
/* section_id | has_child | section_name | instruction_id | parent_id */

INSERT INTO `section` VALUES 
(1,1,'Reading Writing Center', NULL,NULL),
(2,1,'Microlab 1A Quiz - Apostrophes',1,1),
(3,0,'Section 1: Recognizing Apostrophe Errors',2,2),
(4,0,'Section 2: Using Apostrophes Correctly',3,2),
(5,1,'Microlab 1B Quiz - Apostrophes',1,1),
(6,0,'Section 1: Recognizing Apostrophe Errors',2,5),
(7,0,'Section 2: Using Apostrophes Correctly',3,5);

/* :: RESOURCE :: */
/* | resource_id | resource_name | resource_type | section_id | */
INSERT INTO `resource` VALUES
(1,'1A-1',NULL,2),
(2,'1A-2',NULL,2),
(3,'1A-3',NULL,2),
(4,'1A-1',NULL,3),
(5,'1A-2',NULL,3);

/* :: USER :: */
/* | user_id | user_name | */
INSERT INTO `user` VALUES 
(1,'Spencer Carlson'),
(2,'Nick Nguyen');





/* ::questions:: */
/* | question_id | question_answer | question_options | question_txt | section_id | reference | */

INSERT INTO `question` VALUES 
(1,'B', 'A//B','Please check to see if shes ready.', "I", 3 ),
(2,'A','A//B','One of our employees has two M.A.\'s.', "VIII", 3),
(3,'B','A//B','The student union had a game room with six color TV\'s.', "IX", 3),
(4,'B','A//B','We agreed that Jacks beard looked scraggly.', "III", 3),
(5,'B','A//B','I applied to several colleges in the fall of 84.', 3, "X"),
(6,'A','A//B','The first seat in the seventh row is hers.', "VI", 3),
(7,'B','A//B','We must decide before its too late.', "I", 3),
(8,'A','A//B','In the winter of \'83, I went to Florida.', "X", 3),
(9,'A','A//B','Perhaps yesterday\'s problems should not influence our decision.', "III", 3),
(10,'B','A//B','Janis and Katrina visited the childrens zoo.', "V", 3),
(11,'B','A//B','An usher found someones purse under a seat.', "VII", 3),
(12,'B','A//B','I cleaned all six of the rabbits cages.', "IV", 3),
(13,'B','A//B','Weighing more than a ton, the ships anchor had to be lifted by a hoist.', "III", 3),
(14,'B','A//B','Their\'s will arrive a day or two after your tickets arrive', "VI", 3),
(15,'A','A//B','One nurse was responsible for taking the nine babies\' temperatures.', "IV", 3),
(16,'isn\'t','isn\'t//is\'nt', 'Getting a good grade in my chemistry class // easy.', "I", 4),
(17,'B.A.\'s','B.A.s//B.A.\'s', 'The University gave 4,200 // last year.', "VIII", 4),
(18,'Faulkner\'s','Faulkners // Faulkner\'s','We read one of // novels.', "II", 4),
(19,'its','its//it\'s', 'The man who tuned our piano said that // strings were brittle.', "VI", 4),
(20,'peaches\'','peaches//peaches\'', 'We could not account for the // odd taste.', "IV", 4),
(21,'geese\'s','geese\'s//geeses', 'The // survival depends upon preserving their nesting ground.', "V", 4),
(22,'else\'s','else\'s//elses', 'The leaky roof is someone // problem.', "II", 4),
(23,'Everyone\'s','Everyones//Everyone\'s', '// favorite class at this university is English 101.', "VII", 4),
(24,'\'60s','\'60s//60s', 'Wide ties were popular in the //', "X", 4),
(25,'he\'s','hes//he\'s', 'I think // going to arrive tomorrow', "I", 4);