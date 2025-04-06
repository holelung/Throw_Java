package com.throwjava.web.board.model.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
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
public class AnswerDTO {
    private Long answerNo;
    private Long refBoardNo;
    private String memberId;
    @NotBlank(message = "공백으로 답변을 입력할 수 없습니다.")
    private String answerContent;
    private LocalDateTime createTime;
    private String isDeleted;
}
