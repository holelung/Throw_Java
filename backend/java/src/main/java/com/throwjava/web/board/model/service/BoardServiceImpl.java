package com.throwjava.web.board.model.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.throwjava.web.auth.model.service.AuthService;
import com.throwjava.web.auth.model.vo.CustomUserDetails;
import com.throwjava.web.board.model.dao.BoardMapper;
import com.throwjava.web.board.model.dto.AnswerDTO;
import com.throwjava.web.board.model.dto.AnswerDeleteDTO;
import com.throwjava.web.board.model.dto.AnswerDetailDTO;
import com.throwjava.web.board.model.dto.QuestionDTO;
import com.throwjava.web.board.model.dto.QuestionDeleteDTO;
import com.throwjava.web.board.model.dto.QuestionDetailDTO;
import com.throwjava.web.board.model.vo.Answer;
import com.throwjava.web.board.model.vo.AnswerResponse;
import com.throwjava.web.board.model.vo.Question;
import com.throwjava.web.board.model.vo.QuestionResponse;
import com.throwjava.web.exception.AlreadySaveQuestionException;
import com.throwjava.web.util.AuthUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    
    private final BoardMapper mapper;
    private final AuthService authService;
    private final AuthUtil authUtil;

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
        String result = mapper.isSave(saves);
        if (result != null) {
            throw new AlreadySaveQuestionException("이미 저장된 게시물입니다.");
        }
        mapper.memberSaveQuestion(saves);
    }

    @Override
    public void deleteSaveQuestion(Long questionNo) {
        String memberId = getMemberId();
        Map<String, Object> saves = new HashMap<>();
        saves.put("memberId", memberId);
        saves.put("questionNo", questionNo);
        mapper.deleteSaveQuestion(saves);
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

    // 수정/삭제
    @Override
    public void answerUpdate(AnswerDTO answer) {
        authUtil.checkAuthorization(answer.getMemberId());

        Answer answerRequest = Answer.builder()
                .answerNo(answer.getAnswerNo())
                .answerContent(answer.getAnswerContent())
                .build();
        mapper.answerUpdate(answerRequest);
    }
    @Override
    public void questionUpdate(QuestionDTO question) {
        authUtil.checkAuthorization(question.getMemberId());

        Question questionRequest = Question.builder()
                .questionNo(question.getQuestionNo())
                .questionTitle(question.getQuestionTitle())
                .questionContent(question.getQuestionContent())
                .modifiedTime(LocalDateTime.now())
                .build();
        mapper.questionUpdate(questionRequest);
    }

    @Override
    public void deleteAnswerById(AnswerDeleteDTO answer) {
        authUtil.checkAuthorization(answer.getMemberId());
        mapper.deleteAnswerById(answer);
    }

    @Override
    public void deleteQuestionById(QuestionDeleteDTO question) {
        authUtil.checkAuthorization(question.getMemberId());
        mapper.deleteQuestionById(question);
    }


    // 질문글 반응
    @Override
    public void questionDeleteResponse(QuestionDeleteDTO questionResponse) {
        QuestionResponse response = QuestionResponse.builder()
                .questionNo(questionResponse.getQuestionNo())
                .memberId(questionResponse.getMemberId())
                .build();
        mapper.questionDeleteResponse(response);
    }

    @Override
    public void questionNonRecommend(QuestionDeleteDTO questionResponse) {
        QuestionResponse response = QuestionResponse.builder()
                .questionNo(questionResponse.getQuestionNo())
                .memberId(questionResponse.getMemberId())
                .build();
        int result = mapper.isQuestionRecommend(response);
        if( result == 0) {
            mapper.questionResponseGen(response);   
        }
        mapper.questionNonRecommend(response);
    }

    @Override
    public void questionRecommend(QuestionDeleteDTO questionResponse) {
        QuestionResponse response = QuestionResponse.builder()
                .questionNo(questionResponse.getQuestionNo())
                .memberId(questionResponse.getMemberId())
                .build();
        int result = mapper.isQuestionRecommend(response);
        if( result == 0) {
            mapper.questionResponseGen(response);   
        }
        mapper.questionRecommend(response);
    }

    
    // 답변 반응
    @Override
    public void answerRecommend(AnswerDeleteDTO answerResponse) {
        AnswerResponse response = AnswerResponse.builder()
                .answerNo(answerResponse.getAnswerNo())
                .memberId(answerResponse.getMemberId())
                .build();
        int result = mapper.isAnswerRecommend(response);
        if (result == 0) {
            mapper.answerResponseGen(response);
        }
        mapper.answerRecommend(response);
    }
    
    @Override
    public void answerNonRecommend(AnswerDeleteDTO answerResponse) {
                AnswerResponse response = AnswerResponse.builder()
                .answerNo(answerResponse.getAnswerNo())
                .memberId(answerResponse.getMemberId())
                .build();
        int result = mapper.isAnswerRecommend(response);
        if (result == 0) {
            mapper.answerResponseGen(response);
        }
        mapper.answerNonRecommend(response);
    }


    @Override
    public void answerDeleteResponse(AnswerDeleteDTO answerResponse) {
        AnswerResponse response = AnswerResponse.builder()
                .answerNo(answerResponse.getAnswerNo())
                .memberId(answerResponse.getMemberId())
                .build();
        mapper.answerDeleteResponse(response);
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
