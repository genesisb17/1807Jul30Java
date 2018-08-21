package com.revature.hw1.q5;

import java.util.Scanner;

public class Substring {

	public static void main(String[] args) {
		
		// Scanners that assign each input to a variable
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string.");
        String str = sc.next();
		System.out.println("Enter the index number you wish for it to stop at");
		int idx = sc.nextInt();
		
		// Creates a string variable that's the results of the getString method
		String newString = getString(str, idx);

		// Prints the result
		System.out.println(newString);
		
		// Closes the scanner resource
		sc.close();
	}
	
	public static String getString(String str, int idx) {
		
		// Empty string for loop
		String newString = "";
		
		// Will loop until it reaches index number or length (in case they enter an index number higher than the length of the string)
		for (int i = 0 ; i < str.length(); i++ ) {
			newString = newString + str.charAt(i);
			if (i >= idx - 1) {
				break;
			}
		}
		return newString;
	}
}
