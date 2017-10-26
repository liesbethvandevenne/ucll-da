package org.ucll.da;

import static org.junit.Assert.*;

import org.junit.Test;
import org.ucll.da.entities.WeatherData;
import org.ucll.da.service.WeatherService;

public class WeatherServiceTest {

	@Test
	public void constructor_works(){
		WeatherService service = new WeatherService();
		assertTrue(service != null);
	}
	
	@Test
	public void requestForecast_work(){
		String city = "nieuwerkerken";
		WeatherService service = new WeatherService();
		WeatherData data = service.requestForecast(city);
		assertTrue( data.getCity() != null );
		assertTrue( data.getCity().getName().equalsIgnoreCase( city ) );
	}
	
	@Test
	public void requestForecast_2_work(){
		String city = "gent";
		WeatherService service = new WeatherService();
		WeatherData data = service.requestForecast(city);
		assertTrue( data.getCity() != null );
		assertTrue( data.getCity().getName().equalsIgnoreCase( city ) );
	}
	
	public void requestCurrentCondition_works(){
		String city = "nieuwerkerken,be";
		String cityName = "Nieuwerkerken";
		WeatherService service = new WeatherService();
		WeatherData data = service.requestCurrentCondition(city);
		assertTrue( data.getCity() != null );
		assertEquals( data.getCity().getName(), cityName );
	}
	
	@Test
	public void save_noException(){
		String city = "nieuwerkerken,be";
		WeatherService service = new WeatherService();
		WeatherData data = service.requestForecast(city);
		service.save(data);
	}

}
