package org.ucll.da.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ucll.da.entities.WeatherData;
import org.ucll.da.service.WeatherService;

@RestController
@EnableAutoConfiguration
public class WeatherRestController {

	@Autowired
	private WeatherService service;
	
	
    @RequestMapping("/currentweather")
    public WeatherData current(@RequestParam(value="name") String name) {
        return service.requestCurrentCondition(name);
    }
    
    @RequestMapping("/weatherforecast")
    public WeatherData forecast(@RequestParam(value="name") String name) {
        return service.requestForecast(name);
    }
}