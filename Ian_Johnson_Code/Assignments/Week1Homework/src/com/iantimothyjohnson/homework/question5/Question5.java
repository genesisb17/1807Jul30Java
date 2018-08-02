package com.iantimothyjohnson.homework.question5;

/**
 * Write a substring method that accepts a string str and an integer idx and
 * returns the substring contained between 0 and idx-1 inclusive. Do NOT use any
 * of the existing substring methods in the String, StringBuilder, or
 * StringBuffer APIs.
 * 
 * @author Ian Johnson
 */
public class Question5 {
	public static void main(String[] args) {
		System.out.println("substring(\"Hello\", 2) = " + substring("Hello", 2));
		System.out.println("substring(\"substring\", 5) = " + substring("substring", 5));
		System.out.println("substring(\"Hi\", 2) = " + substring("Hi", 2));
		System.out.println("substring(\"very long\", 0) = " + substring("very long", 0));
	}

	/**
	 * Retrieve the substring of str between indices 0 and idx - 1, inclusive.
	 * 
	 * @param str The string from which to get the substring.
	 * @param idx The index of the first character after the end of the desired
	 *            substring. Must be at least 0 and no greater than str.length(). If
	 *            idx is 0, then the empty string will be returned.
	 * @return The resulting substring.
	 */
	public static String substring(String str, int idx) {
		if (idx < 0 || idx > str.length()) {
			throw new IllegalArgumentException("Invalid end index for substring.");
		}
		// We use a StringBuilder here, because it should be faster than adding
		// characters one by one to a String (since doing the latter would
		// require creating a new String at each step; Strings are immutable).
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < idx; i++) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
}
