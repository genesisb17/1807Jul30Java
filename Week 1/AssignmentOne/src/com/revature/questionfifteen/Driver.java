package com.revature.questionfifteen;

public class Driver extends ImplementsMathematics{

	public static void main(String[] args) {
		double a = 2.2;
		double b = 4.4;
		ImplementsMathematics calc = new ImplementsMathematics();
		
		System.out.println("The sum of a + b is: " + calc.addition(a, b));
		System.out.println("The difference of a - b is: " + calc.subtraction(a, b));
		System.out.println("The quotient of a / b is: " + calc.division(a,b));
		System.out.println("The product of a * b is: " + calc.mulitplication(a, b));
	}
}
