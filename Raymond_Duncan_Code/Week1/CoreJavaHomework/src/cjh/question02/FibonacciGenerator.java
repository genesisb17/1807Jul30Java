package cjh.question02;

import java.util.Arrays;

public class FibonacciGenerator {
	/*
	 * Write a program to display the first 25 Fibonacci numbers beginning at 0
	 */
	public static void main(String[] args) {
		int[] signature1 = {0, 1};
		int numElements = 25;
		int[] sequence1 = fibonacci(signature1, numElements);
		System.out.println("Fibonacci25 with [0, 1] as the signature:\n " + Arrays.toString(sequence1));
		
		int[] signature2 = {1, 1};
		int[] sequence2 = fibonacci(signature2, numElements);
		System.out.println("Fibonacci25 with [1, 1] as the signature:\n " + Arrays.toString(sequence2));
	}
	
	public static int[] fibonacci(int[] s, int n) {
		//TODO: Check whether the signature is only 2 elements long
		//TODO: Check whether n is a positive number
		int[] seq = new int[n];
		seq[0] = s[0];
		seq[1] = s[1];
		for(int i = 2; i < n; i++) {
			seq[i] = seq[i-1] + seq[i-2];
		}
		return seq;
	}
}
