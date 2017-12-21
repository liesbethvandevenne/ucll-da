package org.ucll.da.review.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.ucll.da.review.entities.ReviewService;

@Configuration
public class Config {
	
	
	
	@Bean
	public ReviewService service(){
		return new ReviewService();
	}

}
