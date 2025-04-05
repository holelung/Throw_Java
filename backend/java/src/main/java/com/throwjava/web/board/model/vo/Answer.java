package com.throwjava.web.board.model.vo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Answer {
    private Long answerNo;
    private Long refBoardNo;
    private String memberId;
    private String answerContent;
    private LocalDateTime createTime;
    private String isDeleted;
}
