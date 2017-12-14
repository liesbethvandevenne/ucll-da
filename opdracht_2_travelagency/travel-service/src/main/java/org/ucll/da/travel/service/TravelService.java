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
		//restTemplate = new RestTemplate();
		
		//destination
		String url = String.format("http://destination-service/destination/id/%s", zip);
		String response = this.restTemplate.getForObject(url, String.class);
		info.setDestination(response);
	
		//destinationname
		//url = String.format("http://destination-service/get/name/%s", zip);
		//String json = this.restTemplate.getForObject(url, String.class);
		//Gson gson = new Gson();
		//String destinationName = gson.fromJson(json, String.class);
		
		//review
		url = String.format("http://review-service/review/destination/%s", zip);
		info.setReview("Gezellige boel" /*this.restTemplate.getForObject(url, String.class)*/ );
		
		//weather
		//url = String.format("http://weather-service/forecast/%s", destinationName);
		info.setWeather("Regen met zonnebuien" /*this.restTemplate.getForObject(url, String.class) */);
		
		return info;
	}

}
