package com.example.demo;

import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleApiController {
    @Autowired //게시글 리파지토리 주입
    ArticleRepository articleRepository;

    //get 전체리스트
    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleRepository.findAll();
    }
    //get 단일 결과
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleRepository.findById(id).orElse(null);
    }

}
