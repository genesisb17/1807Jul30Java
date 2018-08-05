package com.revature.Q12;

import java.util.ArrayList;

public class Q12 {
	
	public static void printArray(ArrayList<Integer> evenNumbers) {
		for(int i : evenNumbers) {
			System.out.println(i);
		}
	}
	
	public static void evenNumbers(int n) {
		
		
		ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
		
		
		for(int i = 0; i <= n; i++) {
			if(isEven(i) == true) {
				evenNumbers.add(i);
			}
			
		}
		printArray(evenNumbers);
	}
	public static void main(String[] args) {
		evenNumbers(100);
		
	}
	
	public static Boolean isEven(int n) {
		/* checks if a quotient of n times 2 is equal to n. since n is an int
		 * the decimals get cut off and the int is rounded down and will 
		 * never equal it self again.
		 */
		if((n/2)*2==n) {
			return true;
		} else {
			return false;		
		}
			
		
		
		
	}
	
}
