package com.iantimothyjohnson.homework.question12;

/**
 * Write a program to store numbers from 1 to 100 in an array. Print out all the
 * even numbers from the array. Use the enhanced FOR loop for printing out the
 * numbers.
 * 
 * @author Ian Johnson
 */
public class Question12 {
	public static void main(String[] args) {
		// We need to create the array first and then store the numbers in it.
		int[] nums = new int[100];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1; // i + 1 since the numbers start at 1, not 0.
		}

		// Now, we use the enhanced for loop to print out all the even numbers.
		for (int n : nums) {
			// Recall the simple test for divisibility using the modulus
			// operator.
			if (n % 2 == 0) {
				System.out.println(n);
			}
		}
	}
}
