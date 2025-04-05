package com.throwjava.web.board.model.vo;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AnswerResponse {
    private Long answerNo;
    private String memberId;
}
