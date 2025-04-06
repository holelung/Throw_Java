package com.throwjava.web.comment.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.throwjava.web.comment.model.dto.CommentDTO;
import com.throwjava.web.comment.model.dto.CommentUpdateDTO;
import com.throwjava.web.comment.model.service.CommentService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    
    private final CommentService commentService;

    @PostMapping("/question")
    public ResponseEntity<?> insertCommentQuestion(@RequestBody @Valid CommentDTO comment) {
        commentService.insertCommentToQuestion(comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PostMapping("/answer")
    public ResponseEntity<?> insertCommentAnswer(@RequestBody @Valid CommentDTO comment) {
        commentService.insertCommentToAnswer(comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping("/question/{id}")
    public ResponseEntity<List<CommentDTO>> selectQuestionCommentList(
            @PathVariable(name = "id") @Min(value = 1, message = "유효하지 않은 요청입니다.") Long questionNo) {
        return ResponseEntity.ok(commentService.selectQuestionCommentList(questionNo));
    }
    
    @GetMapping("/answer/{id}")
    public ResponseEntity<List<CommentDTO>> selectAnswerCommentList(
            @PathVariable(name = "id") @Min(value = 1, message = "유효하지 않은 요청입니다.") Long answerNo) {
        return ResponseEntity.ok(commentService.selectAnswerCommentList(answerNo));
    }

    @PutMapping("/question")
    public ResponseEntity<?> updateQuestionComment(@RequestBody  CommentUpdateDTO comment) {
        commentService.updateQuestionComment(comment);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/answer")
    public ResponseEntity<?> updateAnswerComment(@RequestBody  CommentUpdateDTO comment) {
        commentService.updateAnswerComment(comment);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/question")
    public ResponseEntity<?> deleteQuestionComment(@RequestBody CommentUpdateDTO comment) {
        commentService.deleteQuestionComment(comment);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @DeleteMapping("/answer")
    public ResponseEntity<?> deleteAnswerComment(@RequestBody CommentUpdateDTO comment) {
        commentService.deleteAnswerComment(comment);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
