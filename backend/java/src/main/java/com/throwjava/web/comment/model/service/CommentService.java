package com.throwjava.web.comment.model.service;

import java.util.List;

import com.throwjava.web.comment.model.dto.CommentDTO;
import com.throwjava.web.comment.model.dto.CommentUpdateDTO;

public interface CommentService {
    
    void insertCommentToQuestion(CommentDTO comment);

    void insertCommentToAnswer(CommentDTO comment);

    List<CommentDTO> selectQuestionCommentList(Long questionNo);

    List<CommentDTO> selectAnswerCommentList(Long answerNo);

    void updateQuestionComment(CommentUpdateDTO comment);

    void updateAnswerComment(CommentUpdateDTO comment);

    void deleteQuestionComment(CommentUpdateDTO comment);

    void deleteAnswerComment(CommentUpdateDTO comment);
    
}
