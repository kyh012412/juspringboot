--기존 데이터
insert into article(title,content) values('가','1111');
insert into article(title,content) values('나','2222');
insert into article(title,content) values('다','333');
--article테이블 데이터 추가
insert into article(title,content) values('what is your favorite movie genre?','answer me');
--댓글 추가
insert into comment(article_id,nickname,body) values(4,'park','comedy');
insert into comment(article_id,nickname,body) values(4,'kim','horror');
insert into comment(article_id,nickname,body) values(4,'lee','action');
