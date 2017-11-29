package org.ucll.da.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ucll.da.entities.WeatherData;
import org.ucll.da.service.WeatherService;

@RestController
public class WeatherController {

	@Autowired
	private DiscoveryClient discoveryClient;
	private WeatherService service;

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
	
	@RequestMapping("/weather/currentcondition/{city}")
	public WeatherData getCurrentCondition(@PathVariable String city) {
		return this.service.requestCurrentCondition(city);
	}
	
	@RequestMapping("/weather/forecast/{city}")
	public WeatherData getForecast(@PathVariable String city) {
		return this.service.requestForecast(city);
	}
}