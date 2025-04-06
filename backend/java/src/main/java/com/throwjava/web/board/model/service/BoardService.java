package com.throwjava.web.board.model.service;

import java.util.List;

import com.throwjava.web.board.model.dto.AnswerDTO;
import com.throwjava.web.board.model.dto.AnswerDetailDTO;
import com.throwjava.web.board.model.dto.QuestionDTO;
import com.throwjava.web.board.model.dto.QuestionDetailDTO;

public interface BoardService {
    
    void questionSave(QuestionDTO question);

    void answerSave(AnswerDTO answer);

    void memberSaveQuestion(Long questionNo);

    List<QuestionDetailDTO> selectAll(int pageNo);

    List<QuestionDetailDTO> selectByViewCount(int pageNo);

    List<QuestionDetailDTO> selectBySave(int pageNo);

    QuestionDetailDTO selectQuestionById(Long questionNo);

    List<AnswerDetailDTO> selectAnswerByQuestionNo(Long questionNo);

    void questionUpdate(QuestionDTO question);

    void deleteQuestionById(Long questionNo);

    void answerUpdate(AnswerDTO answer);

    void deleteAnswerById(Long answerNo);

    void increaseViewCount(Long questionNo);

    void questionRecommend(QuestionDTO questionResponse);

    void questionNonRecommend(QuestionDTO questionResponse);

    void questionDeleteResponse(QuestionDTO questionResponse);

    void answerRecommend(AnswerDTO answerResponse);

    void answerNonRecommend(AnswerDTO answerResponse);

    void answerResponse(AnswerDTO answerResponse);
    
}
