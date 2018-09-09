package com.revature.questionone;

import java.util.Arrays;
// 1,0,5,6,3,2,3,7,9,8,4
public class BubbleSort {

	void bubbleSort(int[] arr) {
		
	int temp;
		
	for(int i = 0; i < arr.length - 1; i++) {
		if(arr[i] >= arr[i+1]) {
			temp = arr[i+1];
			arr[i+1] = arr[i];
			arr[i] = temp;
			}
		}
		checkAgain(arr);
	}
	
	void checkAgain(int[] arr) {
		for(int j = 0; j < arr.length - 1; j++) {
			if(arr[j] > arr[j+1]) {
				bubbleSort(arr);
			} 
		}
	}
	
	void printOut(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
}
