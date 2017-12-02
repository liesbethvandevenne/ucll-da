package org.ucll.da.travel.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ucll.da.travel.service.TravelInfo;

@RestController
public class TravelController {

	private TravelService service;
	
	public TravelController(){
		service = new TravelService();
	}
		
	@RequestMapping("/travel/info")
	public TravelInfo getInfo(@RequestParam String zip, @RequestParam String city) {
		return service.getTravelInfo(zip, city);
	}

	@RequestMapping("/")
	public String getIndex() {
		return "Up and running";
	}

}
