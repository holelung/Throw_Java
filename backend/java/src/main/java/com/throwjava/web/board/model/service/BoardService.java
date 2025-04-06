package com.throwjava.web.board.model.service;

import java.util.List;

import com.throwjava.web.board.model.dto.AnswerDTO;
import com.throwjava.web.board.model.dto.QuestionDTO;

public interface BoardService {
    
    void questionSave(QuestionDTO question);

    void answerSave(AnswerDTO answer);

    List<QuestionDTO> selectAll(int pageNo);

    List<QuestionDTO> selectByViewCount(int pageNo);

    List<QuestionDTO> selectBySave(int pageNo);

    QuestionDTO selectQuestionById(Long questionNo);

    List<AnswerDTO> selectAnswerByQuestionNo(Long questionNo);

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
