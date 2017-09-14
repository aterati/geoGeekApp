package com.rv.geoGeekApp.dataObjects;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class LocationSearchData {

	@JsonProperty("formatted_address")
	private String address;
	@JsonProperty("icon")
	private String logoUrl;
	private String name;
	private boolean openNow;
	@JsonProperty("price_level")
	private Integer priceLevel;
	@JsonProperty("rating")
	private Float rating;

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the logoUrl
	 */
	public String getLogoUrl() {
		return logoUrl;
	}

	/**
	 * @param logoUrl
	 *            the logoUrl to set
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the openNow
	 */
	public boolean isOpenNow() {
		return openNow;
	}

	/**
	 * @param openNow
	 *            the openNow to set
	 */
	public void setOpenNow(boolean openNow) {
		this.openNow = openNow;
	}

	/**
	 * @return the priceLevel
	 */
	public Integer getPriceLevel() {
		return priceLevel;
	}

	/**
	 * @param priceLevel
	 *            the priceLevel to set
	 */
	public void setPriceLevel(Integer priceLevel) {
		this.priceLevel = priceLevel;
	}

	/**
	 * @return the rating
	 */
	public Float getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(Float rating) {
		this.rating = rating;
	}

}
