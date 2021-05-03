package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator {
	
	@Autowired(required=false)
	CalculatorService calculatorService;
	
	public int compute(int a, int b) {
		
		int sum = calculatorService.addition(a, b);
		
		return sum*4;
	}

}
