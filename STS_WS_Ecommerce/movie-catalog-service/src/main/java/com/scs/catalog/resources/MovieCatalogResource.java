package com.scs.catalog.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.scs.catalog.model.Catalog;
import com.scs.catalog.model.Movie;
import com.scs.catalog.model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*
	 * @Autowired private WebClient.Builder webClientBuilder;
	 */
	
	@Autowired
	private MyFeignClient myFeignClient;
	
	
	
	@GetMapping("{userId}")
	public List<Catalog> getCatalogItems(@PathVariable String userId)
	{
		//Calling MOVIE-INFO-SERVICE Micro Service to get movie details for particular User
		
		//Movie movie = restTemplate.getForObject("http://localhost:8081/movies/"+userId, Movie.class);
		
		//movie-info-servie name will be searched in Eureka server and mapped to the corresponding service url
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+userId, Movie.class);
		
		System.out.println(" Movies from catalog resource :: "+movie);
				
		//Calling RATINGS-DATA-SERVICE Micro Service to get rating details for particular movie
				
		 
		/* Using Webclient to Asynchronously fetch data from RATINGS-DATA-SERVICE Micro Service
		 * 
		 * Rating rating = webClientBuilder.build().get().uri("http://ratings-data-service/rating/"+movie.getMovieId())
						.retrieve()
						.bodyToMono(Rating.class)
						.block(); */
		
		Rating rating =myFeignClient.getRating(movie.getMovieId());
		
			
		System.out.println(" Rating from catalog resource :: "+rating);
		 		
		return Collections.singletonList(new Catalog(movie.getMovieName(),
													 movie.getMovieDescription(),
													 rating.getRating()));
	
	}

}
