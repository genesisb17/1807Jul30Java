package com.revature.Q15;

public class Q15 implements MathFunctions{

	@Override
	public void addition(int n, int x) {
		int y = n + x;
		System.out.println(y);
		
	}

	@Override
	public void subtraction(int n, int x) {
		int y = n - x;
		System.out.println(y);
		
	}

	@Override
	public void multiplication(int n, int x) {
		int y = n * x;
		System.out.println(y);
		
	}

	@Override
	public void division(int n, int x) {
		int y = n/x;
		System.out.println(y);
		
	}
	
	

}
