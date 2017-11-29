package org.ucll.da.review.controller;

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
import org.ucll.da.review.entities.Review;
import org.ucll.da.review.entities.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	private DiscoveryClient discoveryClient;
	private ReviewService service;

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
	
	@RequestMapping("/review/author/{author}")
	public List<Review> getByAuthor(@PathVariable String author) {
		return this.service.get(r -> r.getAuthor().equals(author));
	}
	
	@RequestMapping("/review/id/{id}")
	public Review getById(@PathVariable String id) {
		long parsedId = Long.parseLong(id);
		Review review = this.service.get(r -> r.getId() == parsedId).get(0);
		return review;
	}
	
	@RequestMapping("/review/destination/{id}")
	public List<Review> getByDestinationId(@PathVariable String id) {
		long parsedId = Long.parseLong(id);
		return this.service.get(r -> r.getDestinationId() == parsedId);
	}
	
    @RequestMapping(value = "/review/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(@RequestBody Review review){
    	service.add(review);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
