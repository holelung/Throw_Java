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
public class QuestionDTO {

    private Long questionNo;
    private String memberId;
    @NotBlank(message = "제목은 필수 입력사항입니다.")
    private String questionTitle;
    @NotBlank(message = "공백으로 질문을 작성할 수 없습니다.")
    private String questionContent;
    private Long viewCount;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
    private String isDeleted;
}
