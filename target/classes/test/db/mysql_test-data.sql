/* Must hard code the id's  OR use MySQLMaxValueIncrementer */

INSERT INTO question ( question_id, question, answer, options) 
VALUES ( 0, 'The dog // on the chair', 'jumped', 'jumped // bounced');

INSERT INTO question ( question_id, question, answer, options) 
VALUES ( 1, 'The cat // on the couch', 'sat', 'sat // sits // sit');