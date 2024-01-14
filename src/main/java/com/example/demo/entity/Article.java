package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id //key값 대표값
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동생성 기능
    private Long id;

    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String date;
    @Column
    private String time;
    @Column
    private String ip;

    public Article(Long id, String title, String content) {
        this.id =id;
        this.title=title;
        this.content=content;
    }

    public void patch(Article article){
        if(article.title!=null){
            this.title =  article.title;
        }
        if(article.content!=null){
            this.content=article.content;
        }


    }
}
