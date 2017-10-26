package org.ucll.da.task;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import org.ucll.da.entities.WeatherData;
import org.ucll.da.service.WeatherService;

@Component
public class WeatherDataFetchScheduler {
	
	private WeatherService service;
	
	public WeatherDataFetchScheduler() {
		service = new WeatherService();
	}
	
	//iedere dag
	@Scheduled(cron = "0 0 1 * * *")
    public void requestForecast() {
        WeatherData data = service.requestForecast("tienen");
		service.save(data);
		System.out.println("test");
    }
	
	//iedere 3 uur
	@Scheduled(cron = "* * 0,3,6,9,12,15,18,21 * * *")
    public void requestCurrent() {
        service.save(service.requestCurrentCondition("tienen"));
    }
    
	/*
    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("poolScheduler");
        scheduler.setPoolSize(10);
        return scheduler;
    }*/
	
}