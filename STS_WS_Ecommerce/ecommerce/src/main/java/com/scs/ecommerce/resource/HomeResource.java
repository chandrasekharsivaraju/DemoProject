package com.scs.ecommerce.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeResource {

	@GetMapping
	public String home() {

		System.out.println("*** Inside Home Resource ******");
		return "home.jsp";

	}

}
