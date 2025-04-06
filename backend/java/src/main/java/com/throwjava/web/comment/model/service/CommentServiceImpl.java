package com.throwjava.web.comment.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.throwjava.web.auth.model.service.AuthService;
import com.throwjava.web.auth.model.vo.CustomUserDetails;

import com.throwjava.web.comment.model.dao.CommentMapper;
import com.throwjava.web.comment.model.dto.CommentDTO;
import com.throwjava.web.comment.model.dto.CommentUpdateDTO;
import com.throwjava.web.comment.model.vo.Comment;
import com.throwjava.web.exception.ContentNullPointerException;
import com.throwjava.web.exception.UnauthorizedAccessException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMapper mapper;
    private final AuthService authService;
    
    private String getMemberId() {
        CustomUserDetails user = authService.selectUserDetails();
        String memberId = user.getUsername();
        return memberId;
    }

    // 댓글 등록
    @Override
    public void insertCommentToAnswer(CommentDTO comment) {
        String memberId = getMemberId();
        comment.setCommentWriter(memberId);

        Comment request = Comment.builder()
                .commentWriter(memberId)
                .refBoardNo(comment.getRefBoardNo())
                .commentContent(comment.getCommentContent())
                .build();
        mapper.insertCommentToAnswer(request);
    }

    @Override
    public void insertCommentToQuestion(CommentDTO comment) {
        String memberId = getMemberId();
        comment.setCommentWriter(memberId);

        Comment request = Comment.builder()
                .commentWriter(memberId)
                .refBoardNo(comment.getRefBoardNo())
                .commentContent(comment.getCommentContent())
                .build();
        mapper.insertCommentToAnswer(request);
    }

    // 댓글조회
    @Override
    public List<CommentDTO> selectAnswerCommentList(Long answerNo) {
        return mapper.selectAnswerCommentList(answerNo);
    }

    @Override
    public List<CommentDTO> selectQuestionCommentList(Long questionNo) {
        return mapper.selectQuestionCommentList(questionNo);
    }

    

    // 댓글 수정
    @Override
    public void updateAnswerComment(CommentUpdateDTO comment) {
        checkContent(comment.getCommentContent());
        mapper.updateAnswerComment(checkMemberId(comment));
    }
    
    @Override
    public void updateQuestionComment(CommentUpdateDTO comment) {
        checkContent(comment.getCommentContent());
        mapper.updateAnswerComment(checkMemberId(comment));
    }

    private Comment checkMemberId(CommentUpdateDTO comment) {
        String authMemberId = getMemberId();
        if (!comment.getCommentWriter().equals(authMemberId)) {
            throw new UnauthorizedAccessException("댓글 수정권한이 없습니다.");
        }
        Comment updateComment = Comment.builder()
                .commentNo(comment.getCommentNo())
                .commentContent(comment.getCommentContent())
                .build();
        return updateComment;
    }
    
    private void checkContent(String commentContent) {
        
        if (commentContent == null) {
            throw new ContentNullPointerException("공백으로 수정할 수 없습니다.");
        }
    }

    // 댓글 삭제
    @Override
    public void deleteAnswerComment(CommentUpdateDTO comment) {
        checkMemberId(comment);
        mapper.deleteAnswerComment(comment.getCommentNo());
    }
    
    @Override
    public void deleteQuestionComment(CommentUpdateDTO comment) {
        checkMemberId(comment);
        mapper.deleteQuestionComment(comment.getCommentNo());
    }
    
}
