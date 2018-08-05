package com.revature.Q9;

import java.util.ArrayList;

public class Q9 {
	
	public static void printArray(ArrayList<Integer> primeNumbers) {
		for(int i : primeNumbers) {
			System.out.println(i);
		}
	}
	
	public static void primeNumbers(int n) {
		
		
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		
		// Generates my numbers to be checked if prime or not, if they are add them to new array
		
		for(int i = 1; i <= n; i++) {
			if(isPrime(i)) {
				primeNumbers.add(i);
			}
			
		}
		printArray(primeNumbers);
	}
	public static void main(String[] args) {
		primeNumbers(100);
		
	}
	
	public static Boolean isPrime(int input) {
		if(input == 4) return false;
		for(int i = 3; i<input; i++) {
				if(input%i==0)
				{
					
					return false;
				}
		}
	
			 return true;
	
	}
	
}
