package com.revature.hw1.q10;

import java.util.Scanner;

public class Operators {

	public static void main(String[] args) {
		
		// Opens the console for reading
		Scanner reader = new Scanner(System.in);
		
		// For entering the first number then storing it in x
		System.out.println("Enter a number: ");
		int x = reader.nextInt();
		
		// For entering the second number then storing it in y
		System.out.println("Enter another number: ");
		int y = reader.nextInt();
		
		// Closes the resource
		reader.close();
		
		// Ternary operator to assign minValue the smaller of the two
		int minVal = (x < y) ? x : y;
		
		// Prints the outcome
		System.out.println(minVal + " is the smaller number");
	}
}
