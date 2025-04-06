package com.throwjava.web.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.throwjava.web.auth.model.service.AuthService;
import com.throwjava.web.auth.model.vo.CustomUserDetails;
import com.throwjava.web.board.model.dao.BoardMapper;
import com.throwjava.web.board.model.dto.AnswerDTO;
import com.throwjava.web.board.model.dto.QuestionDTO;
import com.throwjava.web.board.model.vo.Answer;
import com.throwjava.web.board.model.vo.Question;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    
    private final BoardMapper mapper;
    private final AuthService authService;
    
    @Override
    public void questionSave(QuestionDTO question) {
        
        String memberId = getMemberId();
        Question requestQuestion = Question.builder()
                .memberId(memberId)
                .questionTitle(question.getQuestionTitle())
                .questionContent(question.getQuestionContent())
                .build();

        mapper.questionSave(requestQuestion);
    }
    
    @Override
    public void answerSave(AnswerDTO answer) {

        String memberId = getMemberId();
        Answer requestAnswer = Answer.builder()
                .memberId(memberId)
                .refBoardNo(answer.getRefBoardNo())
                .answerContent(answer.getAnswerContent())
                .build();
        mapper.answerSave(requestAnswer);
    }

    private String getMemberId() {
        CustomUserDetails user = authService.selectUserDetails();
        String memberId = user.getUsername();
        return memberId;
    }

    @Override
    public void answerNonRecommend(AnswerDTO answerResponse) {
        
        
    }

    @Override
    public void answerRecommend(AnswerDTO answerResponse) {

        
    }

    @Override
    public void answerResponse(AnswerDTO answerResponse) {

    }


    @Override
    public void answerUpdate(AnswerDTO answer) {

    }

    @Override
    public void deleteAnswerById(Long answerNo) {

        
    }

    @Override
    public void deleteQuestionById(Long questionNo) {

        
    }

    @Override
    public void increaseViewCount(Long questionNo) {
  
        
    }

    @Override
    public void questionDeleteResponse(QuestionDTO questionResponse) {
    
        
    }

    @Override
    public void questionNonRecommend(QuestionDTO questionResponse) {

    }

    @Override
    public void questionRecommend(QuestionDTO questionResponse) {
   
        
    }


    @Override
    public void questionUpdate(QuestionDTO question) {

        
    }

    @Override
    public List<QuestionDTO> selectAll(int pageNo) {
        
        return null;
    }

    @Override
    public List<AnswerDTO> selectAnswerByQuestionNo(Long questionNo) {
        return null;
    }

    @Override
    public List<QuestionDTO> selectBySave(int pageNo) {
        return null;
    }

    @Override
    public List<QuestionDTO> selectByViewCount(int pageNo) {
        return null;
    }

    @Override
    public QuestionDTO selectQuestionById(Long questionNo) {
        return null;
    }
    
}
