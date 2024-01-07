package com.example.demo;

import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

    @Autowired//의존성 주입
    private ArticleRepository articleRepository;

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
        //1.dto를 엔티티로 변환
        Article article = form.toEntity();
        //2.리파지토리로 엔티티를 db에 저장
        System.out.println(article.toString());
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return "articles/main";
    }
}