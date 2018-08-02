package cjh.question4;

public class Driver {
	/*
	 * Write a program to compute N factorial
	 */
	public static void main(String[] args) {
		System.out.println("The factorial of 5 is: " + computeFactorial1(5));
		System.out.println("The factorial of 7 is: " + computeFactorial1(7));
		System.out.println("The factorial of 3 is: " + computeFactorial1(3));
	}
	
	static int computeFactorial1(int n) {
		int factorial = 1;
		int i = 0;
		while(i++ < n) {
			factorial *= i;
		}
		return factorial;
	}

}
