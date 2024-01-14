package com.example.demo.service;

import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public Article update(Long id,ArticleForm dto){
        //1.dto -> entity 변환
        Article article = dto.toEntity();
        //2. 타깃 조회
        Article target = articleRepository.findById(id).orElse(null);
        //3. 잘못된 요청 처리
        if(target == null || id!=article.getId()){
            return null;
        }
        target.patch(article);
        Article updated = articleRepository.save(target);
        return updated;
    }

    public Article delete(Long id){
        //1.대상찾기
        Article target =articleRepository.findById(id).orElse(null);
        //2.잘못된 요청 처리
        if(target == null){
            return null;
        }

        //3.대상삭제
        articleRepository.delete(target);
        return target;
    }


    @Transactional
    public List<Article> createArticels(List<ArticleForm> dtos) {
        //1.dto 묶음을 엔티티 묶으믕로 변환
        List<Article> articleList =dtos.stream()
                .map(dto->dto.toEntity())
                .collect(Collectors.toList());
        //2.엔티티 묵음을 DB에 저장
        articleList.stream()
                .forEach(article -> articleRepository.save(article));
        //3.강제 에외 발생
        articleRepository.findById(-1L).orElseThrow(()->new IllegalArgumentException("결제 실패"));
        //4.결과 값 반환
        return articleList;
    }
}
