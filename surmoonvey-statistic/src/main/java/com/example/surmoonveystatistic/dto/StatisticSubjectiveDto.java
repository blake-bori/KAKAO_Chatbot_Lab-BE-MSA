package com.example.surmoonveystatistic.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StatisticSubjectiveDto {

    private Long surveyId;
    private Long questionId;
    private Integer questionOrder;
    private Integer questionType;
    private String questionTitle;
    private String answerContent;

    public StatisticSubjectiveDto(Long survey_id,Long question_id, Integer question_order, Integer question_type, String question_title, String subjective_answer){
        this.surveyId=survey_id;
        this.questionId=question_id;
        this.questionOrder=question_order;
        this.questionType=question_type;
        this.questionTitle=question_title;
        this.answerContent=subjective_answer;
    }
}
