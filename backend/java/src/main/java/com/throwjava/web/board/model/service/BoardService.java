package com.throwjava.web.board.model.service;

import java.util.List;

import com.throwjava.web.board.model.dto.AnswerDTO;
import com.throwjava.web.board.model.dto.AnswerDeleteDTO;
import com.throwjava.web.board.model.dto.AnswerDetailDTO;
import com.throwjava.web.board.model.dto.QuestionDTO;
import com.throwjava.web.board.model.dto.QuestionDeleteDTO;
import com.throwjava.web.board.model.dto.QuestionDetailDTO;

public interface BoardService {
    
    void questionSave(QuestionDTO question);

    void answerSave(AnswerDTO answer);

    void memberSaveQuestion(Long questionNo);

    void deleteSaveQuestion(Long questionNo);

    List<QuestionDetailDTO> selectAll(int pageNo);

    List<QuestionDetailDTO> selectByViewCount(int pageNo);

    List<QuestionDetailDTO> selectBySave(int pageNo);

    QuestionDetailDTO selectQuestionById(Long questionNo);

    List<AnswerDetailDTO> selectAnswerByQuestionNo(Long questionNo);

    void questionUpdate(QuestionDTO question);

    void deleteQuestionById(QuestionDeleteDTO question);

    void answerUpdate(AnswerDTO answer);

    void deleteAnswerById(AnswerDeleteDTO answer);

    void questionRecommend(QuestionDeleteDTO questionResponse);

    void questionNonRecommend(QuestionDeleteDTO questionResponse);

    void questionDeleteResponse(QuestionDeleteDTO questionResponse);

    void answerRecommend(AnswerDeleteDTO answerResponse);

    void answerNonRecommend(AnswerDeleteDTO answerResponse);

    void answerDeleteResponse(AnswerDeleteDTO answerResponse);
    
}
