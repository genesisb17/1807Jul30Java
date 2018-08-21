package com.revature.hw1.q8;

import java.util.*;

public class Palindrome {
	
	public static void main(String[] args) {
		
		ArrayList<String> listOfString = new ArrayList<String>();
		
		//ArrayList to hold all palindromes
		ArrayList<String> Palindromes = new ArrayList<String>();
		
		listOfString.add("karan");
		listOfString.add("madam");
		listOfString.add("torn");
		listOfString.add("civic");
		listOfString.add("radar");
		listOfString.add("sexes");
		listOfString.add("jimmy");
		listOfString.add("kayak");
		listOfString.add("john");
		listOfString.add("refer");
		listOfString.add("billy");
		listOfString.add("did");
		
		// First for loop to stop at each index of the ArrayList
		for (int i = 0 ; i < listOfString.size() ; i++) {
			
			// Sets up the variables used by the while loop
			String name = listOfString.get(i);
			int strSize = name.length();
			int forward = 0;
			int backward = strSize - 1;
			boolean isPalindrome = true; 
			
			// Checks value-by-value in a string to ensure that they are the same
			while (backward > forward) {
				char forwardChar = name.charAt(forward++);
				char backwardChar = name.charAt(backward--);
				if (forwardChar != backwardChar) {
					//Needs to break and head back to the original for loop
					isPalindrome = false;
					break;
				}	
			}
			// Only does this if it does passes the if loop
			if (isPalindrome) {
				Palindromes.add(listOfString.get(i));
			}
		}
		// To show what got written to the new ArrayList
		System.out.println(Palindromes);
	}
}
