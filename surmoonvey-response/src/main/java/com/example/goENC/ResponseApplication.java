package com.example.goENC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ResponseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResponseApplication.class, args);
	}

}
