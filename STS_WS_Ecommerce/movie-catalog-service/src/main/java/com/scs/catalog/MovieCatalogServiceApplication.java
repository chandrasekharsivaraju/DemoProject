package com.scs.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.scs.catalog.resources.MyFeignClient;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MovieCatalogServiceApplication {

	@Bean
	@LoadBalanced //Rest Template now finds the service from Eureka server mentioned with service name in URL
	RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	
	
	/*
	 * @Bean
	 * 
	 * @LoadBalanced 
	 * WebClient.Builder getWebClinetBuilder() 
	 * { 
	 * return WebClient.builder();
	 *  }
	 */
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
