package com.scs.ecommerce.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class EcommerceExceptionDetails {

	private final String message;
	private final HttpStatus httpStatus;
	private final ZonedDateTime zoneDateTime;

	public String getMessage() {
		return message;
	}

	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ZonedDateTime getZoneDateTime() {
		return zoneDateTime;
	}

	public EcommerceExceptionDetails(String message, HttpStatus httpStatus,
			ZonedDateTime zoneDateTime) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.zoneDateTime = zoneDateTime;
	}

}
