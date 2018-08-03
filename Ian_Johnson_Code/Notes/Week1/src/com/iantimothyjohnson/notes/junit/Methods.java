package com.iantimothyjohnson.notes.junit;

import java.util.Arrays;

public class Methods {
	public int[] bubbleSort(int[] nums) {
		int[] arr = Arrays.copyOf(nums, nums.length);

		// This is the simplest implementation of bubble sort, without any of
		// the optimizations mentioned on the Wikipedia page. What bubble sort
		// does is go through the entire array, looking at elements in pairs. If
		// a pair is out of order, we swap its elements and continue. We do this
		// until the entire array is sorted (which we can detect by keeping
		// track of whether we found any out-of-order pairs during the current
		// iteration).
		boolean sorted = false;
		while (!sorted) {
			// Keep track of whether we needed to swap on this iteration.
			boolean didSwap = false;
			// The variable i will always be the index of the first element in
			// each pair.
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					// This pair is out of order; fix it by swapping the
					// elements.
					int tmp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = tmp;
					didSwap = true;
				}
			}
			// If we didn't need to swap, the array is sorted and we're done.
			if (!didSwap) {
				sorted = true;
			}
		}
		return arr;
	}

	public String reverseString(String str) {
		return str;
	}
	
	public int factorial(int n) {
		return 0;
	}
}
