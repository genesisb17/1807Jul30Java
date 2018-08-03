package com.iantimothyjohnson.homework.question10;

/**
 * Find the minimum of two numbers using ternary operators.
 * 
 * @author Ian Johnson
 */
public class Question10 {
	/**
	 * Return the minimum of the two given numbers using a ternary operator.
	 * 
	 * @param a The first number.
	 * @param b The second number.
	 * @return The minimum of a and b.
	 */
	public static int min(int a, int b) {
		// Read as "if a < b then a, else b".
		return a < b ? a : b;
	}
}
