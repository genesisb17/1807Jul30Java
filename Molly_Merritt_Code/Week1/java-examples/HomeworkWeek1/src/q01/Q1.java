package q01;

/*
 * Perform a bubble sort on the following integer array:
 * [1,0,5,6,3,2,3,7,9,8,4]
 */

public class Q1 {
	
	public static void main(String[] args) {
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};	// array to be sorted
		int[] arr_sorted = bubbleSort(arr);		// array to store the sorted array
		for (int i=0; i<arr_sorted.length; i++) {	// print the sorted array
			System.out.print(arr_sorted[i]);
		}
	}
	
	static int[] bubbleSort(int[] arr) {
		int swaps;	// keep track of the number of swaps on each pass
		int[] arr_sorted = arr;
		do {
			swaps = 0;
			for (int i=0; i<arr.length-1; i++) {	// compare each i and i+1
				if (arr[i] > arr[i+1]) {	// if arr[i] > arr[i+1], swap them 
					int a = arr[i];		// store the values
					int b = arr[i+1];
					arr_sorted[i] = b;	// swap
					arr_sorted[i+1] = a;
					swaps++;	// increase the swap counter
				}	// else, i++
			}
		} while (swaps > 0);	// continue doing this until you pass through the
								// array without swapping anything
								// (this means it's sorted)
		return arr_sorted;
	}

}
