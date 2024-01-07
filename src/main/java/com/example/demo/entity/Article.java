package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id //key값 대표값
    @GeneratedValue // 자동생성 기능
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
}
