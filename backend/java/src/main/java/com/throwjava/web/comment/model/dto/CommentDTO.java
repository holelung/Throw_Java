package com.throwjava.web.comment.model.dto;

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
public class CommentDTO {
    private Long commentNo;
    private Long refBoardNo;
    private String commentWriter;
    private String commentContent;
    private LocalDateTime createTime;
    private String isDeleted;
}
