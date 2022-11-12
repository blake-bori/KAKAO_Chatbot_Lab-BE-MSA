package com.example.surmoonveyuser.controllers;

import com.example.surmoonveyuser.dto.UserRequestDto;
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

    @PostMapping
    public Long createUser(@RequestBody UserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    @GetMapping(value = "/survey/{surveyId}")
    public Long getUserBySurvey(@PathVariable Long surveyId){
        return userService.getUserBySurvey(surveyId);
    }
}

