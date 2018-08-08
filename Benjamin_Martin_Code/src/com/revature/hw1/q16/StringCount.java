package com.revature.hw1.q16;

public class StringCount {
	
	public static void main(String[] args) {
		
		// Stores the argument given
		String input = args[0];
		// For store the count
		int counter = 0;
		
		System.out.println("The total length of the string is: " + input.length());
		
		// Will loop and count 
		for (int i = 0 ; i < input.length() ; i++ ) {
			if (Character.isLetter(input.charAt(i)))
		        counter++;
		}
		System.out.println("The number of characters in the string " + input + " is " + counter);
	}
}
