//Created by Darius Moomivand @ 05Aug18
package com.revature.hw;

import java.util.Scanner;

//Switch 
public class Switch {
	static int square = 9;
	static java.util.Date today = new java.util.Date();
	static String string = "I am learning Core Java";
	String [] stringArr;
	
	public static void switchFunc(int n) {
		switch(n) {
			case 1: System.out.println((int)Math.sqrt(square));
					break;
			case 2: System.out.println(today);
					break;
			case 3: String [] stringArray = string.split(" ", 4);
					for(String s : stringArray)
						System.out.println(s);
					break;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = "X";
		
		System.out.println("Make a selection: \n");
		System.out.println("Input '1' to find the square root of a number");
		System.out.println("Input '2' to print the date");
		System.out.println("Input '3' to split a string\n");
		
		int select = sc.nextInt();
		x = sc.nextLine();

		if(select == 1) {
			System.out.println("\nEnter a number.");
			Switch.square = sc.nextInt();
		}
		Switch.switchFunc(select);

	}

}
