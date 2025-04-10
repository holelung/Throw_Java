package com.throwjava.web.comment.model.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "댓글을 공백으로 등록할 수 없습니다.")
    private String commentContent;
    private LocalDateTime createTime;
    private String isDeleted;
}
