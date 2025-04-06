package com.throwjava.web.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.throwjava.web.auth.model.service.AuthService;
import com.throwjava.web.auth.model.vo.CustomUserDetails;
import com.throwjava.web.board.model.dao.BoardMapper;
import com.throwjava.web.board.model.dto.AnswerDTO;
import com.throwjava.web.board.model.dto.AnswerDetailDTO;
import com.throwjava.web.board.model.dto.QuestionDTO;
import com.throwjava.web.board.model.dto.QuestionDetailDTO;
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

    

    @Override
    public void memberSaveQuestion(Long questionNo) {     
        String memberId = getMemberId();
        Map<String, Object> saves = new HashMap<>();
        saves.put("memberId", memberId);
        saves.put("questionNo", questionNo);
        mapper.memberSaveQuestion(saves);
    }

    @Override
    public List<QuestionDetailDTO> selectAll(int pageNo) {
        return mapper.selectAll(setRowBounds(pageNo, 5));
    }
    
    @Override
    public List<QuestionDetailDTO> selectBySave(int pageNo) {
        String memberId = getMemberId();
        RowBounds rowBounds = setRowBounds(pageNo, 5);
        return mapper.selectBySave(memberId, rowBounds);
    }
    

    @Override
    public List<QuestionDetailDTO> selectByViewCount(int pageNo) {
        return mapper.selectByViewCount(setRowBounds(pageNo, 5));
    }
    
    @Override
    public QuestionDetailDTO selectQuestionById(Long questionNo) {
        mapper.increaseViewCount(questionNo);
        return mapper.selectQuestionById(questionNo);
    }
    
    @Override
    public List<AnswerDetailDTO> selectAnswerByQuestionNo(Long questionNo) {
        return mapper.selectAnswerByQuestionNo(questionNo);
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


    // memberId 조회
    private String getMemberId() {
        CustomUserDetails user = authService.selectUserDetails();
        String memberId = user.getUsername();
        return memberId;
    }
    
    // RowBounds 생성
    private RowBounds setRowBounds(int pageNo, int size) {
        return new RowBounds(pageNo * size, size);
    }
}
