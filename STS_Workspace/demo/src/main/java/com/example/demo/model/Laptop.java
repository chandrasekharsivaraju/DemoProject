package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component("lappy")
public class Laptop {
	
	int assetId;

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	
	public void compile()
	{
		
		System.out.println("*** compiling ******");
	}
	
	

}
