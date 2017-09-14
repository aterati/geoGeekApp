package com.rv.geoGeekApp.restControllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rv.geoGeekApp.services.LocationSearchService;
import com.rv.geoGeekApp.services.WeatherService;

/**
 * This class is used to define rest controllers and map them to client URL.
 *
 */
@RestController
public class MyRestController {

	private final AtomicLong id = new AtomicLong();
	@Autowired
	WeatherService weatherService;
	@Autowired
	LocationSearchService locationSearchService;
	

	@RequestMapping("/letsExplore")
	public String restHandler(
			@RequestParam(value = "city", defaultValue = "Sacramento") String cityName, 
			@RequestParam(value = "searchType", defaultValue = "restaurant") String searchType,
			@RequestParam(value = "openNow", defaultValue = "true") boolean openNow
			) {

		String responseString = "{\"weather\":";
		responseString = responseString + weatherService.checkWeather(cityName);
		responseString = responseString + ",\"restaurants\":" + locationSearchService.searchByType(cityName, searchType, openNow);
		responseString = responseString + "}";
		return responseString;

	}
}
