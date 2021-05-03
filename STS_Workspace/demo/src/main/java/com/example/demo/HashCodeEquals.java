package com.example.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import com.example.demo.model.HashEqualsModel;

public class HashCodeEquals {
	public static void main(String args[]) {
		
		HashEqualsModel obj1 = new  HashEqualsModel("chandra", 123);
		HashEqualsModel obj2 = new  HashEqualsModel("chandra", 123);
		
		Hashtable<HashEqualsModel, String> table = new Hashtable<>();
		
		table.put(obj1, "scs");
		
		Integer i = 10;
		System.out.println(i.hashCode());
		
		//Hashset Does not allow duplicate values
		Set setObject = new HashSet();
		
		setObject.add(obj1);
		setObject.add(obj2);
		
		System.out.println(setObject);
		
		//HashMap does not allow duplicate keys
		Map mapObject = new HashMap();
		
		mapObject.put(obj1, "kavali");
		mapObject.put(obj2, "nellore");
		
		System.out.println(mapObject);

	}
}
