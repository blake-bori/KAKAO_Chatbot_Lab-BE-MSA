package com.example.surmoonveysurveyinfo.repositories;

import com.example.surmoonveysurveyinfo.models.Survey;
import com.example.surmoonveysurveyinfo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    @Override
    List<Survey> findAll();

    List<Survey> findAllByUserId(User userId);

    Survey findSurveyBySurveyId(Long surveyId);
}
