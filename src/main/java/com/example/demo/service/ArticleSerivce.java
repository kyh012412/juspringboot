package com.example.demo.service;

import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleSerivce {
    @Autowired
    private ArticleRepository articleRepository; //게시글 리파지토리 객체 주입

    public List<Article> index(){
        //비즈니스 로직+DB 처리
        return articleRepository.findAll();
    }

    public Article show(Long id){
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto){
        Article article = dto.toEntity();
        if(article.getId()!=null){
            return null;
        }
        return articleRepository.save(article);
    }

}
