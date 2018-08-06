package com.revature.q04;

public class QuestionFour {
	
	/**
	 * Calculates n! in a recursive manner
	 * 
	 * Base case: n <= 1 will return 1
	 * Recursive call: factorial(n - 1)
	 * 
	 * @param n The input to calculate the factorial of n.
	 * @return the result of n!
	 */
	public static int factorial(int n) {
		// Ternary operator of the above description
		return (n <= 1) ? 1 : (n * factorial(n - 1));
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(factorial(6));
		System.out.println(factorial(7));
		System.out.println(factorial(8));
		System.out.println(factorial(9));
	}

}
