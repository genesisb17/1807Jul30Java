package com.revature.datatypes;

import java.util.Arrays;

public class UnderstandingArrays {
	/* An array is a group of variables
	 * Elements of an array must be the same type
	 * elements are accessed by an index
	 * the first element is at the 0th index
	 * find an array's size with arrayName.length
	 */
	
	public static void main(String[] args) {
		int[] nums= {9 , 5, 2, 10};
		int[] n = new int[5];
	//	n[10] = 7;
	/*	int[] wrong  = new int[]; // in order to initialize
	 * an array, we must either explicitly add its values
	 * or specify the size we want to allocate to it
	 */
		
		int length = nums.length;
		
		int[][] twoD = new int[4][4];
		twoD[0][0]  = 0; 
		twoD[0][1] = 1;
		twoD[1][0] = 1;
		
		
		for(int i= 0; i < twoD.length; i++) {
			for(int j = 0; j < twoD[i].length; j++) {
				System.out.print(twoD[i][j]);
			}
			System.out.println();
		}
		
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		System.out.println(add());
		System.out.println(add(1, 20958029, 34, 15));
		System.out.println(add(10, 10, 3, 5, 7, 9));
		int[] example = {1, 5,2,5, 2};
		System.out.println(example);
	}
	
	//var args
	//can only have one per param list. and must be last param in list
	static int add( int... nums) { //int[] nums
		int sum = 0;
		for(int n:nums) {
			sum+=n;
		}
		return sum;
	}
}
