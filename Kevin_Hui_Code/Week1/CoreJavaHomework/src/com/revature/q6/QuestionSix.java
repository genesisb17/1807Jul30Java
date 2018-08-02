package com.revature.q6;

public class QuestionSix {
	
	/**
	 * Checks whether the input integer passed in is even.
	 * 
	 * The implementation below uses a bitwise operation.
	 * 
	 * If the right-most bit is 1, the integer is odd.
	 * If the right-most bit is 0, the integer is even.
	 * 
	 * @param num The integer to be evaluated.
	 * @return true if num is even; otherwise, false if odd.
	 */
	public static boolean isEven(int num) {
		// "2n - 1" version
		// return (num - (num/2) == (num/2)) ? true : false;
		
		// Bitwise version
		return ((num & 1) == 0) ? true : false; 
	}

	public static void main(String[] args) {
		int [] example = {1,0,5,6,3,2,3,7,9,8,4};
		
		for(int x: example) {
			System.out.println("isEven(" + x + ") outputs " + isEven(x));
		}
	}

}
