package com.revature.q13;

public class QuestionThirteen {
	
	/**
	 * Prints a triangle that alternates between 0s and 1s.
	 * 
	 * @param rows Number of rows to print out
	 */
	public static void printTriangle(int rows) {
		int modOperand = rows * rows;
		
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k <= i; k++) {
				System.out.print((modOperand-- % 2) + " ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		printTriangle(4);
	}

}
