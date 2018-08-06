package com.revature.q02;

public class QuestionTwo {

	/**
	 * Prints out the Fibonacci sequence from 0 to the nth number.
	 * The zeroth term, n = 0, will equal 0.
	 * The first term, n = 1, will equal 1.
	 * 
	 * @param n The nth term of the Fibonacci sequence. 
	 */
	public static void printFibonacci(int n) {
		
		// "Base cases" for n = 0 and n = 1
		if(n >= 0) {
			System.out.print("0 ");
		}
		
		if(n >= 1) {
			System.out.print("1 ");
		}
		
		
		/* Starting from n = 2 and onward, print out the
		 * remainder of sequence, up to the nth term
		 */
		int prev = 0, curr = 1, temp = 0;
		
		for(int i = 2; i <= n; i++) {
			temp = curr;
			curr = curr + prev;
			prev = temp;
			System.out.print(curr + " ");
		}
	}
	
	public static void main(String[] args) {
		printFibonacci(25);
	}

}
