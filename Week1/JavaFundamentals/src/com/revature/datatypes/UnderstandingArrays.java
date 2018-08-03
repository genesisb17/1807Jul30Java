package com.revature.datatypes;

import java.util.Arrays;

public class UnderstandingArrays {

	/*
	 * An array is a group of variables
	 * Elements of an array must be the same type
	 * elements are accessed by an index
	 * the first element is at the 0th index
	 * find an array's size with arrayName.length
	 */
	
	public static void main(String[] args) {
		
		int[] nums = {9, 5, 2, 10};
		int[] n = new int[5];
		//n[10] = 7; wrong since there is no 10th value
		/* int[] wrong = new int[]; // in order to initialize
		 * an array, we must either explicitly add its values or
		 * specify the size we want to allocate to it
		 */
		
		int length = nums.length;
		int[][] twoD = new int[4][4];
		twoD[0][0] = 'x';
		
		for(int i = 0; i < twoD.length; i++) {
			for(int j = 0; j < twoD[i].length; j++) {
				System.out.println(twoD[i][j]);
			}
			System.out.println();
		}
		
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		System.out.println(add());
		System.out.println(add(1, 6, 34, 83));
	}

	//var args. Each method can only have 1 var args and it has to be the last parameter listed.
	//args and params are the same thing
	static int add(int... nums) {
		int sum = 0;
		for (int n: nums) {
			sum+=n;
		}
		return sum;
	}
}
