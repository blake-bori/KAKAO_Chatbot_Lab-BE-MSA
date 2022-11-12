package com.example.surmoonveystatistic.repositories;

import com.example.surmoonveystatistic.dto.StatisticChoiceDto;
import com.example.surmoonveystatistic.dto.StatisticSubjectiveDto;
import com.example.surmoonveystatistic.models.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Long> {

    @Query(name = "find_statistic_choice_dto", nativeQuery = true)
    List<StatisticChoiceDto> findStatisticChoice(@Param("id") Long id);

    @Query(name = "find_statistic_subjective_dto", nativeQuery = true)
    List<StatisticSubjectiveDto> findStatisticSubjective(@Param("id") Long id);
}
