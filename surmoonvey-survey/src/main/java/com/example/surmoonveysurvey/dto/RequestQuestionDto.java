package com.example.surmoonveysurvey.dto;

import com.example.surmoonveysurvey.models.Question;
import com.example.surmoonveysurvey.models.Survey;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RequestQuestionDto {

    private String questionTitle;
    private Integer questionType;
    private boolean[] questionOptions;
    private List<RequestChoiceAnswerDto> questionAnswers;


    public Question toQuestionEntity(Survey surveyId, Integer questionOrder) {
        if (this.questionType == 1) {
            return Question.builder()
                    .surveyId(surveyId)
                    .questionTitle(questionTitle)
                    .questionOrder(questionOrder)
                    .questionType(questionType)
                    .isRequire(questionOptions[0])
                    .isDuplicate(questionOptions[1])
                    .isMix(questionOptions[2])
                    .build();
        } else {
            return Question.builder()
                    .questionTitle(questionTitle)
                    .surveyId(surveyId)
                    .questionOrder(questionOrder)
                    .questionType(questionType)
                    .isRequire(questionOptions[0])
                    .build();
        }
    }
}
