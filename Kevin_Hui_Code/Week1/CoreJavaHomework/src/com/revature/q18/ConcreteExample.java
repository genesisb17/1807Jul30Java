package com.revature.q18;

/**
 * The ConcreteExmaple class implements the three methods from the interface.
 * @author Kevin Hui
 *
 */
public class ConcreteExample extends AbstractExample {
	
	/*
	 * Check for uppercase characters in a string, and
	 * return ‘true’ or ‘false’ depending if any are found. 
	 */
	@Override
	public boolean containsUppercase(String str) {
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) >= 'A') && (str.charAt(i) <= 'Z')) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Convert all of the lower case characters to uppercase
	 * in the input string, and return the result. 
	 */
	@Override
	public String convertToUppercase(String str) {
		return str.toUpperCase();
	}
	
	/*
	 * Convert the input string to integer and add 10,
	 * output the result to the console.
	 */
	@Override
	public Integer convertToIntPlusTen(String str) {
		return Integer.parseInt(str) + 10;
	}

}
