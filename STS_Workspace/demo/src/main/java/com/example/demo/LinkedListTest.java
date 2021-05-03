package com.example.demo;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
 public static void main(String args[]) {


     // Creating an object of the
     // class linked list
     LinkedList<String> object
         = new LinkedList<String>();
    

     // Adding the elements to the
     // linked list
     object.add("A");
     object.add("B");
     object.addLast("C");
     
     Iterator i =object.iterator();
     while(i.hasNext())
     {
    	 System.out.println("****");
    	 System.out.println(i.next());
    	 System.out.println("****");
     }

     System.out.println(object);
     
     for(String s:object)
     {
    	 System.out.println(s);
     }

     // Removing elements from the
     // list
     object.remove("B");
     object.removeFirst();

     System.out.println("Linked list after "
                        + "deletion: " + object);
}
}
