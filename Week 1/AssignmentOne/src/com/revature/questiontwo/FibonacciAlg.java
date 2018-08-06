package com.revature.questiontwo;

public class FibonacciAlg {
	int[] arr;
	int i = 0;
	
	public int fibonacciAlg(int n) {
		if(n <= 2) {
			return 1;
		} else {	
			return fibonacciAlg(n-1) + fibonacciAlg(n-2);
		}
	}
}
