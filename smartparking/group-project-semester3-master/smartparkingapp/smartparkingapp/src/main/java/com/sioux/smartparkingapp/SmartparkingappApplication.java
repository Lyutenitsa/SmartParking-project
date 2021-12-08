package com.sioux.smartparkingapp;

import com.sioux.smartparkingapp.servises.CommunicationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartparkingappApplication {

	public static void main(String[] args) {
//		CommunicationService.SendUpdate();

		SpringApplication.run(SmartparkingappApplication.class, args);
	}

}
