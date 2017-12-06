package org.ucll.da.destination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ucll.da.destination.entities.Destination;
import org.ucll.da.destination.entities.DestinationService;

@RestController
public class DestinationController {

	@Autowired
	private DiscoveryClient discoveryClient;
	private DestinationService service;
	
	public DestinationController(){
		service = new DestinationService();
	}

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
	public Destination getById(@PathVariable("id") String id) {
		long parsedId = Long.parseLong(id);
		Destination destination = this.service.get(d -> d.getId() == parsedId).get(0);
		return destination;
	}
	
	@RequestMapping("/destination/country/{country}")
	public List<Destination> getByCountry(@PathVariable String country) {
		return this.service.get(d -> d.getCountry().equals(country));
	}
	
    @RequestMapping(value = "/destination/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(@RequestBody Destination destination){
    	service.add(destination);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @RequestMapping("/destination/get/name/{zip}")
	public String getNameByZip(@PathVariable String zip) {
    	long parsedZip = Long.parseLong(zip);
		return this.service.get(d -> d.getId() == parsedZip).get(0).getName();
	}
}
