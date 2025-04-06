package com.throwjava.web.comment.model.dto;

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
public class CommentUpdateDTO {

    private Long commentNo;
    private String commentWriter;
    private String commentContent;
}
