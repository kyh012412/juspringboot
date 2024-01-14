package com.example.demo;

import com.example.demo.entity.Article;
import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.util.CommonsLogWriter;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
@DisplayName("test1")
public class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;//commentRepository객체 주입
    @Test
    @DisplayName("show reply")
    void findByArticleId(){
        //1.입력 데이터 준비
        Long articleId = 4L;
        //2.실제 데이터
        List<Comment> comments = commentRepository.findByArticleId(articleId);

        //3.예상 데이터
        Article article = new Article(4L,"what is your favorite movie genre?","answer me");
        Comment a = new Comment(1L,article,"park","comedy");
        Comment b = new Comment(2L,article,"kim","horror");
        Comment c = new Comment(3L,article,"lee","action");
        List<Comment> expected = Arrays.asList(a,b,c);
        //4.비교 및 검증
        Assertions.assertEquals(expected.toString(),comments.toString());
        System.out.println("테스트완료");


    }


}