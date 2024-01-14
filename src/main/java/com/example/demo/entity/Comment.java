package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // 테이블 맵핑
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //대표키
    @ManyToOne //필요시 one to many도있음
    @JoinColumn(name="article_id")
    private Article article;
    @Column
    private String nickname; //댓글 단사람
    @Column
    private String body; // 댓글 본문
}
