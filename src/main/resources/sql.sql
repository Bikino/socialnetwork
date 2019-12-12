INSERT INTO person (id,first_name,last_name) VALUES (1,'Ildephonse','Bikino');
INSERT INTO person (id,first_name,last_name) VALUES (2,'Matt','Shama Bikino');
INSERT INTO person (id,first_name,last_name) VALUES (3,'Briella','Shamika');
INSERT INTO person (id,first_name,last_name) VALUES (4,'Bradyn','Shema');
INSERT INTO person (id,first_name,last_name) VALUES (5,'Norlan','Cyusa');
INSERT INTO person (id,first_name,last_name) VALUES (6,'Sofa','Uwase');

INSERT INTO post (post_id,post_text,person_id) VALUES (1,'Hello there how re u doing?',1);
INSERT INTO post (post_id,post_text ,person_id) VALUES (2,'Hello there how re u doing?',1);
INSERT INTO post (post_id,post_text ,person_id) VALUES (3,'Hello there how re u doing?',2);
INSERT INTO post (post_id,post_text ,person_id) VALUES (4,'Hello there how re u doing?',3);
INSERT INTO post (post_id,post_text ,person_id) VALUES (5,'Hello there how re u doing?',4);
INSERT INTO post (post_id,post_text ,person_id) VALUES (6,'Hello there how re u doing?',2);

INSERT INTO comment (comment_id,comment_text,post_post_id) VALUE (1,'Comment 1',1);
INSERT INTO comment (comment_id,comment_text,post_post_id) VALUE (2,'Comment 2',2);
INSERT INTO comment (comment_id,comment_text,post_post_id) VALUE (3,'Comment 3',3);
INSERT INTO comment (comment_id,comment_text,post_post_id) VALUE (4,'Comment 4',3);
INSERT INTO comment (comment_id,comment_text,post_post_id) VALUE (5,'Comment 5',4);