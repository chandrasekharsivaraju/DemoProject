package com.example.demo;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.demo.model.StreamModel;

public class StreamExamplesAdvanced {
	
	public static void main(String[] args) {
		
		
		//IntStream.range(1, 110).map(mapper)
		List<String> stringList = Arrays.asList("chandra","sreshta","teju","abhi");
		
		List<Integer> intList = Arrays.asList(1,6,89,3,44,15,18);
		
		StreamModel sm1 = new StreamModel(13, "chandramale");
		StreamModel sm2 = new StreamModel(8, "abhimale");
		StreamModel sm3 = new StreamModel(10, "tejufemale");
		StreamModel sm4 = new StreamModel(15, "sreshtafemale");
		
		List<StreamModel> listModels = Arrays.asList(sm1,sm2,sm3,sm4);
		
		
		//Sorting on multiple fields; Group by.
		Comparator<StreamModel> groupByComparator = Comparator.comparing(StreamModel::getId)
		                                                      .thenComparing(StreamModel::getName);
		listModels.sort(groupByComparator);
		
		Comparator<StreamModel> compareById = (StreamModel o1, StreamModel o2) -> o1.getId().compareTo( o2.getId() );
		 
		//how to use comparator
		Collections.sort(listModels, compareById); 
		
		//To sort in reverse order
		listModels.sort(compareById.reversed());
		
		
		Predicate<StreamModel> sp = s -> s.getName().contains("female");
		
		
		
	//	System.out.println(listModels);
		
		List<StreamModel>  newlist= listModels.stream().filter(sp)
		.sorted((sb1,sb2) -> sb1.getName().compareTo(sb2.getName()))
		//.map(s -> s.getName().concat(" special"))
		.map(obj -> obj.appendName("test"))
		.collect(Collectors.toList());
		//.collect(toMap(k -> k.)
		//.forEach(System.out :: println);
		
		System.out.println("********************************");
		
		System.out.println(newlist);
		System.out.println("********************************");
		System.out.println(
				listModels.stream()
				.collect(toMap(
						streamModel -> streamModel.getName(),
						streamModel -> streamModel.getId())));
		
		System.out.println(
				Stream.iterate(100, x -> x+2)
				.filter(x -> x%2 == 0)
				.limit(10)
				.mapToInt(x -> x)
				.sum()
				);
		
		
		
		System.out.println(
				listModels.stream()
				
				.collect(toList())
						
						);
		
		  List<String> stringListNew = stringList.stream(). filter(s -> s.length() <
		  5).map(s -> s.concat("test")) .sorted().collect(Collectors.toList());
		  
		  
		  List<Integer> intListNew = intList.stream(). filter(i -> i %2 == 0).map(i ->
		  i+5) .sorted().collect(Collectors.toList());
		  
		  Long failed = intList.stream().filter(i -> i < 35).count();
		  System.out.println(stringListNew);
		  
		 // System.out.println(intListNew);
		  
		  
		//  System.out.println(intListNew);
		 
	}

@Override
protected void finalize() throws Throwable {
	// TODO Auto-generated method stub
	super.finalize();
}

}
