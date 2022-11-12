package com.example.surmoonveysurvey.dto;

import com.example.surmoonveysurvey.models.ChoiceAnswer;
import com.example.surmoonveysurvey.models.Question;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestChoiceAnswerDto {

    private String value;

    public RequestChoiceAnswerDto(String value) {
        this.value = value;
    }

    public ChoiceAnswer toChoiceAnswerEntity(Question questionId, Integer answerOrder) {
        return ChoiceAnswer.builder()
                .questionId(questionId)
                .answerOrder(answerOrder)
                .answerContent(value)
                .build();
    }
}
