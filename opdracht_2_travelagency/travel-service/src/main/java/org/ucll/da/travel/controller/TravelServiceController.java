package org.ucll.da.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ucll.da.travel.service.TravelInfo;
import org.ucll.da.travel.service.TravelService;

@RestController
public class TravelServiceController {

	@Autowired
	private TravelService service;
	
	public TravelServiceController(){
		//service = new TravelService();
	}
		
	@RequestMapping("/info/{zip}")
	public TravelInfo getInfo(@PathVariable("zip") String zip) {
		return service.getTravelInfo(zip);
	}

	@RequestMapping("/")
	public String getIndex() {
		return "Up and running";
	}
}
