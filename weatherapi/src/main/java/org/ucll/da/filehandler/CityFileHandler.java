package org.ucll.da.filehandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.ucll.da.entities.City;

public class CityFileHandler {

	private List<City> cities;
	
	public CityFileHandler(){
		cities = new ArrayList<>();
	}
	
	public List<City> read(){
		File file = new File( "/home/lies/git_repositories/ucll-distributed/weatherapi/src/main/java/org/ucll/da/filehandler/city_list.txt" );
		
	    try {

	        Scanner scanner = new Scanner(file);
	        scanner.nextLine();
	        
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] splitted = line.replaceAll("\\s+", " ").split(" ");
	            createCity(splitted);
	        }
	        scanner.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    
	    return cities;
	}

	private boolean createCity(String[] splitted) {
		if(splitted.length < 4){
			return false;
		}
		
		if( !splitted[4].equalsIgnoreCase("be") ){
			return false;
		}
		
		City city = new City();
		
		city.setId( Integer.parseInt(splitted[0]) );
		city.setName( splitted[1] );
		city.setCountry( splitted[4] );
		
		cities.add(city);
		return true;
	}
	
}
