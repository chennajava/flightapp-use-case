package com.flightapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PassangerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PassangerApplication.class, args);
	}

}
