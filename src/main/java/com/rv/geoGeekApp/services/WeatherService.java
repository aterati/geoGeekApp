package com.rv.geoGeekApp.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rv.geoGeekApp.dataObjects.WeatherData;

/**
 * Weather Service class is responsible for making
 * a web service call to Weather API(http://openweathermap.org/)
 * using our custom API ID and return formatted results.
 * 
 * @author Arvind Terati
 */
public class WeatherService {

	private WeatherData weatherData = new WeatherData();

	/**
	 * Makes a web service call to Weather API(http://openweathermap.org/)
	 * and return formatted results.
	 * 
	 * @param cityName
	 * @return JSON string results
	 */
	public String checkWeather(String cityName) {

		URL url;
		String weatherDataString = null;
		
		try {
			url = new URL("http://api.openweathermap.org/data/2.5/weather?q="
					+ cityName
					+ "&units=imperial&APPID=fffadfe27014a66d0968b67a6d0466cd");
			
			InputStream is = url.openStream();

			
			/** Use this String Json representation to test the weather service call locally **/
			
			/*String str = "{\"coord\":{\"lon\":-121.49,\"lat\":38.58},\"weather\":[{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50d\"},{\"id\":721,\"main\":\"Haze\",\"description\":\"haze\",\"icon\":\"50d\"}],\"base\":\"stations\",\"main\":{\"temp\":67.01,\"pressure\":1012,\"humidity\":88,\"temp_min\":64.4,\"temp_max\":69.8},\"visibility\":9656,\"wind\":{\"speed\":3.36,\"deg\":240},\"clouds\":{\"all\":1},\"dt\":1504886400,\"sys\":{\"type\":1,\"id\":464,\"message\":0.0037,\"country\":\"US\",\"sunrise\":1504878138,\"sunset\":1504923810},\"id\":5389489,\"name\":\"Sacramento\",\"cod\":200}";
			ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes());*/

			JsonReader jsonRd = Json.createReader(is);

			JsonObject jsonObj = jsonRd.readObject();

			/* Setting City Name */
			weatherData.setCityName(jsonObj.getString("name"));

			JsonObject jsonInnerObj = jsonObj.getJsonObject("main");

			weatherData.setCurrentTemperature(jsonInnerObj.getJsonNumber("temp").longValue());
			weatherData.setMinimumTemperature(jsonInnerObj.getJsonNumber("temp_min").longValue());
			weatherData.setMaximumTemperature(jsonInnerObj.getJsonNumber("temp_max").longValue());
			weatherData.setHumidity(jsonInnerObj.getJsonNumber("humidity").longValue());

			jsonInnerObj = jsonObj.getJsonObject("wind");

			weatherData.setWindSpeed(jsonInnerObj.getJsonNumber("speed").longValue());

			JsonArray jsonInnerArray = jsonObj.getJsonArray("weather");
			StringBuilder description = new StringBuilder();

			for (int i = 0; i < jsonInnerArray.size(); i++) {
				jsonInnerObj = jsonInnerArray.getJsonObject(i);
				description.append(jsonInnerObj.getString("description"));
				description.append(',');
			}

			weatherData.setDescription(description.toString().substring(0,description.lastIndexOf(",")));

			weatherData.setCountryCode(jsonObj.getJsonObject("sys").getString("country"));

			ObjectMapper mapper = new ObjectMapper();
			
			weatherDataString = mapper.writeValueAsString(weatherData);

		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return weatherDataString;

	}

}
