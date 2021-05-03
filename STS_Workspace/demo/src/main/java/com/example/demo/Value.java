package com.example.demo;

@FunctionalInterface
public interface Value {
	
	static void display()
    {
    	System.out.println("display fron interface in static method");
    }
	
	int retrieve();

    default int calculate() {
        return retrieve() * 2;
    }
    
    default int calculate(int a) {
        return a * 4;
    }
    
    
}


