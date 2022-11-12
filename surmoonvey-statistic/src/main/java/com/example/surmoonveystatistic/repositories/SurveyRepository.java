package com.example.surmoonveystatistic.repositories;

import com.example.surmoonveystatistic.models.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
