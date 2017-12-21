package org.ucll.da.travel.service;

import javax.print.attribute.standard.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public class TravelService {
	
	//@LoadBalanced
	@Autowired
	private RestTemplate restTemplate;
		
	public TravelService(){}
		
	public TravelInfo getTravelInfo(String zip){
		TravelInfo info = new TravelInfo();
		
		//destination
		String url = String.format("http://destination-service/destination/id/%s", zip);
		String response = this.restTemplate.getForObject(url, String.class);
		info.setDestination(response);
	
		//destinationname
		url = String.format("http://destination-service/destination/get/name/%s", zip);
		String city = this.restTemplate.getForObject(url, String.class);
		
		
		//review
		url = String.format("http://review-service/review/id/%s", zip);
		response = this.restTemplate.getForObject("http://review-service/review/id/1", String.class);
		info.setReview(response);
		
		//weather
		url = String.format("http://weather-service/weather/forecast/%s", city);
		info.setWeather(this.restTemplate.getForObject(url, String.class));
		
		return info;
	}

}
