package org.ucll.da.destination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ucll.da.destination.Destination;
import org.ucll.da.destination.entities.DestinationService;

@RestController
public class TravelDestinationController {

	@Autowired
	private DiscoveryClient discoveryClient;
	private DestinationService service;

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
	
	@RequestMapping("/destination/name/{name}")
	public List<Destination> getByName(@PathVariable String name) {
		return this.service.get(d -> d.getName().equals(name));
	}
	
	@RequestMapping("/destination/id/{id}")
	public Destination getById(@PathVariable String id) {
		long parsedId = Long.parseLong(id);
		Destination destination = this.service.get(d -> d.getId() == parsedId).get(0);
		return destination;
	}
	
	@RequestMapping("/destination/country/{country}")
	public List<Destination> getByCountry(@PathVariable String country) {
		return this.service.get(d -> d.getCountry().equals(country));
	}
}
