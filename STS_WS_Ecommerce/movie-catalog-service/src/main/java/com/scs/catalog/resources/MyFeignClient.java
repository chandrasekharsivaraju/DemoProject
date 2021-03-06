package com.scs.catalog.resources;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.scs.catalog.model.Rating;

/*
 * Feign Client provides Load Balancing using ribbon client and fault tolerance using Hystrix
 * with the provided name attribute it will automatically checks in Eureka server for service no need of 
 * @LoadBalanced annotation(which is required for Rest Template and Web Client)
 */
@FeignClient(name = "ratings-data-service")
public interface MyFeignClient {

	@GetMapping("/rating/{id}")
	public Rating getRating(@PathVariable int id);
}


