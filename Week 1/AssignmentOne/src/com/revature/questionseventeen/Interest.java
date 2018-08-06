package com.revature.questionseventeen;

import java.util.Scanner;

public class Interest {
	
	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your principal amount: ");
		int principal = s.nextInt();
		System.out.println("Now enter your interest rate: ");
		double rate = s.nextDouble();
		System.out.println("Now enter how long you plan to maintain this: ");
		int time = s.nextInt();
		
		double interest = principal * (rate/100) * time;
		
		System.out.println("Your interest added up during " + time +
				" years is: " + interest);
		
		s.close();
	}
	
	
}
