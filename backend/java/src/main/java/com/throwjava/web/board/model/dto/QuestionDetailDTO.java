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
public class QuestionDetailDTO {
    private Long questionNo;
    private String questionTitle;
    private String questionContent;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
    private Long viewCount;
    private String isDeleted;

    private String memberId;
    private String memberName;

    private Long recommendScore;
    private Long answerCount;
}
