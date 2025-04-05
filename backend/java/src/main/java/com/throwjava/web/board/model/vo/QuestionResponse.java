package com.throwjava.web.board.model.vo;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class QuestionResponse {
    private Long questionNo;
    private String memberId;
}
