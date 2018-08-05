//Created by Dariius Moomivand @ 05Aug18;
package com.revature.hw;

import java.util.Scanner;

public class Interest {
	static int interest;
	
	public static void calcIntrest(int a, int b, int c) {
		interest = a*b*c;
		System.out.println("The interest rate is: " + interest);
	}

	public static void main(String[] args) {
		String temp;
		int principal;
		int rate;
		int time;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the principle: ");
		temp = sc.nextLine();
		principal = Integer.parseInt(temp);
		
		System.out.println("Enter the rate: ");
		temp = sc.nextLine();
		rate = Integer.parseInt(temp);

		System.out.println("Enter the time:");
		temp = sc.nextLine();
		time = Integer.parseInt(temp);

		Interest.calcIntrest(principal, rate, time);
		
	}

}
