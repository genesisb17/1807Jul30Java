package com.revature.q14;

import java.util.Date;

public class QuestionFourteen {

	/**
	 * Showcasing the switch statement
	 * 
	 * Case 1: Find the square root of a number using the Math class method.
	 * 
	 * Case 2: Display today’s date.
	 * 
	 * Case 3: Split the following string and store it in a sting array. “I am
	 * learning Core Java”
	 * 
	 * @param n An integer to specify the case to execute
	 */
	public static void printRandomStuff(int n) {
		switch (n) {
		case 1:
			int r = (int) (Math.random() * 100);
			double sqRoot = Math.sqrt(r);
			System.out.println("The random number is: " + r + ". The square root of that number is " + sqRoot + ".");
			break;
		case 2:
			Date d = new Date();
			System.out.println("Current date: " + d.getTime());
			break;
		case 3:
			String sample = new String("I am learning Core Java");

			String[] splitString = sample.split(" ");

			for (String s : splitString) {
				System.out.println(s);
			}

			break;
		default:
			System.out.println("\nWhat?\n");
		}
	}

	public static void main(String[] args) {
		printRandomStuff(1);
		printRandomStuff(2);
		printRandomStuff(3);
		printRandomStuff(1111);
	}

}
