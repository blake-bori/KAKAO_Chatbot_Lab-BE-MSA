package com.example.surmoonveysurvey.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class SurveyUpdateDto {

    private LocalDateTime surveyStart; // 설문 시작일

    private LocalDateTime surveyEnd; // 설문 종료일

    private String surveyUrl; // 설문 링크

    @Builder
    public SurveyUpdateDto(LocalDateTime surveyStart,
                           LocalDateTime surveyEnd, String surveyUrl) {
        this.surveyStart = surveyStart;
        this.surveyEnd = surveyEnd;
        this.surveyUrl = surveyUrl;
    }
}
