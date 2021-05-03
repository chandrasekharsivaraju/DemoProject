package com.scs.movie.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scs.movie.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@GetMapping("{userId}")
	public Movie getMovieDetails(@PathVariable String userId)
	{
		return new Movie(123, "Baahubali", "Casting :: Prabhas Anushka");
		
	}

}
