package com.scs.spring.cloud.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientResource {

	@Value("${message: default value}")
	private String propertyMessgae;

	@GetMapping("greeting")
	public String getPropertyValue() {
		return " message from cloud server :: " + propertyMessgae + "\n";
	}
}

