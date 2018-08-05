package com.revature.Q8;

import java.util.ArrayList;

public class Q8 {
	
	
	public static Boolean isPalindrome(String input) {
		
			String mystr = input.replaceAll("[^A-Za-z]+", "").toUpperCase();
			String revstring = "";
			for (int i = mystr.length() - 1; i > -1; i--) {
				revstring = revstring + mystr.charAt(i);
			}
			if (revstring.equals(mystr)) {
				return true;
			} else {
				return false;
			}
	}
	
//-------------------------------------------------------------------	
	public static void createPalindromeArray(ArrayList<String> array) {
		ArrayList <String> onlyPalindromes = new ArrayList<String>();
		
		for(String i : array) {
			if (isPalindrome(i)) {
				onlyPalindromes.add(i);
				
			}
		}
		
		for(String i : onlyPalindromes) {
			System.out.println(i);
		}
	}
//--------------------------------------------------------------==	
	public static void main(String[] args) {
		
		ArrayList<String> words = new ArrayList<String>();
		
		words.add("madam");
		words.add("karan");
		words.add("tom");
		words.add("did");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("civic");
		
		
		createPalindromeArray(words);
		
		
	}
}
