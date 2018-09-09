/*
 * This program will create a sort bubble for the array
 * 1,0,5,6,3,2,3,7,9,8,4.
 */
package com.revature.questionone;

public class QuestionOne {

	static int temp;
	
	public static void main(String[] args) {
		int[] arr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		BubbleSort q1Answer = new BubbleSort();
		q1Answer.bubbleSort(arr);
		
		q1Answer.printOut(arr);
		
	}
}

