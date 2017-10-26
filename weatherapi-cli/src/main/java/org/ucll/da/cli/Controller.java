package org.ucll.da.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.ucll.da.entities.WeatherData;
import org.ucll.da.service.WeatherService;

public class Controller {
	
	@Autowired
	private WeatherService service;
	private View view;
	
	public Controller(){
		view = new View();
		//service = new WeatherService();
	}
	
	public void start(){
		String input = view.showMenu();
		String city = view.getCityName();
		WeatherData data = null;
		
		switch(input){
		case "F": data = service.requestForecast( city ); break;
		case "C": data = service.requestCurrentCondition( city ); break;
		default: stop();
		}
		
		service.save(data);
		view.showData(data.toString());
	}
	
	public void stop(){
		view.showError("Wrong input");
	}

}
