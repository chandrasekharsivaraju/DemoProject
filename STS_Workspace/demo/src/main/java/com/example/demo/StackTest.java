package com.example.demo;

import java.util.Stack;

public class StackTest {
 public static void main(String args[]) {



     // Initialization of Stack
     // using Generics
     Stack<String> stack2 = new Stack<String>();

     stack2.push("chandra");
     stack2.push("sekhar");
     stack2.push("sivaraju");

     System.out.println(stack2);
     
     System.out.println(stack2.pop());
     
     System.out.println(stack2);
}
}
