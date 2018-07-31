package com.iantimothyjohnson.notes;

import java.util.Arrays;

public class UnderstandingArrays {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] nums = { 9, 5, 10 };
		int[] n = new int[5];
		int length = nums.length;

		// You can have 2D arrays too.
		int[][] twoD = new int[4][4];
		twoD[0][0] = 'x';
		for (int i = 0; i < twoD.length; i++) {
			for (int j = 0; j < twoD[i].length; j++) {
				System.out.printf("%8d ", twoD[i][j]);
			}
			System.out.println();
		}

		// The Arrays class has some useful methods.
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));

		System.out.println(add());
		System.out.println(add(1, 324, 453));
	}

	// Varargs! You can only have one per param. list and it has to come last.
	static int add(int... nums) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		return sum;
	}
}
