package com.revature.reverse;

public class Reverse {

	public static void main(String[] args) {
		
		// Throws the argument in a variable
		String reverse = args[0];
		
		// Will read and reverse each character in a string
		for (int i = 0 ; i < reverse.length() ; i++ ) {
			reverse = reverse.substring(1, reverse.length() - i)
	        + reverse.substring(0, 1)
	        + reverse.substring(reverse.length() - i, reverse.length());
		}
		
		System.out.println(reverse);
	}
}
