package com.example.demo;

import com.example.demo.dto.CommentDto;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;
    //댓글조회
    @GetMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long articleId){
        List<CommentDto> dtos = commentService.comments(articleId);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    //댓글생성
    @PostMapping("/api/articles/{articleId}")
    public ResponseEntity<CommentDto> c1(@PathVariable Long articleId, @RequestBody CommentDto dto){
        return null;
    }

    
    //댓글수정
    
    //댓글삭제
}
