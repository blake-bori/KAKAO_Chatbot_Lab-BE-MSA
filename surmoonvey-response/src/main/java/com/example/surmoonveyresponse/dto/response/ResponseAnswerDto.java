package com.example.surmoonveyresponse.dto.response;

import com.example.surmoonveyresponse.models.ChoiceAnswer;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseAnswerDto {

    private Long id;
    private Integer order;
    private String value;
    private Boolean isCheck;

    public ResponseAnswerDto(ChoiceAnswer choiceAnswer) {
        this.id=choiceAnswer.getChoiceAnswerId();
        this.order = choiceAnswer.getAnswerOrder();
        this.value = choiceAnswer.getAnswerContent();
        this.isCheck=false;
    }
}
