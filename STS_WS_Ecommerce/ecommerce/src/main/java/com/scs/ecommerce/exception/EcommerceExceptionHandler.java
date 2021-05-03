package com.scs.ecommerce.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EcommerceExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Object> handleDataNotFoundExcpetion(DataNotFoundException e)
	{
		System.out.println("****** inside exception handler *********");
		
		EcommerceExceptionDetails details = new EcommerceExceptionDetails
				(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());
		
		
		return new ResponseEntity<Object>(details,HttpStatus.NOT_FOUND);
	}

}
