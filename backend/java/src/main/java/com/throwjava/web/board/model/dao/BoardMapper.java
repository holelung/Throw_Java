package com.throwjava.web.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.session.RowBounds;

import com.throwjava.web.board.model.dto.AnswerDeleteDTO;
import com.throwjava.web.board.model.dto.AnswerDetailDTO;
import com.throwjava.web.board.model.dto.QuestionDeleteDTO;
import com.throwjava.web.board.model.dto.QuestionDetailDTO;
import com.throwjava.web.board.model.vo.Answer;
import com.throwjava.web.board.model.vo.AnswerResponse;
import com.throwjava.web.board.model.vo.Question;
import com.throwjava.web.board.model.vo.QuestionResponse;

@Mapper
public interface BoardMapper {
    
    // POST
    // 질문 작성o
    void questionSave(Question question);
    // 답변 작성o
    void answerSave(Answer answer);
    // 멤버 저장목록에 추가o
    void memberSaveQuestion(Map<String,Object> saves);
    // 저장목록에서 삭제~
    void deleteSaveQuestion(Map<String, Object> saves);

    // GET
    // 전체조회(Recently Add)o
    List<QuestionDetailDTO> selectAll(RowBounds rb);
    // 전체조회(ViewCount 많은순)o
    List<QuestionDetailDTO> selectByViewCount(RowBounds rb);
    // 저장한 질문 조회o
    List<QuestionDetailDTO> selectBySave(String memberId, RowBounds rb);
    // 상세조회o
    QuestionDetailDTO selectQuestionById(Long questionNo);

    //  답변 조회o
    List<AnswerDetailDTO> selectAnswerByQuestionNo(Long questionNo);

    /* UPDATE */ 
    // 질문 수정
    void questionUpdate(Question question);
    // 질문 삭제
    void deleteQuestionById(QuestionDeleteDTO question);
    // 답변 수정
    void answerUpdate(Answer answer);
    // 답변 삭제
    void deleteAnswerById(AnswerDeleteDTO answer);

    // 조회수o
    void increaseViewCount(Long questionNo);

    /* 반응 처리(추천 비추천) */
    int isQuestionRecommend(QuestionResponse questionResponse);
    // 행 생성~
    void questionResponseGen(QuestionResponse questionResponse);
    // 질문 추천
    void questionRecommend(QuestionResponse questionResponse);
    // 질문 비추천
    void questionNonRecommend(QuestionResponse questionResponse);
    // 질문 반응 삭제
    void questionDeleteResponse(QuestionResponse questionResponse);

    int isAnswerRecommend(AnswerResponse answerResponse);
    // 행 생성~
    void answerResponseGen(AnswerResponse answerResponse);
    // 답변 추천
    void answerRecommend(AnswerResponse answerResponse);
    //  답변 비추천
    void answerNonRecommend(AnswerResponse answerResponse);
    //  답변 반응 삭제
    void answerDeleteResponse(AnswerResponse answerResponse);

    String isSave(Map<String, Object> saves);
}
