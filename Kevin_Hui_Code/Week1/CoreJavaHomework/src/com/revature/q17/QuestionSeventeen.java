package com.revature.q17;

import java.util.Scanner;

public class QuestionSeventeen {
	
	// Calculate Interest (I = PRT)
	public static double calculateInterest(double prin, double rate, int time) {
		return prin * rate * time;
	}
	
	/* 
	 * Using the scanner to receive input from the console and prints out the result\
	 * of the interest calculation
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the principle:");
		double p = sc.nextDouble();
		
		System.out.println("Enter the rate (in decimal form):");
		double r = sc.nextDouble();
		
		System.out.println("Enter the time:");
		int t = sc.nextInt();
		
		System.out.println("The interest is " + calculateInterest(p, r, t) + ".");
		
		sc.close();
	}
}
