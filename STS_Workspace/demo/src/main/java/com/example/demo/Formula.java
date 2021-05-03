package com.example.demo;

//@FunctionalInterface
public interface Formula {
	
	double calculate();

    default int myNewFormula(int a) {
    	
        return a*10+5;
    }
}
