package com.iantimothyjohnson.homework.question18;

/**
 * Write a program having a concrete subclass that inherits three abstract
 * methods from a superclass. Provide the following three implementations in the
 * subclass corresponding to the abstract methods in the superclass:
 * 
 * <ol>
 * <li>Check for uppercase characters in a string, and return ‘true’ or ‘false’
 * depending if any are found.</li>
 * <li>Convert all of the lower case characters to uppercase in the input
 * string, and return the result.</li>
 * <li>Convert the input string to integer and add 10, output the result to the
 * console.</li>
 * </ol>
 * 
 * Create an appropriate class having a main method to test the above setup.
 * 
 * @author Ian Johnson
 */
public class Question18 extends Question18Abstract {
	@Override
	public boolean containsUpperCase(String str) {
		// Iterate through all the characters of the string and see if we can
		// find any uppercase ones.
		for (char c : str.toCharArray()) {
			// Alternatively, if ('A' <= c && c <= 'Z')
			if (Character.isUpperCase(c)) {
				// We can return early as soon as we find an uppercase letter.
				return true;
			}
		}
		// If the loop finishes, there must not have been any uppercase letters.
		return false;
	}

	@Override
	public String toUpperCase(String str) {
		// Of course we could just use str.toUpperCase, but that would be too
		// simple, so let's use a StringBuilder to build the resulting string
		// character-by-character.
		StringBuilder sb = new StringBuilder(str.length());
		for (char c : str.toCharArray()) {
			// Alternatively, check if c is lowercase and, if so, compute (c -
			// 'a' + 'A').
			sb.append(Character.toUpperCase(c));
		}
		return sb.toString();
	}

	@Override
	public void addTenAndOutput(String str) {
		// We won't bother checking for malformed numbers here; the caller
		// should catch the exception.
		int n = Integer.parseInt(str);
		System.out.println(n + 10);
	}
}
