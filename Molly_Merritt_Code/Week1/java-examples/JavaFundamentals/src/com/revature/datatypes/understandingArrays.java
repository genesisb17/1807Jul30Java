package com.revature.datatypes;

import java.util.Arrays;

public class understandingArrays {
	
	/* An array is a group of variables
	 * Elements of an array must be the same type
	 * Elements are accessed by an index
	 * The first element is at the 0th index
	 * Find an array's size with arrayName.length
	 */
	
	public static void main(String[] args) {
		int[] nums = {9, 5, 2, 10};
		int[] n = new int[5];
		
		// cannot do the following bc arrays are not dynamic:
		// int[] wrong = new int[];
		/* in order to initialize an array, we must either explicitly 
		 * add its values or specify the size we want to allocate to it
		 */
		
		int length = nums.length;	// property of an array, not a method
		
		int[][] twoD = new int[4][4];	// 2D array
		twoD[0][0] = 'x';	// stores ASCII value of x
		
		for (int i=0; i<twoD[i].length; i++) {
			for (int j=0; j < twoD[i].length; j++) {
				System.out.print(twoD[i][j]);
			}
			System.out.println();
		}
		
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	
	// var args
	// can only have one per param list and must be last in the param list
	static int add(int a, int b, int c) { // make static so we can access from main method
		return a+b+c;
	}	// we can have a variable number of arguments
	static int addVarArgs(int... nums) {
		int sum = 0;
		for (int n:nums) {
			sum += n;
		} return sum;
	}
	/* if we know we need at least a certain number of parameters,
	 * we can do the following:
	 * 
	 * static int add(int a, int b, int... nums)
	 */

}
