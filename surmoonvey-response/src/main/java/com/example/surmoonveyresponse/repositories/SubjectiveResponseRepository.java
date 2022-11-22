package com.example.surmoonveyresponse.repositories;

import com.example.surmoonveyresponse.models.SubjectiveResponse;
import com.example.surmoonveyresponse.models.compositeKey.SubjectiveResponseId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectiveResponseRepository extends JpaRepository<SubjectiveResponse, SubjectiveResponseId> {
}
