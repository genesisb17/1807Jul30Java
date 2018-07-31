package com.revature.datatypes;

public class Wrappers {

	public static void main(String[] args) {

		/*
		 * Primitives and their wrappers
		 * int - 4 bytes - Integer
		 * char - 2 bytes - Character
		 * boolean = ? - Boolean
		 * doubele - 8 bytes - Double
		 * long - 8 bytes - Long
		 * 
		 */
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		int five = Integer.parseInt("5");
//		int willCauseException 0 Integer.parseInt("one hundred");
		
		Integer i = new Integer(80);
		int eighty = i; //unboxing - taking a wrapper class and converting it into the primitive
		
		int x = 10;
		Integer wrapped = x; //autoboxing - taking a primitive and converting it into some wrapped class
	}

}
