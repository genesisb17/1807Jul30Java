package q17;

import java.util.Scanner;

/*
 * Write a program that calculates the simple interest on the principal, rate
 * of interest and number of years provided by the user. Enter principal, rate
 * and time through the console using the Scanner class.
 * 
 * Interest = Principal * Rate * Time
 */

public class Q17 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Principal: ");		// input from scanner
		double principal = scan.nextDouble();
		System.out.println("Rate: ");
		double rate = scan.nextDouble();
		System.out.println("Number of years: ");
		double years = scan.nextDouble();
		
		double interest = principal * rate * years;	// calculate
		System.out.println("Simple interest: " + interest);
	}

}
