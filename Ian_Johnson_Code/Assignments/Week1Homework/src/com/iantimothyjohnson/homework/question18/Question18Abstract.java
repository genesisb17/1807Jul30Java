package com.iantimothyjohnson.homework.question18;

public abstract class Question18Abstract {
	/**
	 * Determine whether the given string contains any uppercase characters.
	 * 
	 * @param str The string to check.
	 * @return Whether str contains any uppercase characters.
	 */
	public abstract boolean containsUpperCase(String str);

	/**
	 * Convert the lowercase characters in the given string to uppercase.
	 * 
	 * @param str The string to convert.
	 * @return The string, with all lowercase characters replaced by their
	 *         corresponding uppercase characters.
	 */
	public abstract String toUpperCase(String str);

	/**
	 * Convert the given string to an integer, add 10, and print the resulting
	 * number to the standard output.
	 * 
	 * @param str A string containing the decimal representation of the integer to
	 *            operate on.
	 */
	public abstract void addTenAndOutput(String str);
}
