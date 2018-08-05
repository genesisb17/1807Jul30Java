package com.revature.Q6;


public class Q6 {
	
	public static void evenNumber(int n) {
		/* checks if a quotient of n times 2 is equal to n. since n is an int
		 * the decimals get cut off and the int is rounded down and will 
		 * never equal it self again.
		 */
			if((n/2)*2==n) {
			System.out.println("Your number is even");
			} else {
				System.out.println("Your number is odd");	
			}
	}
	
	public static void main(String[] args) {
		Q6.evenNumber(25);
	}
}
