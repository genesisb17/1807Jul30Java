package cjh.question14;

import java.sql.Date;
import java.util.Calendar;

public class DemonstratesSwitch {
	/*
	 * Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
	 * Case 1: Find the square root of a number using the Math class method.
	 * Case 2: Display today’s date.
	 * Case 3: Split the following string and store it in a sting array.
	 * 		“I am learning Core Java”
	 * 
	 */

	public static boolean switcheroo(int option) {
		switch(option) {
		case 1:
			findSqrt(100);
			return true;
		case 2:
			displayDate();
			return true;
		case 3:
			splitString("I am learning Core Java");
			return true;
		default:
			return false;
		}
	}
	
	static void findSqrt(int n) {
		System.out.println(Math.sqrt(n));
	}
	
	static void displayDate() {
		System.out.println(Calendar.getInstance().getTime());
	}
	
	static void splitString(String str) {
		System.out.println(str.split(" ").toString());
	}
}
