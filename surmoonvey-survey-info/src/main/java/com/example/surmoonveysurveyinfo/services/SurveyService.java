package com.example.surmoonveysurveyinfo.services;

import com.example.surmoonveysurveyinfo.dto.SurveyListResponseDto;
import com.example.surmoonveysurveyinfo.models.User;
import com.example.surmoonveysurveyinfo.repositories.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SurveyService {

    @Autowired
    SurveyRepository surveyRepository;

    // 설문 전체 불러오기 (select *)
    @Transactional(readOnly = true) // 트랜젝션을 읽기 전용으로 함
    public List<SurveyListResponseDto> findAll() {
        return surveyRepository.findAll().stream()
                .map(SurveyListResponseDto::new)
                .collect(Collectors.toList());
    }

    // 설문 유저 ID에 따라 불러오기 (select by user ID...)
    @Transactional(readOnly = true) // 트랜젝션을 읽기 전용으로 함
    @Query("SELECT * FROM SURVEY WHERE user_id = 1")
    public List<SurveyListResponseDto> findAllByUserId(Long userId) {
        User user = new User(userId);
        return surveyRepository.findAllByUserId(user).stream()
                .map(SurveyListResponseDto::new)
                .collect(Collectors.toList());
    }

    // 설문 ID와 유저 ID에 따라 불러오기 (select by survey ID)
    @Transactional(readOnly = true)
    public SurveyListResponseDto findBySurveyId(Long surveyId) {
        return new SurveyListResponseDto(surveyRepository.findSurveyBySurveyId(surveyId));
    }
}
