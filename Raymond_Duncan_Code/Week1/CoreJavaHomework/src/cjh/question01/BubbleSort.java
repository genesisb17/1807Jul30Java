package cjh.question01;

import java.util.Arrays;

public class BubbleSort {
	/*
	 * Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
	 */
	public static int[] sort1(int[] arr) {
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			//Iterate through the list to make sure each element is in order 
			for(int i = 0; i < arr.length-1; i++) {
				if(arr[i] > arr[i+1]) {
					sorted = false;
					int j = i+1;
					
					//Swap each pair of elements until element i is less than its follower or until the end of the array
					while(j < arr.length && arr[i] > arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						i++;
						j++;
					}
					break;
				}
			}
		}
		return arr;
	}

}
