package com.revature.q08;

import java.util.ArrayList;

public class QuestionEight {
	
	// Checks whether or not a string is a palindrome
	public static boolean isPalindrome(String s) {
		for(int i = 0; i < s.length() / 2; i++) {
			if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	// Filters the list
	public static ArrayList<String> filterListPalindrome(ArrayList<String> inputList) {
		ArrayList<String> pList = new ArrayList<String>();
		
		for(String str: inputList) {
			if(isPalindrome(str)) {
				pList.add(str);
			}
		}
		
		return pList;
	}
	
	public static void main(String[] args) {
		
		// Creating the ArrayList and adding in the example Strings
		ArrayList<String> exList = new ArrayList<String>();
		
		exList.add("karan");
		exList.add("madam");
		exList.add("tom");
		exList.add("civic");
		exList.add("radar");
		exList.add("sexes");
		exList.add("jimmy");
		exList.add("kayak");
		exList.add("john");
		exList.add("refer");
		exList.add("billy");
		exList.add("did");
		
		System.out.println("Example List: " + exList);
		
		System.out.println("Filtered List: " + filterListPalindrome(exList));
	}

}
