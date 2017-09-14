package com.rv.geoGeekApp.dataObjects;

import org.springframework.stereotype.Component;

/**
 * Data Object class defined to store weather details.
 * 
 * 
 * @author Arvind Terati
 */
@Component
public class WeatherData {

	// @JsonProperty("name")
	private String cityName;
	private String description;
	private Long currentTemperature;
	private Long minimumTemperature;
	private Long maximumTemperature;
	private Long humidity;
	private Long windSpeed;
	private String countryCode;

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName
	 *            the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the currentTemperature
	 */
	public Long getCurrentTemperature() {
		return currentTemperature;
	}

	/**
	 * @param currentTemperature
	 *            the currentTemperature to set
	 */
	public void setCurrentTemperature(Long currentTemperature) {
		this.currentTemperature = currentTemperature;
	}

	/**
	 * @return the minimumTemperature
	 */
	public Long getMinimumTemperature() {
		return minimumTemperature;
	}

	/**
	 * @param minimumTemperature
	 *            the minimumTemperature to set
	 */
	public void setMinimumTemperature(Long minimumTemperature) {
		this.minimumTemperature = minimumTemperature;
	}

	/**
	 * @return the maximumTemperature
	 */
	public Long getMaximumTemperature() {
		return maximumTemperature;
	}

	/**
	 * @param maximumTemperature
	 *            the maximumTemperature to set
	 */
	public void setMaximumTemperature(Long maximumTemperature) {
		this.maximumTemperature = maximumTemperature;
	}

	/**
	 * @return the humidity
	 */
	public Long getHumidity() {
		return humidity;
	}

	/**
	 * @param humidity
	 *            the humidity to set
	 */
	public void setHumidity(Long humidity) {
		this.humidity = humidity;
	}

	/**
	 * @return the windSpeed
	 */
	public Long getWindSpeed() {
		return windSpeed;
	}

	/**
	 * @param windSpeed
	 *            the windSpeed to set
	 */
	public void setWindSpeed(Long windSpeed) {
		this.windSpeed = windSpeed;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
