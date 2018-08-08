package com.revature.hw1.q1;

public class BubbleSort {
	
	// Method to sort the array in the main method 
	void bubbleSort (int array[]) {
		int n = array.length;
		for (int i = 0 ; i < n ; i++ )
			for (int j = 0 ; j < n - i - 1 ; j++)
				if (array[j] > array[j+1]) {
					
					// Will start swapping values
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
	}
	
	// Will print the array when called
	void printArray(int array[]) {
		int n = array.length;
		for (int i = 0 ; i < n ; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	
	// Will take the object and sent it to the methods to sort then print
	public static void main(String args[]) {
		BubbleSort ob = new BubbleSort();
		int array[] = {1,0,5,6,3,2,3,7,9,8,4};
		ob.bubbleSort(array);
		System.out.println("Sorted array");
		ob.printArray(array);
	}
}
