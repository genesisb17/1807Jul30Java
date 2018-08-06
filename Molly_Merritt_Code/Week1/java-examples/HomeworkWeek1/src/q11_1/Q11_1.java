package q11_1;

import q11_2.Q11_2;

/*
 * Write a program that would access two float variables from a class that exists
 * in another package. Note, you will need to create two classes to demonstrate
 * the solution.
 */


public class Q11_1 {
	
	public static void main(String[] args) {
		System.out.println("Float 1: " + Q11_2.f1);
		System.out.println("Float 2: " + Q11_2.f2);
	}

}
