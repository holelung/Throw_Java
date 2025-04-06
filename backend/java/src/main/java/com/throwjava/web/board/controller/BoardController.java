package com.throwjava.web.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.throwjava.web.board.model.dto.AnswerDTO;
import com.throwjava.web.board.model.dto.QuestionDTO;
import com.throwjava.web.board.model.service.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    
    private final BoardService boardService;
    
    @PostMapping("/question")
    public ResponseEntity<?> questionSave(@RequestBody @Valid QuestionDTO question) {
        log.info("question:{}", question);
        boardService.questionSave(question);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/answer")
    public ResponseEntity<?> answerSave(@RequestBody @Valid AnswerDTO answer) {
        log.info("answer:{}", answer);
        boardService.answerSave(answer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
