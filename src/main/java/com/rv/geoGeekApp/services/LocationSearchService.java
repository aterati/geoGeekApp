/**
 * 
 */
package com.rv.geoGeekApp.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.json.Json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rv.geoGeekApp.dataObjects.LocationSearchData;

/**
 * @author ArvindTerati
 *
 */
@Service
public class LocationSearchService {
	
	@Autowired
	private LocationSearchData searchData;
	private static String API_KEY = "***Use your google API Key*** ";
	
	
	
	public String searchByType(String cityName, String searchType, boolean includeOpenNow){
		
		String query= "https://maps.googleapis.com/maps/api/place/textsearch/json?";
		String responseString = "";
		
		query = query+"query="+cityName;
		query = query+"&radius="+25;
		query = query+"&type="+searchType;
		
		if(includeOpenNow){
			query=query+"&opennow=true";
		}
		
		query = query+"&key="+API_KEY;
		
		
		try {
			
			JsonFactory jf = new JsonFactory();
			
			
			/**
			 * Comment this section to point directly to google maps API using
			 * the API key. This section is used to test the application locally
			 * using the Json String.
			 */
			String str = "{   \"html_attributions\": [],   \"next_page_token\":\"CoQC_wAAAA8HCIRWItdo9OS30pXou4S4yR4rKs0YYooMdxjlNhISLycbrGfl5-YXRawf7Hr8I-_0ZR1i8-WUOo3l4b97Y9SSp1ie5erNhkg43VVHWwXfGMTAZjXh7YDfZgkKZoNd1TCzPv3Kus9CXRcJNRYtavz4cV8ILj7ATrSIp-OseTmUBD2eQlBuI-8wNpJTL6_n-wotKmSfUouP6uYqpkOytOjKq32JtJH8qHmxRwN5xeh1c1gUlLUmfQJKPdV3_sfRpM739au3QTGDAxnxgb9_yLZzs4xtpDU_Tz5KciczBTRElMnWaxUIgBy27n6VHgzHX1Hjoi0eAmVcY3ei3l3kpVkSEKa2zybqZQStFsuBM6E3VscaFPwRz7fdoo82r_JVIBlIhN7Ol7Wc\",   \"results\": [{\"formatted_address\": \"1112 2nd St, Sacramento, CA 95814, United States\",\"geometry\": {\"location\": {\"lat\": 38.581531,                   \"lng\": -121.504931},\"viewport\": {\"northeast\": {\"lat\": 38.5828670302915,\"lng\": -121.5035319697085},\"southwest\": {\"lat\": 38.5801690697085,\"lng\": -121.5062299302915}}}, \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\", \"id\": \"3b0b0ac735637f92f651173f827420e9f34361e0\", \"name\": \"The Firehouse Restaurant\", \"opening_hours\": {\"open_now\": false,\"weekday_text\": [] }, \"photos\": [{    \"height\": 1365,    \"html_attributions\": [<a href=\"https://maps.google.com/maps/contrib/107820498766761981229/photos\">The Firehouse Restaurant</a>\"    ],    \"photo_reference\": \"CmRaAAAAIoySGCF614h2HwaMc428QHX7oXlw8pGs6G8I9U-IDWG3nEAdkgYD9Gjc2Z-OJV43xFsYraHZM-gyL8hQO1uYoHFmhNQDd0n1_-cYi4nrTbWelkZ0IPtgQ-LJEtzUehWtEhBbTYvWmLmKtcTYwvYFOZ96GhRVBOeYEK-9A_C8nRxlPUNverIvng\",    \"width\": 2048} ], \"place_id\": \"ChIJ226kLM3WmoARzPF30SAGzDs\", \"price_level\": 3, \"rating\": 4.3, \"reference\": \"CmRRAAAA3-rdiY10iVki6oTGD59_Up_OhB6jDDcF1gT-p_YC4PIdSGSOke5gZrfnmByCivo6EvuMu_TGNN6Yl66sVUAnzp8CGTmCIQj0RH69qxYVS_pnh0k2vF9OCArwxwOf0EM6EhAKI6YsgSAIQN5P7XAoFlibGhSza4rdhBMpQ2uOTlYhVq1Wu0QxdA\", \"types\": [\"restaurant\",\"food\",\"point_of_interest\",\"establishment\" ]},{ \"formatted_address\": \"1000 Front St, Sacramento, CA 95814, United States\", \"geometry\": {\"location\": {    \"lat\": 38.5827116,    \"lng\": -121.5066906},\"viewport\": {    \"northeast\": {        \"lat\": 38.58395528029151,        \"lng\": -121.5049225697085    },    \"southwest\": {        \"lat\": 38.58125731970851,        \"lng\": -121.5076205302915    }} }, \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\", \"id\": \"5508296e0356d0e1def3ebdc274192944f7dcc16\", \"name\": \"Pilothouse\", \"opening_hours\": {\"open_now\": true,\"weekday_text\": [] }, \"photos\": [{    \"height\": 2992,    \"html_attributions\": [        \"<a href=\"https://maps.google.com/maps/contrib/106579610943735368439/photos\">Nelson Ray</a>\"    ],    \"photo_reference\": \"CmRaAAAASUITpg0GAgLDyiK5O_3pv92ZGqdNbcq4y73gBuHVV6u5cyTAVkC7pDi8eQ-1c8ITC2EB3Jkav5RP2uVBVRRr99aoW_VNv3oDUlAxSf2lSqCrM4xRATolc90XxIhm8ly0EhDM8zXVQelHGBWdRcqdRAYOGhQY3pvzfsHQYRx6_sAWj1_3M60WHw\",    \"width\": 4000} ], \"place_id\": \"ChIJRbj_6MzWmoARY8IDIVuDecM\", \"price_level\": 2, \"rating\": 4.1, \"reference\": \"CmRSAAAAIEMh1an4cgnA5W6kjp9db6Pas-34wLDHMB8wLV0PRcu4UQ3op_HOIntlfx9tr5Nkg-l3Grpj3auPnVITpOM_JrHqlt14nbzTopVaFJpgW9SQwnSFX4loC8G5u2BA3nlDEhCl_0lnpnRlJDMBVELGHVD1GhTz9vSq9tkI5CwkkYpe0S5sU3kD7A\", \"types\": [\"restaurant\",\"food\",\"point_of_interest\",\"establishment\" ]}], \"status\": \"OK\"";
			JsonParser js = jf.createParser(str);
			
			
			/** 
			 * Uncomment this section to point directly to google maps API using API key
			 * 
			 */
//			JsonParser js = jf.createJsonParser(new URL(query));
			
			
			ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			JsonNode node= objectMapper.readTree(js);
			
			JsonNode results = node.get("results");
			
			ArrayList<LocationSearchData> lsList = new ArrayList<LocationSearchData>();
			for(JsonNode result: results){
				lsList.add(objectMapper.readValue(result.toString(), LocationSearchData.class));
			}
			
			responseString = objectMapper.writeValueAsString(lsList);
			System.out.println(objectMapper.writeValueAsString(lsList));
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return responseString;
	}

}
