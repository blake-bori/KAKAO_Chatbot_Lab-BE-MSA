package com.example.surmoonveyuser.controllers;

import com.example.surmoonveyuser.dto.UserRequestDto;
import com.example.surmoonveyuser.services.KafkaProducer;
import com.example.surmoonveyuser.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@ResponseBody
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping
    public Long createUser(@RequestBody UserRequestDto requestDto) {
        Long id = userService.createUser(requestDto);
        kafkaProducer.send("user-survey-topic", requestDto);
        return userService.createUser(requestDto);
    }

    @GetMapping(value = "/survey/{surveyId}")
    public Long getUserBySurvey(@PathVariable Long surveyId) {
        return userService.getUserBySurvey(surveyId);
    }
}

