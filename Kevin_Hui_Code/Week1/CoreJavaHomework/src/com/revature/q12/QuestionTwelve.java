package com.revature.q12;

public class QuestionTwelve {
	
	
	/**
	 * Populate a new array of values from 1 to n.
	 * 
	 * @param n Maximum value and size of array.
	 * @return An integer array of values from 1 to n.
	 */
	public static int[] populateArray(int n) {
		int[] array = new int[n];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		
		return array;
	}
	
	/**
	 * Print out all even numbers contained in the array.
	 * Showcasing the use of the enhanced FOR loop.
	 * 	
	 * @param arr Array of values to be evaluated
	 */
	public static void printEvens(int[] arr) {
		for (int n: arr) {
			if(n % 2 == 0) {
				System.out.println(n);
			}
		}
	}
	
	public static void main(String[] args) {
		
		printEvens(populateArray(100));
		
	}

}
