package cjh.question04;

public class Factorial {
	/*
	 * Write a program to compute N factorial
	 */
	public static void main(String[] args) {
		System.out.println("The factorial of 5 is: " + computeFactorial1(5));
		System.out.println("The factorial of 7 is: " + computeFactorial1(7));
		System.out.println("The factorial of 3 is: " + computeFactorial1(3));
	}
	
	public static int computeFactorial1(int n) throws IllegalArgumentException {
		if(n < 0) throw new IllegalArgumentException("Input argument must be greater than or equal to 0");
		int factorial = 1;
		int i = 0;
		while(i++ < n) {
			factorial *= i;
		}
		return factorial;
	}

}
