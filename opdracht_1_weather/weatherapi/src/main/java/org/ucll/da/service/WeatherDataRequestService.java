package org.ucll.da.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.ucll.da.entities.CurrentCondition;
import org.ucll.da.entities.WeatherData;
import org.ucll.da.entities.WeatherForecast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class WeatherDataRequestService {
    
    private String apikey = "88d056b4bd8a4b55d4b5c80bdc3e8cc8";

    public WeatherData getCurrentCondition(String city){
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<String> response = restTemplate.getForEntity(
    			"http://api.openweathermap.org/data/2.5/weather?q={city},be&appid=88d056b4bd8a4b55d4b5c80bdc3e8cc8"
    			, String.class
    			, city);
    	
    	WeatherData currentCondition = new Gson().fromJson(response.getBody(), CurrentCondition.class);
    	
    	return currentCondition;
    }
    
    public WeatherData getForecast(String city){
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<String> response = restTemplate.getForEntity(
    			"http://api.openweathermap.org/data/2.5/forecast?q={city},be&cnt=5&appid=88d056b4bd8a4b55d4b5c80bdc3e8cc8"
    			, String.class
    			, city);
    	
    	WeatherData forecast = new Gson().fromJson(response.getBody(), WeatherForecast.class);
    	
    	return forecast;
    }
    
    public WeatherData getForecast(long zipCode){
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<String> response = restTemplate.getForEntity(
    			"http://api.openweathermap.org/data/2.5/forecast?q={zipCode},be&cnt=5&appid=88d056b4bd8a4b55d4b5c80bdc3e8cc8"
    			, String.class
    			, zipCode );
    	
    	WeatherData forecast = new Gson().fromJson(response.getBody(), WeatherForecast.class);
    	
    	return forecast;
    }
}