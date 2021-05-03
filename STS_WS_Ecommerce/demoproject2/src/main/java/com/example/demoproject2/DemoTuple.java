package com.example.demoproject2;

public class DemoTuple {
	
	public static void main(String args[])
	{
		System.out.println("runing.....");
		
		MyStringBuffer sb = new MyStringBuffer();
		sb.append("test");
		sb.append("chandra");
		
		String one = "chandra";
		String two = null;
		if(one.equalsIgnoreCase(two))
		{
			System.out.println("true");
		}
		
		else
		{
			System.out.println("*********************false");
		}
		System.out.println(sb);
		
		Box b = new Box();
		b.set("chandrasXj");
		b.set(123);
		b.set(4456.78);
		System.out.println(b.get());
		
	}
	

}
