package com.example.surmoonveysurvey.dto;

import com.example.surmoonveysurvey.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RequestReviseSurveyDto {
    private User userId = null;
    private Long surveyId = null;
    private String surveyTitle = null;
    private String surveyContent = null;
    private List<RequestQuestionDto> questionCardList = null;

    public RequestReviseSurveyDto(Long userId, Long surveyId, String surveyTitle, String surveyContent, List<RequestQuestionDto> questionCardList) {
        this.userId = new User(userId);
        this.surveyId = surveyId;
        this.surveyTitle = surveyTitle;
        this.surveyContent = surveyContent;
        this.questionCardList = questionCardList;
    }
}
