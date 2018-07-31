package com.revature.classbasics;

public class ControlStructures {
	
	public static void main(String[] args) {
		int x = 10;
		int i = 2;
		
		while (i < x) {
			if (i % 2 == 0) {
				System.out.println("He loves me...");
				i += 1;
			}
			else if (i % 5 == 0) {
				System.out.println("What was it again...");
				i += 1;
			}
			else {
				System.out.println("He loves me not...");
				i += 1;
			}
		}
		
		if (x % 2 == 0)
			System.out.println("He definitely loves me!");
		else
			System.out.println("And I'm forever alone...");
		
		int a = 5;
		int b = 3;
		
		for (int j = 1 ; j < a ; j++) {
			System.out.println("I shall never be alone forever and the world will hear me roar!");
			for (int k = 1 ; k < b ; k++) {
				if (b == 1) {
					System.out.println("I wonder if they heard me...?");
				}
				else if (b == 2) {
					System.out.println("I shall roar again!");
				}
				else {
					System.out.println("Where am I!?");
				}
			}
		}
		
		int l = 3;
		do {
			System.out.println("This is number " + x);
			l ++;
		}
		while (l <= 3);
		
		int day = 5;
		String dayTime;
		
		switch (day) {
			case 1: dayTime = "Monday";
			break;
			case 2: dayTime = "Tuesday";
		    break;
			case 3: dayTime = "Wednesday";
		    break;
			case 4: dayTime = "Thursday";
		    break;
			case 5: dayTime = "Friday";
		    break;
			case 6: dayTime = "Saturday";
		    break;
			case 7: dayTime = "Sunday";
		    break;
			default: dayTime = "Invalid day";
		    break;
		}
		System.out.println(dayTime);
	}
}