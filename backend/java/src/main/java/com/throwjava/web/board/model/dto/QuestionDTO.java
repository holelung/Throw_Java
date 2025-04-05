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
public class QuestionDTO {

    private Long questionNo;
    private String memberId;
    private String questionTitle;
    private String questionContent;
    private Long viewCount;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
    private String isDeleted;
}
