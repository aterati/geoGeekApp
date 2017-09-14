package com.rv.geoGeekApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rv.geoGeekApp.dataObjects.WeatherData;

/**
 * Spring Boot Configuration class
 * 
 */
@SpringBootApplication
public class MySpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringAppApplication.class, args);
	}
}
