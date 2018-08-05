package com.revature.Q4;


public class Q4 {
	
	public static void factorial(int n) {
		int x = 1;
		for (int i=1; i<=n; i++) {
		 x = x * i;
		
		}
			System.out.println(x);
	
	
}
	public static void main(String[] args) {
		Q4.factorial(6);
	}
}
