package com.example.demoproject2;

import java.util.Arrays;

public class MyStringBuffer {
	
	int length;

	char[] data = null;
	public void append(String s)
	{
		
		if (data != null) {
			
			char[] temp = s.toCharArray();
			int l = data.length;
			if (s != null)
				for (char c : temp) {
					System.out.println(c);
					data[length++] = c;
				}
		}
		else
		{length = s.length();
			data = new char[100];
			int i =0;
			char[] temp = s.toCharArray();
			System.out.println(temp.toString());
			for (char c : temp) {
				data[i++] = c;
			}
		}
	}
	@Override
	public String toString() {
		return "MyStringBuffer [data=" + Arrays.toString(data) + "]";
	}
	
	
	
}
