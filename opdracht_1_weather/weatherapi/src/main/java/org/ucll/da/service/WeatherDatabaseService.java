package org.ucll.da.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ucll.da.entities.WeatherData;

public class WeatherDatabaseService {

	private Map<String, List<WeatherData>> database; 
	
	public WeatherDatabaseService(){
		database = new HashMap<>();
		database.put("WeatherForecast", new ArrayList());
		database.put("CurrentCondition", new ArrayList());
	}
	
	public void save(String type, WeatherData data) {
		List<WeatherData> dataList = (List<WeatherData>)database.get(type);
		dataList.add(data);
	}
}
