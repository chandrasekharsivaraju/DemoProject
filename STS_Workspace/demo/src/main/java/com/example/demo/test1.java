package com.example.demo;

import java.util.Arrays;
import java.util.List;

import sun.net.spi.nameservice.dns.DNSNameService;

public class test1 {

	public static void main(String args[]) {
		 
		 
		 		int minFloor = 0;
				int  maxFloor = 100;
				int counter = 0;
				int breakFloor= 74;
				int dropFloor=0;
				int eggs=2;
				
				System.out.println("Classloader of Application :" + ProdConsumer.class.getClassLoader());
				System.out.println("Classloader of DNSNameService :" + DNSNameService.class.getClassLoader());

				try {

					Class one = ClassLoader.getSystemClassLoader().loadClass("com.example.demo.ThreadA");
					Class two = Class.forName("com.example.demo.ThreadB");

					/*
					 * ThreadA obj = (ThreadA) one.newInstance(); obj.display();
					 */

					System.out.println("Name of Class  = " + one.getName()); // get the name of class
					System.out.println("Package Name  = " + one.getPackage());// get the name of class

					System.out.println("one :: " + one);
					System.out.println("two ::" + two);

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				String s="chandra";
				
				List<String> listValues = Arrays.asList("scs","dcs");
				
				Object ss ="scs";
				if(listValues.contains(ss))
				{
					System.out.println("scs found");
				}
				
				
				//System.out.println("answer is "+d.calculate(10));
						
				boolean iterate=Boolean.TRUE;
				
				while(iterate)
				{
					
					counter++;
					dropFloor = (minFloor+maxFloor)/2;

					
						System.out.println("drop floor ::"+dropFloor);
					if(dropFloor > breakFloor)
					{
					eggs =  eggs - 1;

						if(eggs==1)
						{
							System.out.println("eggs are over");
							
							for(;minFloor<breakFloor;minFloor++)
							{
								counter++;
							}
							
							iterate=Boolean.FALSE;
							
						}
						
						else
						{
						maxFloor = dropFloor;
						}


					}
					else if(dropFloor < breakFloor)
					{
					minFloor = dropFloor;

					}
					
					else if(dropFloor == breakFloor)
					{
						System.out.println("drop floor found");
						iterate=Boolean.FALSE;

					}
					
					
					
				}
				
				//System.out.println("counter is "+counter);	
	}
	 
	

}
