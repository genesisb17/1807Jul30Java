package com.revature.Q17;

import java.util.Scanner;

public class Q17 {
	
	public static void interestCalculator() {
		Scanner scanner = new Scanner(System.in);
		
		double rat = scanner.nextDouble();
		double princip = scanner.nextDouble();
		double ti = scanner.nextDouble();
		scanner.close();
		double interestPayment = rat * princip * ti;
		
		System.out.println("You will end up paying " + "$" + interestPayment + " in interest.");
	}
	
	
	public static void main(String[] args) {
		interestCalculator();
	}
}
