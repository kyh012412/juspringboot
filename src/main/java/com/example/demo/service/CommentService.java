package com.example.demo.service;

import com.example.demo.dto.CommentDto;
import com.example.demo.entity.Article;
import com.example.demo.entity.Comment;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
        //1. 댓글 조회
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        //2. 엔티티 -> dto 변환
        List<CommentDto> dtos = new ArrayList<CommentDto>();
        for(int i=0;i<comments.size();i++){
            Comment c = comments.get(i);
            CommentDto dto = CommentDto.createCommentDto(c);
            dtos.add(dto);
        }
        //3. 결과값 반환
        return dtos;
    }

    @Transactional//트랜잭션 처리
    public CommentDto create(Long articleId, CommentDto dto) {
        //1.게시글 조회 및 예외 발생'
        Article article = articleRepository.findById(articleId).orElseThrow(()->new IllegalArgumentException("댓글 생성 실패"+"대상 게시글이 없습니다."));

        //2.댓글 엔티티 생성
        Comment comment = Comment.createComment(dto,article);
        //3.댓글 엔티티를 db에 저장
        Comment created = commentRepository.save(comment);
        //4.dto로 변환에 반환
        return CommentDto.createCommentDto(created);
    }

    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        //1.댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("댓글 수정 실패!"+"대상 댓글이 없습니다"));
        //2.댓글 수정
        target.patch(dto);
        //3.db로 갱신
        Comment updated = commentRepository.save(target);
        //4.댓글 엔티티를 dto로 변환 및 반환
        return CommentDto.createCommentDto(updated);
    }

    @Transactional
    public CommentDto delete(Long id) {
        //1.댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("댓글 삭제 실패! 대상이 없습니다."));
        //2.댓글 삭제
        commentRepository.delete(target);
        //3.삭제 댓글을 dto로 변환 및 반환
        return CommentDto.createCommentDto(target);
    }
}
