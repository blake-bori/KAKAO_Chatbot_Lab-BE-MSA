package com.example.surmoonveystatistic.controller;

import com.example.surmoonveystatistic.dto.SurveyStatisticDto;
import com.example.surmoonveystatistic.services.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@ResponseBody
@RequestMapping("/api/response")
public class StatisticController {

    @Autowired
    private final StatisticService statisticService;

    //     설문 ID에 따라 응답 통계 불러오기
    @GetMapping("/statistic/{surveyId}")
    public SurveyStatisticDto getSurveyStatistic(@PathVariable Long surveyId) {
        return statisticService.getSurveyStatistic(surveyId);
    }
}
