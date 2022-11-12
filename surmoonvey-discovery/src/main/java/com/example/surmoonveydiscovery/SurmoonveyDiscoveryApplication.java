package com.example.surmoonveydiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SurmoonveyDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurmoonveyDiscoveryApplication.class, args);
	}

}
