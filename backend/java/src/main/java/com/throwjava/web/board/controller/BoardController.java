package com.throwjava.web.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.throwjava.web.board.model.dto.AnswerDTO;
import com.throwjava.web.board.model.dto.QuestionDTO;
import com.throwjava.web.board.model.dto.QuestionDetailDTO;
import com.throwjava.web.board.model.service.BoardService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
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

    @PostMapping("/save")
    public ResponseEntity<?> memberSaveQuestion(@RequestBody Map<String, String> questionNo) {
        Long questionNumber = Long.parseLong(questionNo.get("questionNo"));
        boardService.memberSaveQuestion(questionNumber);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<QuestionDetailDTO>> selectAll(
            @RequestParam(name = "page", defaultValue = "0") int page) {
        return ResponseEntity.ok(boardService.selectAll(page));
    }

    @GetMapping("/hot")
    public ResponseEntity<List<QuestionDetailDTO>> selectByViewCount(
            @RequestParam(name = "page", defaultValue = "0") int page) {
        return ResponseEntity.ok(boardService.selectByViewCount(page));
    }

    @GetMapping("/save")
    public ResponseEntity<List<QuestionDetailDTO>> selectBySave(
            @RequestParam(name = "page", defaultValue = "0") int page) {
        return ResponseEntity.ok(boardService.selectBySave(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDetailDTO> selectQuestionById(
            @PathVariable(name = "id") @Min(value = 1, message = "잘못된 요청") Long questionNo) {
        log.info("{}", questionNo);
        return ResponseEntity.ok(boardService.selectQuestionById(questionNo));
    }
    
    @GetMapping("/answer/{id}")
    public ResponseEntity<?> selectAnswerByQuestionNo(
            @PathVariable(name = "id") @Min(value = 1, message = "잘못된 요청") Long questionNo) {
        return ResponseEntity.ok(boardService.selectAnswerByQuestionNo(questionNo));
    }
}
