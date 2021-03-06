package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface Sayable{  
    void say();  
}  

class TestMethodReference {

	public static void display() {
		System.out.println("no argument display:: ");
	}

	public static void print(String s) {
		System.out.println("argument display :: "+ s);
	}

	public static int get(int a) {
		return a;
	}

	public static int add(int a, int b) {
		return a + b;
	}
}

public class MethodRefernce {
	
	public static void main(String[] args) {
		
		List<String> stringList = Arrays.asList("chandra", "abhi");
		
		//Functional interface is required for accepting method reference object
		//FI is required if we don't have arguments and no return type
		Sayable s = TestMethodReference::display;
		s.say();
		

		stringList.forEach(TestMethodReference::print);

		Function<Integer, Integer> getReference = TestMethodReference::get;

		System.out.println(" Get method Value "+getReference.apply(10));

		BiFunction<Integer, Integer, Integer> addReference = TestMethodReference::add;  
		
		System.out.println(" add method Value "+addReference.apply(10, 20));
	}
}
