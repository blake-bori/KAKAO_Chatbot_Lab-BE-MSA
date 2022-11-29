package com.example.surmoonveyuser.services;

import com.example.surmoonveyuser.dto.UserRequestDto;
import com.example.surmoonveyuser.models.User;
import com.example.surmoonveyuser.models.Survey;
import com.example.surmoonveyuser.repositories.UserRepository;
import com.example.surmoonveyuser.repositories.SurveyRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final SurveyRepository surveyRepository;

    @Transactional
    public Long createUser(UserRequestDto requestDto) {

        User userId = userRepository.save(requestDto.toEntity());

        return userId.getUserId();
    }

    @Transactional
    // 설문지 ID를 통해 설문지를 만든 유저ID를 가져옴
    public Long getUserBySurvey(Long surveyId){
        Survey survey= surveyRepository.findUserBySurveyId(surveyId);

        return survey.getUserId().getUserId();
    }
}
