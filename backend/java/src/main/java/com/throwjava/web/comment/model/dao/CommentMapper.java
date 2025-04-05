package com.throwjava.web.comment.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.throwjava.web.comment.model.dto.CommentDTO;
import com.throwjava.web.comment.model.vo.Comment;

@Mapper
public interface CommentMapper {
    
    /* POST */
    void insertCommentToQuestion(Comment comment);

    void insertCommentToAnswer(Comment comment);

    /* GET */
    List<CommentDTO> selectQuestionCommentList(Long questionNo);

    List<CommentDTO> selectAnswerCommentLists(Long answerNo);

    /* UPDATE */
    void updateQuestionComment(Comment comment);

    void updateAnswerComment(Comment comment);

    void deleteQuestionComment(Comment comment);

    void deleteAnswerComment(Comment comment);

}
