package org.ucll.da.review.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReviewService {

	private List<Review> reviews;
	
	public ReviewService(){
		reviews = new ArrayList<>();
		init();
	}
	
	public List<Review> get(Predicate<Review> test){
		return (List<Review>) reviews.stream().filter(test).collect(Collectors.toList());
	}
	
	public void add(Review review){
		this.reviews.add(review);
	}

	private void init() {
		Review r1 = new Review();
		r1.setId(1);
		r1.setDestinationId(1);
		r1.setTitle("Rustig dorp.");
		r1.setReview("Nieuwerkerken is een rustig dorp. Gelegen tussen bossen, plantages en velden.");
		r1.setAuthor("Liesbeth Vandevenne");
	}
}
