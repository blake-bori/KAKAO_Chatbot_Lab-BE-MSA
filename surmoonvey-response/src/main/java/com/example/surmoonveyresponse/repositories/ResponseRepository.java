package com.example.surmoonveyresponse.repositories;

import com.example.surmoonveyresponse.dto.response.resultSurvey.StatisticChoiceDto;
import com.example.surmoonveyresponse.dto.response.resultSurvey.StatisticSubjectiveDto;
import com.example.surmoonveyresponse.models.Question;
import com.example.surmoonveyresponse.models.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Long> {


    @Query(value = "select * from question where survey_id=:id", nativeQuery = true)
    List<Question> findQuestionList(@Param("id") Long id);

    @Query(name="find_statistic_choice_dto", nativeQuery = true)
    List<StatisticChoiceDto> findStatisticChoice(@Param("id") Long id);

    @Query(name="find_statistic_subjective_dto", nativeQuery = true)
    List<StatisticSubjectiveDto> findStatisticSubjective(@Param("id") Long id);
}
