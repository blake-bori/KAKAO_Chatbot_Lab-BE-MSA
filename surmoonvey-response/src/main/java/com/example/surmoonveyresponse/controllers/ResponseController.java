package com.example.surmoonveyresponse.controllers;

import com.example.surmoonveyresponse.dto.response.RequestSubmitSurveyDto;
import com.example.surmoonveyresponse.dto.response.ResponseSurveyDto;
import com.example.surmoonveyresponse.services.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@ResponseBody
@RequestMapping("/api/response")
public class ResponseController {

    @Autowired
    private final ResponseService responseService;

    @GetMapping("/{surveyId}")
    public ResponseSurveyDto getSurveyTemplate(@PathVariable Long surveyId) {
        return responseService.getSurveyTemplate(surveyId);
    }

    @PostMapping
    public Long submitSurvey(@RequestBody RequestSubmitSurveyDto requestDto) {
        return responseService.submitSurvey(requestDto);
    }
}
