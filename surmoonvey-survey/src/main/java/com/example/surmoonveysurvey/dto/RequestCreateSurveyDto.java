package com.example.surmoonveysurvey.dto;

import com.example.surmoonveysurvey.models.Survey;
import com.example.surmoonveysurvey.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RequestCreateSurveyDto {

    private User userId = null;
    private String surveyTitle = null;
    private String surveyContent = null;
    private List<RequestQuestionDto> questionCardList = null;

    public RequestCreateSurveyDto(Long userId, String surveyTitle, String surveyContent, List<RequestQuestionDto> questionCardList) {
        this.userId = new User(userId);
        this.surveyTitle = surveyTitle;
        this.surveyContent = surveyContent;
        this.questionCardList = questionCardList;
    }

    public Survey toSurveyEntity() {
        return Survey.builder()
                .userId(userId)
                .surveyTitle(surveyTitle)
                .surveyDescription(surveyContent)
                .build();
    }
}
