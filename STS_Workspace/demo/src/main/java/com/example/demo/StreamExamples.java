package com.example.demo;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.example.demo.model.Gender;
import com.example.demo.model.People;

public class StreamExamples {

	public static void main(String[] args) {

		List<People> modelList = Arrays.asList(
				new People("chandra", 30, Gender.MALE),
				new People("abhi", 7, Gender.MALE),
				new People("sreshta", 2, Gender.FEMALE),
				new People("tejaswi", 26, Gender.FEMALE),
				new People("chandra", 25, Gender.MALE),
				new People("tejaswi", 28, Gender.FEMALE)
		);
		
		
		Map newList = modelList.stream().collect(groupingBy(People::getName));
		System.out.println("***:: "+newList);

		//Create Map with key as name and value as age of people with same name
		Map resultMap = modelList
		.stream()
		.collect(groupingBy(People::getName,mapping(People::getAge,toList())));
		
		System.out.println(resultMap);
		
		Integer i =11;
		Integer j =12;
		
		System.out.println(i.hashCode());
		System.out.println(j.hashCode());
		

	}
}
