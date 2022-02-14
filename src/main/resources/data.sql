INSERT INTO author (name,email,phone,birth_date) VALUES ('Mark Henry', 'author1@gmail.com','99999999', '1994-02-14');
INSERT INTO author (name,email,phone,birth_date) VALUES ('Toby Andrew', 'author2@gmail.com','9888888', '1991-02-14');
INSERT INTO author (name,email,phone,birth_date) VALUES ('Rebe Andrew', 'author2@gmail.com','9888888', '2009-02-14');

INSERT INTO blog (name,description,url,status,author_id) VALUES ('blog name 1','description blog 1','https://www.blog1.com','active',1);
INSERT INTO blog (name,description,url,status,author_id) VALUES ('blog name 2','description blog 2','https://www.blog2.com','inactive',2);

INSERT INTO post (tittle,date,status,content,blog_id) VALUES ('tittle post 1','2022-02-14','released','content post 1',1);
INSERT INTO post (tittle,date,status,content,blog_id) VALUES ('tittle post 2','2022-02-14','draft','content post 2',2);

INSERT INTO comment (date,name,status, post_id) VALUES ('2022-02-14T15:23:04.30','name comment 1','released', 1);
INSERT INTO comment (date,name,status, post_id) VALUES ('2022-02-14T15:23:04.30','name comment 2','draft', 2);






