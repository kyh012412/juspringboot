--기존 데이터
insert into article(id,title,content) values(1,'가','1111');
insert into article(id,title,content) values(2,'나','2222');
insert into article(id,title,content) values(3,'다','333');
--article테이블 데이터 추가
insert into article(id,title,content) values(4,'what is your favorite movie genre?','answer me');
--댓글 추가
    insert into comment(article_id,nickname,body) values(4,'park','comedy');
insert into comment(article_id,nickname,body) values(4,'kim','horror');
insert into comment(article_id,nickname,body) values(4,'lee','action');
