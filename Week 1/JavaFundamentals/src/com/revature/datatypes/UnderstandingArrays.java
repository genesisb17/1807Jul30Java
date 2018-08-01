package com.revature.datatypes;

import java.util.Arrays;

public class UnderstandingArrays {
	/*An array is a group of variables
	 * elements of an array must be the same type
	 * elements are accessed by an index
	 * the first element is at the 0th index
	 * find an array's size with arrayName.length
	 */
	public static void main(String[] args) {
		int [] nums= {9, 5, 2, 10};
		int [] n = new int[5];
		//n[10] = 7;
		//int [] wrong = new int[]; in order to initialize 
		//an array, we must either explicitly add its value
		//or specify the size we want to allocate to it
		
		int length = nums.length; //length is a property of an array
		
		int[][] twoD = new int[4][4];
		twoD[0][0] = 0;
		twoD[0][1] = 1;
		twoD[1][0] = 1;
		
		
		
		for(int i = 0; i < twoD.length; i++) {
			for(int j = 0; j < twoD[i].length; j++) {
				System.out.print(twoD[i][j]);
			}
			System.out.println("\n");
		}
		
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		System.out.println(add());
		System.out.println(add(1, 20393, 34, 51));
		System.out.println(add(12, 203, 2310 ,2));
	}
	
	//var args
	//can only have one per param list. and must be last param in list
	static int add(int... nums) {
		int sum = 0;
		for (int n:nums) {
			sum += n;
		}
		return sum;
	}


}
