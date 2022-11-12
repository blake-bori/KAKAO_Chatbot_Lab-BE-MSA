package com.example.surmoonveystatistic.services;

import com.example.surmoonveystatistic.dto.StatisticChoiceDto;
import com.example.surmoonveystatistic.dto.StatisticSubjectiveDto;
import com.example.surmoonveystatistic.dto.SurveyStatisticDto;
import com.example.surmoonveystatistic.models.Survey;
import com.example.surmoonveystatistic.repositories.ResponseRepository;
import com.example.surmoonveystatistic.repositories.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StatisticService {

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    ResponseRepository responseRepository;

    @Transactional(readOnly = true)
    public SurveyStatisticDto getSurveyStatistic(Long surveyId) {
        // 1. surveyId
        // 2. surveyTitle
        // 3. surveyContent
        // 4. surveyTime { start, end }
        // 5. surveyStatistic []
        // 5.1 객관식{questionId, questionOrder, type, title, answers[{answerId, answerOrder, value, cnt}]}
        // 5.2 주관식{questionId, questionOrder, type, title, answers[{value}]

        // step.1 설문 아이디를 통해 설문 정보 가져옴 (1,2,3,4 정보 획득)
        // step.2 설문 아이디에 해당하는 response
        // 설문id에 대한 설문 table의 정보 가져옴
        Survey survey = surveyRepository.findById(surveyId).orElseThrow(() -> new IllegalArgumentException("해당 설문이 없습니다. id=" + surveyId));
        List<StatisticChoiceDto> statisticChoiceDtoList=responseRepository.findStatisticChoice(surveyId);
        List<StatisticSubjectiveDto>statisticSubjectiveDtoList=responseRepository.findStatisticSubjective(surveyId);

        SurveyStatisticDto surveyStatisticDto=new SurveyStatisticDto(survey,statisticChoiceDtoList,statisticSubjectiveDtoList);
        surveyStatisticDto.sortList();

        return surveyStatisticDto;
    }
}
