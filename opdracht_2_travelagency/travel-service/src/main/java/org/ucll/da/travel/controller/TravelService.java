package org.ucll.da.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.ucll.da.travel.service.TravelInfo;

public class TravelService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public TravelService(){}
	
	@Bean
	private RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	public TravelInfo getTravelInfo(String zip, String name){
		TravelInfo info = new TravelInfo();
		
		//destination
		String url = String.format("http://destination-service/id/%s", zip);
		info.setDestination( this.restTemplate.getForObject(url, String.class) );
		
		//review
		url = String.format("http://review-service/review/destination/%s", zip);
		info.setReview( this.restTemplate.getForObject(url, String.class) );
		
		//weather
		url = String.format("http://weather-service/forecast/%s", name);
		info.setWeather( this.restTemplate.getForObject(url, String.class) );
		
		return info;
	}

}
