package cjh.question17;

import java.util.Scanner;

public class InterestCalculator {
	/*
	 * Write a program that calculates the simple interest on the principal, rate of interest, and number of years provided by the user. Enter principal, 
	 * rate and time through the console using the Scanner class.
	 * 		Interest = Principal* Rate* Time
	 */
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to the simple interest calculator");
		System.out.println("Please enter the principal amount");
		Double principal = null;
		do{
			try {
				principal = Double.parseDouble(s.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid starting amount (e.g. 0.00 - 999999.99");
			}
		} while(principal == null);
		
		Double interestRate = null;
		System.out.println("Please enter the interest rate");
		do{
			try {
				interestRate = Double.parseDouble(s.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid interest rate (e.g. 0.0 - 1.0");
			}
		} while(interestRate == null);
		
		System.out.println("How many years will the money gain interest?");
		Double numberOfYears = null;
		do{
			try {
				numberOfYears = Double.parseDouble(s.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid starting amount (e.g. 0.00 - 999999.99");
			}
		} while(numberOfYears == null);
		
		System.out.println("Thanks!\n Your simple interest accrued after " + numberOfYears + " years will be: $" + principal*interestRate*numberOfYears);
	}

}
