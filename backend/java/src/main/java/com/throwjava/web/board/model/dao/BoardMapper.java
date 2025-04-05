package com.throwjava.web.board.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.throwjava.web.board.model.dto.AnswerDTO;
import com.throwjava.web.board.model.dto.QuestionDTO;
import com.throwjava.web.board.model.vo.Answer;
import com.throwjava.web.board.model.vo.AnswerResponse;
import com.throwjava.web.board.model.vo.Question;
import com.throwjava.web.board.model.vo.QuestionResponse;

@Mapper
public interface BoardMapper {
    
    // POST
    // 질문 작성
    void questionSave(Question question);
    // 답변 작성
    void answerSave(Answer answer);

    // GET
    // 전체조회(Recently Add)
    List<QuestionDTO> selectAll(RowBounds rb);
    // 전체조회(ViewCount 많은순)
    List<QuestionDTO> selectByViewCount(RowBounds rb);
    // 저장한 질문 조회
    List<QuestionDTO> selectBySave(RowBounds rb);
    // 상세조회
    QuestionDTO selectQuestionById(Long questionNo);

    // 댓글 조회
    List<AnswerDTO> selectAnswerByQuestionNo(Long questionNo);

    /* UPDATE */ 
    // 질문 수정
    void questionUpdate(Question question);
    // 질문 삭제
    void deleteQuestionById(Long questionNo);
    // 답변 수정
    void answerUpdate(Answer answer);
    // 답변 삭제
    void deleteAnswerById(Long answerNo);

    // 조회수
    void increaseViewCount(Long questionNo);

    /* 반응 처리(추천 비추천) */
    // 질문 추천
    void questionRecommend(QuestionResponse questionResponse);
    // 질문 비추천
    void questionNonRecommend(QuestionResponse questionResponse);
    // 질문 반응 삭제
    void questionDeleteResponse(QuestionResponse questionResponse);

    // 답변 추천
    void answerRecommend(AnswerResponse answerResponse);
    //  답변 비추천
    void answerNonRecommend(AnswerResponse answerResponse);
    //  답변 반응 삭제
    void answerDeleteResponse(AnswerResponse answerResponse);
}
