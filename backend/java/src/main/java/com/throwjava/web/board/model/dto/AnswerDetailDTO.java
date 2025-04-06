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
public class AnswerDetailDTO {
    private Long answerNo;
    private String answerContent;
    private LocalDateTime createTime;
    private Long refBoardNo;

    private String memberId;
    private String memberName;

    private Long recommendScore;
}
