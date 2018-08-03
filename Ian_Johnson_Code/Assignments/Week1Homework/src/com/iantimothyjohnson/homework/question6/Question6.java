package com.iantimothyjohnson.homework.question6;

/**
 * Write a program to determine if an integer is even without using the modulus
 * operator (%).
 * 
 * @author Ian Johnson
 */
public class Question6 {
	/**
	 * Determines whether the given integer is even, without using the modulus
	 * operator.
	 * 
	 * @param n The integer to check.
	 * @return Whether n is even.
	 */
	public static boolean isEven(int n) {
		// The lowest bit of n is the 1's place in its binary representation.
		// Just how in base 10 we can determine if a number is divisible by 10
		// by seeing if the last digit (the 1's place) is 0, in binary (base 2)
		// we can check divisibility by 2 by checking whether the last digit is
		// 0. The bitwise operation (n & 1) simply returns the lowest bit
		// (either 1 or 0).
		return (n & 1) == 0;
	}
}
