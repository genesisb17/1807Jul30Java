package com.revature.questionfourteen;

import java.util.Calendar;
import java.util.Date;

public class SwitchCase {
	
	public static void main(String[] args) {
		String str = "I am learning Core Java";
		int n = 3;
		
		switch(n) {
		case 1:
			System.out.println("Square root of n is: " + findSqRt(n));
			break;
		case 2:
			getTodaysDate();
			break;
		case 3:
			storeString(str);
		}
	}
	
	static void storeString(String str) {
		String[] arrOfStr = str.split(" ", 0);
		for(String s : arrOfStr) {
			System.out.println(s);
		}
	}
	
	static void getTodaysDate() {
		
		Date today = Calendar.getInstance().getTime();
		System.out.println(today);
	}
	
	static double findSqRt(double n) {
		double sqrt = Math.sqrt(n);
		return sqrt;
	}
	
	
}
