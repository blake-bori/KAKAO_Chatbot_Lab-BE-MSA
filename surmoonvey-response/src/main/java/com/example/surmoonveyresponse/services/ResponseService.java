package com.example.surmoonveyresponse.services;

import com.example.surmoonveyresponse.dto.response.RequestSubmitAnswerDto;
import com.example.surmoonveyresponse.dto.response.RequestSubmitSurveyDto;
import com.example.surmoonveyresponse.dto.response.ResponseSurveyDto;
import com.example.surmoonveyresponse.models.*;
import com.example.surmoonveyresponse.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ResponseService {

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    ChoiceAnswerRepository choiceAnswerRepository;

    @Autowired
    ResponseRepository responseRepository;

    @Autowired
    ChoiceResponseRepository choiceResponseRepository;

    @Autowired
    SubjectiveResponseRepository subjectiveResponseRepository;

    @Transactional(readOnly = true)
    public ResponseSurveyDto getSurveyTemplate(Long id) {
        // 설문id에 대한 설문 table의 정보 가져옴
        Survey survey = surveyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 설문이 없습니다. id=" + id));

        // 설문id에 대한 질문 table의 정보리스트 가져옴
        List<Question> questionList = questionRepository.findQuestionList(id);

        // 객관식형 질문에 대한 답변 table의 정보리스트 가져옴
        Map<Long, List<ChoiceAnswer>> choiceAnswerList = new HashMap<>();
        for (Question question : questionList) {
            if (question.getQuestionType() == 1) {
                Long questionId = question.getQuestionId();
                choiceAnswerList.put(questionId, choiceAnswerRepository.findAnswerList(questionId));
            }
        }

        return new ResponseSurveyDto(survey, questionList, choiceAnswerList);
    }

    @Transactional
    public Long submitSurvey(RequestSubmitSurveyDto requestDto) {
        Response responseId = responseRepository.save(requestDto.toResponseEntity());

        for (RequestSubmitAnswerDto answer : requestDto.getQuestionCardList()) {
            if (answer.getQuestionType() == 1) {
                for(ChoiceResponse response:answer.toChoiceResponseEntity(responseId)){
                    choiceResponseRepository.save(response);
                }

            } else {
                subjectiveResponseRepository.save(answer.toSubjectiveResponseEntity(responseId));
            }
        }

        // 응답 ID를 반환
        return responseId.getResponseId();
    }
}