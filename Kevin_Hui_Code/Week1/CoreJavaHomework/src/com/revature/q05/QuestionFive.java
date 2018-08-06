package com.revature.q05;

public class QuestionFive {
	
	/**
	 * Returns the substring of the provided string between index 0 and idx WITHOUT
	 * using any of the String.substring() methods.
	 * 
	 * Converts the input string into a character array and creates a new String object
	 * using the character array and an offset of 0 and a count of the user's idx argument
	 * 
	 * @param str The string in which the method will operate on
	 * @param idx The specified index that ends the substring to be returned
	 * @return
	 */
	public static String substring(String str, int idx) {
		return new String(str.toCharArray(), 0, idx);
	}
	
	public static void main(String[] args) {
		System.out.println(substring("Kevin", 3));
		System.out.println(substring("Another haiku", 6));
		System.out.println(substring("About my experience", 10));
		System.out.println(substring("Creating programs.", 8));
	}
}
