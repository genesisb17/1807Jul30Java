package com.iantimothyjohnson.homework.question4;

/**
 * Write a program to compute N factorial.
 * 
 * @author Ian Johnson
 */
public class Question4 {
	/**
	 * Compute n factorial using recursion. Please note that large values of n will
	 * not return the expected results if the resulting factorial could not fit in a
	 * long.
	 * 
	 * @param n The number whose factorial should be computed.
	 * @return The result of computing n factorial.
	 */
	public static long factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Cannot compute the factorial of a negative number.");
		} else if (n == 0) {
			// 0! is defined to be 1.
			return 1;
		} else {
			// n! == n * (n - 1)!
			return n * factorial(n - 1);
		}
	}
}
