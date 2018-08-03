package com.revature.datatypes;

public class Wrappers {
	
	public static void main(String[] args) {
		
		/*
		 * Wrapper Classes - an entity that gives you object 
		 * functionality for each of your primitive data types
		*/
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		int five = Integer.parseInt("5");
		// willCauseException = Integer.parseInt("one hundred);
		
		Integer i = new Integer(80);
		int eighty = i; //(un)boxing. Going from primitive data type to wrapper class or vice versa
		//casting changes the reference type of an entity. i.e. int -> char
		
		int x = 10;
		Integer wrapped = x; //autoboxing
	}
	
}
