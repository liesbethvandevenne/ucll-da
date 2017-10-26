package org.ucll.da.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ucll.da.entities.City;
import org.ucll.da.entities.WeatherData;

@Service
public class WeatherService {

	private WeatherDataRequestService weatherDataRequest;
	private WeatherDatabaseService weatherDatabase;
	//private CityDatabaseService cities;
	
	@Autowired
	public WeatherService(){
		weatherDataRequest = new WeatherDataRequestService();
		weatherDatabase = new WeatherDatabaseService();
		//cities = new CityDatabaseService();
	}
	
	public WeatherData requestForecast(String city){
		return weatherDataRequest.getForecast(city);
	}
	
	public WeatherData requestCurrentCondition(String city){
		return weatherDataRequest.getCurrentCondition(city);
	}

	public void save(WeatherData data) {
		String type = data.getClass().getSimpleName();
		weatherDatabase.save(type, data);
	}
	
	/*
	 * Werkt niet ok, corrupte inputfile?
	public City getCity(String id){
		return cities.get(Long.parseLong(id));
	}
	
	public List<City> getCities(Predicate<City> test){
		return cities.get(test);
	}
	(*/
}
