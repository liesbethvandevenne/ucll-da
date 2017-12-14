package org.ucll.da.destination.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.ucll.da.destination.entities.DestinationService;

@Configuration
public class Config {
	
	
	
	@Bean
	public DestinationService service(){
		return new DestinationService();
	}

}
