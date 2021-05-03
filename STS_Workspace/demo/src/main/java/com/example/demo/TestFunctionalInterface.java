package com.example.demo;

@FunctionalInterface
public interface TestFunctionalInterface {
	
	static public void function1()
	{
		System.out.println("function 1");
	}
	
	default  void function2()
	{
		System.out.println("function 2");
	}
	
	public void function3();
	
	

}
