package org.ucll.da.weather.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.ucll.da.service.WeatherService;

@Configuration
public class Config {
	
	@Bean
	public WeatherService service(){
		return new WeatherService();
	}

}
