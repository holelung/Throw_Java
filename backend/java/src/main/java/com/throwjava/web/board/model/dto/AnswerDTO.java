package com.throwjava.web.board.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnswerDTO {
    private Long answerNo;
    private Long refBoardNo;
    private String memberId;
    private String answerContent;
    private LocalDateTime createTime;
    private String isDeleted;
}
