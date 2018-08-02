package com.revature.q1;

public class QuestionOne {
	
	/**
	 * Using bubble sort, sorts the array in ascending order
	 * 
	 * @param input An array of integers in its unordered form.
	 * @return The array sorted from lowest value to highest value.
	 */
	public static int[] bubbleSort(int[] input) {
		int hold = 0;
		
		/* In each iteration of i, push the largest value 
		 * to the n - i position of the array.
		 */
		for(int i = 0; i < input.length - 1; i++) {
			for(int k = 0; k < input.length - i - 1; k++) {
				if(input[k] > input[k + 1]) {
					hold = input[k];
					input[k] = input[k + 1];
					input[k + 1] = hold;
				}
			}
		}
		
		return input;
	}
	
	public static void main(String[] args) {
		int[] example = {1,0,5,6,3,2,3,7,9,8,4};
		
		// Store result of the sort
		int[] result = bubbleSort(example);
		
		// Prints the sorted array
		for(int x: result) {
			System.out.print(x + " ");
		}
	}
}
