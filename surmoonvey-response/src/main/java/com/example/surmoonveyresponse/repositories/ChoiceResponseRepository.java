package com.example.surmoonveyresponse.repositories;

import com.example.surmoonveyresponse.models.ChoiceResponse;
import com.example.surmoonveyresponse.models.compositeKey.ChoiceResponseId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoiceResponseRepository extends JpaRepository<ChoiceResponse, ChoiceResponseId> {
}
