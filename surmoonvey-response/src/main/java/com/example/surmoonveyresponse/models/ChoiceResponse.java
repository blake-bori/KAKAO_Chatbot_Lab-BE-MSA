package com.example.surmoonveyresponse.models;

import com.example.surmoonveyresponse.models.compositeKey.ChoiceResponseId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "choice_response")
@IdClass(ChoiceResponseId.class)
@NoArgsConstructor
public class ChoiceResponse {

    @Id  // Primary key
    @ManyToOne(targetEntity = Question.class)
    @JoinColumn(name = "question_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question questionId;

    @Id  // Primary key
    @ManyToOne(targetEntity = Response.class)
    @JoinColumn(name = "response_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Response responseId;

    @Id  // Primary key
    @ManyToOne(targetEntity = ChoiceAnswer.class)
    @JoinColumn(name = "choice_answer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ChoiceAnswer choiceAnswerId;

    // 객관식 질문
    @Builder
    public ChoiceResponse(Question questionId, Response responseId, ChoiceAnswer choiceAnswerId) {
        System.out.println(questionId.getQuestionId()+":"+responseId.getResponseId()+":"+choiceAnswerId.getChoiceAnswerId());
        this.questionId = questionId;
        this.responseId = responseId;
        this.choiceAnswerId = choiceAnswerId;
    }

}
