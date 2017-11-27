package org.ucll.da;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.ucll.da.entities.City;
import org.ucll.da.filehandler.CityFileHandler;

public class CityFileHandlerTest {
	
	@Test
	public void constructor_works() {
		CityFileHandler handler = new CityFileHandler();
		assertTrue(handler != null);
	}
	
	@Test
	public void read_works() {
		CityFileHandler handler = new CityFileHandler();
		List<City> cities = handler.read();
		assertTrue(cities != null);
		assertTrue(cities.size() > 1);
	}
}
