package cjh.question12;

public class Evens {
	/*
	 * Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. 
	 * Use the enhanced FOR loop for printing out the numbers.
	 */
	
	public static void getEvens(int[] nums) {
		for(int n:nums) {
			if(n % 2 == 0) {
				System.out.println(n);
			}
		}
	}

}
