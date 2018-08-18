package com.revature.datatypes;

public class Wrappers {

	public static void main(String[] args) {

		/* Primitives and their Wrappers
		 * int - 4 bytes - Integer
		 * char - 2 bytes - Character
		 * boolean - ? - Boolean
		 * double - 8 bytes - Double
		 * long - 8 bytes - Long
		 * float - 4 bytes - Float
		 * short - 2 bytes - Short
		 * byte - 1 byte - Byte
		 */
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		int five = Integer.parseInt("5");
		int willCauseException = Integer.parseInt("one hundred");
		
		Integer i = new Integer(80);
		int eighty = i; //unboxing 
		
		int x = 10;
		Integer wrapped = x; //autoboxing
	}

}
