package com.example.surmoonveysurvey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SurmoonveySurveyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurmoonveySurveyApplication.class, args);
	}

}
