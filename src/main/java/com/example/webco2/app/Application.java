package com.example.webco2.app;

import com.example.webco2.service.CO2LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    @Autowired
    private static CO2LevelService levelService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}