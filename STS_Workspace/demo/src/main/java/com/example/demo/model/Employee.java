package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Scope(value ="prototype")
public class Employee {
	
	@Autowired
	@Qualifier("lappy")
	Laptop laptop;

	public Employee() {
		super();
		
		System.out.println("****** object created **********");
		// TODO Auto-generated constructor stub
	}
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	String name;
	
	public  void show()
	{
		
		System.out.println("inside employee bean");
		laptop.compile();
	}

}

