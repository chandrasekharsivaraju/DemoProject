package com.scs.ratings.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scs.ratings.model.Rating;

@RestController
@RequestMapping("/rating")
public class RatingResource {
	
	@GetMapping("{movieId}")
	public Rating getRating(@PathVariable int movieId) {
		
		return new Rating(movieId, 5);
	}

}
