package org.ucll.da.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.ucll.da.entities.City;
import org.ucll.da.filehandler.CityFileHandler;

public class CityDatabaseService {
	
	private List<City> cities;

	public CityDatabaseService(){
		cities = new CityFileHandler().read(); 
	}
	
	public List<City> get(Predicate<City> test){
		List<City> found = cities.stream().filter(test).collect( Collectors.toList() );
		return found;
	}
	
	public City get(long id){
		List<City> found = cities.stream().filter(c -> c.getId() == id).collect( Collectors.toList() );
		return found.get(0);
	}
}
