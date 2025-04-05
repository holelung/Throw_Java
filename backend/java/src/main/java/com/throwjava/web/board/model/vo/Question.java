package com.throwjava.web.board.model.vo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Question {
    
    private Long questionNo;
    private String memberId;
    private String questionTitle;
    private String questionContent;
    private Long viewCount;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
    private String isDeleted;
}
