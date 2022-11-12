package com.example.surmoonveysurvey.controllers;

import com.example.surmoonveysurvey.dto.RequestCreateSurveyDto;
import com.example.surmoonveysurvey.dto.RequestReviseSurveyDto;
import com.example.surmoonveysurvey.dto.SurveyListResponseDto;
import com.example.surmoonveysurvey.dto.SurveyUpdateDto;
import com.example.surmoonveysurvey.services.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@ResponseBody
@RequestMapping("/api/survey")
public class SurveyController {

    @Autowired
    private final SurveyService surveyService;

    @PostMapping
    public Long createSurvey(@RequestBody RequestCreateSurveyDto requestDto) {
        return surveyService.createSurvey(requestDto);
    }

    // 설문 정보 업데이트하기
    @PutMapping(value = "/{surveyId}/meta")
    public SurveyListResponseDto updateSurvey(@PathVariable Long surveyId, @RequestBody SurveyUpdateDto surveyUpdateDto) {
        return surveyService.updateSurvey(surveyId, surveyUpdateDto);
    }

    @PutMapping(value = "/{surveyId}/template")
    public Long reviseSurvey(@PathVariable Long surveyId, @RequestBody RequestReviseSurveyDto requestDto) {
        return surveyService.reviseSurvey(surveyId, requestDto);
    }

    @PutMapping(value = "/{surveyId}/duplicate")
    public Long copyBySurveyId(@PathVariable Long surveyId) {
        return surveyService.copyBySurveyId(surveyId);
    }

    @DeleteMapping(value = "/{surveyId}")
    public Long deleteFindBySurveyId(@PathVariable Long surveyId) {
        return surveyService.deleteFindBySurveyId(surveyId);
    }
}
