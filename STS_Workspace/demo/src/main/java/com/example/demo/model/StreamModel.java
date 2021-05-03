package com.example.demo.model;

public class StreamModel {
	
	Integer id;
	String name;
	
	
	public StreamModel(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public StreamModel appendName(String s)
	{
		this.name = this.name.concat(s);
		return this;
		
	}
	@Override
	public String toString() {
		return "StreamModel [id=" + id + ", name=" + name + "]";
	}

}
