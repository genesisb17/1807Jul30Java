package com.iantimothyjohnson.homework.question3;

/**
 * Reverse a string without using a temporary variable. Do NOT use reverse() in
 * the StringBuffer or the StringBuilder APIs.
 * 
 * @author Ian Johnson
 */
public class Question3 {
	/**
	 * Reverse the given String without using a temporary variable.
	 * 
	 * @param str The String to reverse.
	 * @return The reversed string.
	 */
	public static String reverse(String str) {
		// Since Java strings are immutable, it is impossible to reverse str
		// in-place. Thus, we actually do need a temporary variable here to
		// build the reversed string.
		StringBuilder sb = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	/**
	 * Reverse the given String without using a temporary variable (alternate
	 * implementation which is closer to the process that we would use if Java
	 * Strings were mutable).
	 * 
	 * @param str The String to reverse.
	 * @return The reversed string.
	 */
	public static String reverseAlternate(String str) {
		// Here, we convert String to an array of chars, and then operate on the
		// array in-place. If Java Strings were mutable, we could do this on the
		// String directly without the need for this array.
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length / 2; i++) {
			// We also need another temporary variable here in order to swap the
			// characters.
			char tmp = chars[i];
			chars[i] = chars[chars.length - i - 1];
			chars[chars.length - i - 1] = tmp;
		}
		// Now, we can reconstruct the reversed String.
		return new String(chars);
	}
}
