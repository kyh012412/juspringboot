package com.example.demo;

import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
public class HelloController {

    @Autowired//의존성 주입
    private ArticleRepository articleRepository;
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/hello")
    public String hello(Model model){

        model.addAttribute("age",20);
        return "hello";
    }

    @GetMapping("/main")
    public String main(Model model){
        //model.addAttribute("변수명","변수값");
        model.addAttribute("username","kyh");
        return "main";
    }

    @GetMapping("/main3")
    public String main2(Model model){
        //model.addAttribute("변수명","변수값");
        model.addAttribute("username","test");
        return "main3";
    }

    @GetMapping("/article")
    public String article(Model model){
        model.addAttribute("username","test");
        return "articles/main";//templates/articles/main.html
    }

    @PostMapping("/articles/create")
    public String articleCreate(ArticleForm form){
        System.out.println(form.toString());
        String date_time = (LocalDateTime.now()+"").split("\\.")[0];
        form.setDate(date_time.split("T")[0]);
        form.setTime(date_time.split("T")[1]);

        form.setIp(request.getRemoteAddr());

        //1.dto를 엔티티로 변환
        Article article = form.toEntity();
        //2.리파지토리로 엔티티를 db에 저장
        System.out.println(article.toString());
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return "articles/main";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id,Model model){
        //1. id를 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        //2. 모델에 데이터 등록
        model.addAttribute("article",articleEntity);

        //3.뷰 페이지 반환
        return "articles/show";
    }

    //데이터 리스트 조회
    @GetMapping("/articles")
    public String index(Model model){
        //1. 모든 데이터 가져오기
        ArrayList<Article> articlesEntityList = articleRepository.findAll();

        //2. 모델에 데이터 등록
        model.addAttribute("articleList",articlesEntityList);

        //3. 뷰페이지 설정
        return "articles/index";
    }
}