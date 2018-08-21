package com.revature.hw1.q3;

public class Reverse {

	public static void main(String[] args) {
		
		// Throws the (hopefully single) word into a variable
		String reverse = args[0];
		
		// Each loop will take the value at the beginning of the string
		// and place it at the end while being behind previously moved values
		for (int i = 0 ; i < reverse.length() ; i++ ) {
			System.out.print("Before: " + reverse + " ");
			reverse = reverse.substring(1, reverse.length() - i) + reverse.substring(0, 1) + reverse.substring(reverse.length() - i, reverse.length());
			System.out.println("After: " + reverse);
		}
	}
}
