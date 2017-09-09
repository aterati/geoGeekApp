package com.rv.geoGeekApp.restControllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rv.geoGeekApp.services.WeatherService;

/**
 * This class is used to define rest controllers and map them to client URL.
 *
 */
@RestController
public class MyRestController {

	private final AtomicLong id = new AtomicLong();

	@RequestMapping("/letsExplore")
	public String restHandler(
			@RequestParam(value = "city", defaultValue = "Sacramento") String cityName) {


		WeatherService weatherService = new WeatherService();
		
		
		return weatherService.checkWeather(cityName);

	}
}
