package com.revature.questionfour;

public class Factorial {

	static int factorialRec(int n) {
		if(n == 0) {
			return 1;
		}
		else {
			return (n*factorialRec(n-1));
		}
	}
}
