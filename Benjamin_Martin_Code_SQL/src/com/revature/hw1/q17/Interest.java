package com.revature.hw1.q17;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Interest {

	public static void main(String[] args) {
		
		//Scanner to take the principle, interest, and years
		// All are double because you can't add ints to doubles ;(
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the principle");
		double principle = sc.nextDouble();
		System.out.println("Enter the rate as a whole number");
		double rate = sc.nextDouble();
		double smallRate = rate / 100;
		System.out.println("Enter the years");
		double years = sc.nextDouble();
		// Closes the scanner
		sc.close();
		
		// Computes total interest
		double interest = principle * smallRate * years;	
		
		// Forces the output to show up to two decimal places
		DecimalFormat df = new DecimalFormat("#.00");
		
		// Prints out the total interest
		System.out.println("The total interest is: $" + (df.format(interest)));
		
	}
}