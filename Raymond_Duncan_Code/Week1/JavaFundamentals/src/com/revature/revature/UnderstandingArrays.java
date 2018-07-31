package com.revature.revature;

import java.util.Arrays;

public class UnderstandingArrays {
	/*An array is a group of variables
	 * Elements of an array must be the same type
	 * elements are accessed by an index
	 * the first element is at the 0th index
	 * find an array's size with arrayName.length
	 */
	
	public static void main(String[] args) {

		int[] nums = {9,5,2,10};
		int [] n = new int[5];
//		n[10] = 7;
		/* 
		 * int [] wrong = new int[] // in order to initialize
		 * an array we myst either explicitly add it's values or specify the size we want to allocate to it
		 */
		
		int length = nums.length;
		
		int[][]twoD = new int[4][4];
		twoD[0][0] = 0;
		twoD[0][1] = 1;
		twoD[1][0] = 1;
		
		for(int i = 0; i < twoD.length; i++) {
			for(int j = 0; j < twoD[i].length; j++) {
				System.out.print(twoD[i][j]);
			}
			System.out.println();
		}
		
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(add(1,2,3,4,5,66));
	}
	
	//var args
	static int add(int... nums) {
		/*
		 * This is a demonstration of var args
		 * it is a method of manipulating a varying number of arguments
		 * You can only have one var-args per method, and it must come at the end of the parameter list
		 */
		int sum = 0;
		for(int n:nums) {
			sum+=n;
		}
		return sum;
	}

}
