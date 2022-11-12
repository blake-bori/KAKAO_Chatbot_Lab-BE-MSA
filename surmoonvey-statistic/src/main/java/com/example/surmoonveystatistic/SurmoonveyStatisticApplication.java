package com.example.surmoonveystatistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SurmoonveyStatisticApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurmoonveyStatisticApplication.class, args);
	}

}
