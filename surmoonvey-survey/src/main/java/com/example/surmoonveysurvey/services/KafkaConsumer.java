package com.example.surmoonveysurvey.services;

import com.example.surmoonveysurvey.models.User;
import com.example.surmoonveysurvey.repositories.SurveyRepository;
import com.example.surmoonveysurvey.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class KafkaConsumer {

    @Autowired
    UserRepository userRepository;

    @KafkaListener(topics = "user-survey-topic")
    public void updateUser(String kafkaMessage) { //토픽에서 메세지 가져옴
        log.info("Kafka Message: ->" + kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {
            }); // Json 형태의 string -> json
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

        User userEntity = new User(
                ((Number) map.get("userId")).longValue(),
                (String) map.get("nickName"),
                (String) map.get("profileImg"),
                (String) map.get("email"),
                (LocalDateTime) map.get("joinDate")
        );

        User userId = userRepository.save(userEntity);
    }
}
