package com.revature.q3;

public class QuestionThree {
	
	/**
	 * Recursively reverses a string WITHOUT using the String.reverse() method
	 * 
	 * @param s The string to be reversed
	 * @return A string that returns the last char of the passed String s and appends the result of the recursive call.
	 */
	public static String reverseString(String s) {
		try {
			return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
		} catch (StringIndexOutOfBoundsException e) {
			return "";
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(reverseString("Life"));
		System.out.println(reverseString("I'm in Virginia"));
		System.out.println(reverseString("Learning Java in Reston."));
		System.out.println(reverseString("What am I doing?"));

	}
}
