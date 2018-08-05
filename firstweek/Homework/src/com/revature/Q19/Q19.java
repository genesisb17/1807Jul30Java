package com.revature.Q19;

import java.util.ArrayList;

public class Q19 {
	public static void printArray(ArrayList<Integer> array) {
		for (int i : array) {
			System.out.println(i);
		}
	}
	public static void printWithoutPrime(ArrayList<Integer> array) {
		for (Integer i : array) {
			if (isPrime(i)) {
				array.remove((Integer)i);
				
			}
			
		}
		printArray(array);
	}
	public static Boolean isPrime(int input) {
		if (input == 4)
			return false;
		for (int i = 3; i < input; i++) {
			if (input % i == 0) {

				return false;
			}
		}
		return true;
	}
	public static Boolean evenNumber(int n) {
		if ((n / 2) * 2 == n) {
			return true;
		} else {
			return false;
		}
	}

	public static void createArray(int n) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int x = 0;
		int y = 0;
		for (int i = 1; i <= n; i++) {

			numbers.add(i);
			if (evenNumber(i) == false) {
				y = y + i;
			}
			if (evenNumber(i)) {
				x = x + i;
			}
		}
		printArray(numbers);
		
		System.out.println("The sum of all even numbers are: " + x);
		System.out.println("The sum of all odd numbers are: " + y);
		printWithoutPrime(numbers);
	}
	public static void main(String[] args) {
		createArray(10);
		
		
	}
}
