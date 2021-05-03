package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class MyBean {
	public MyBean() {
		System.out.println("MyBean instance created");
	}
	
	public void display()
	{
		System.out.println("inside display method");
	}
	
	List<String> stringList = new ArrayList<>();
	
	
}
