package com.example.demo.dto;

import com.example.demo.entity.Article;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ArticleForm {
    private Long id;
    private String title;
    private String content;
    private String date;
    private String time;
    private String ip;

    public Article toEntity(){
        return new Article(id,title,content,date,time,ip);
    }
}
