package com.throwjava.web.comment.model.vo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Comment {
    private Long commentNo;
    private Long refBoardNo;
    private String commentWriter;
    private String commentContent;
    private LocalDateTime createTime;
    private String isDeleted;
}
