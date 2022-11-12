package com.example.surmoonveysurvey.repositories;

import com.example.surmoonveysurvey.models.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

    Survey findSurveyBySurveyId(Long surveyId);
}
