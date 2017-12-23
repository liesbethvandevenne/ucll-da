package org.ucll.da.destination.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DestinationService {
	
	private List<Destination> destinations;
	
	public DestinationService(){
		destinations = new ArrayList<>();
		init();
	}
	
	public List<Destination> get(Predicate<Destination> test){
		return destinations.stream().filter(test).collect(Collectors.toList());
	}
	
	public void add(Destination destination){
		this.destinations.add(destination);
	}

	private void init() {
		Destination d1 = new Destination();
		d1.setId(1);
		d1.setName("Nieuwerkerken");
		d1.setCountry("België");
		destinations.add(d1);

		Destination d2 = new Destination();
		d2.setId(3);
		d2.setName("Diest");
		d2.setCountry("België");
		destinations.add(d2);
		
		Destination d = new Destination();
		d.setId(2);
		d.setName("Brussel");
		d.setCountry("België");
		destinations.add(d);
		
	}
}
