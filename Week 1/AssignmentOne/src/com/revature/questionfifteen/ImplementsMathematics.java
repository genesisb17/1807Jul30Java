package com.revature.questionfifteen;

/*
 * this is a class that implements and interface
 * you have to use and override the methods found in the interface
 */
public class ImplementsMathematics implements Mathematics{

	@Override
	public double addition(double a, double b) {
		return a + b;
	}

	@Override
	public double subtraction(double a, double b) {
		return a - b;
	}

	@Override
	public double mulitplication(double a, double b) {
		return a * b;
	}

	@Override
	public double division(double a, double b) {
		return a / b;
	}
	
}
