package com.revature.exercises;

public class ControlStructures {

	public static void main(String[] args) {
		
		// for loop
		int n = 0;
		for (int i=0; i<10; i++) {
			n = i * i;
			System.out.println(i + " squared is " + n);
		}
		
		// for-each loop
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		for (int var : arr) {
			System.out.println(var + " squared is " + var*var);
		}
		
		// while loop
		int x = 0;
		while (x < 10) {
			System.out.println("x = " + x);
			x++;
		}
		
		// do-while loop
		int m = 0;
		do {
			m++;
		} while (m < 10);
		
		// if-else statement
		double rand = Math.random();
		if (rand > 0.5) {
			System.out.println("rand is greater than 0.5");
		} else {
			System.out.println("rand is less than 0.5");
		}
		
		// if-elseif-else statement
		if (rand > 2/3) {
			System.out.println("rand is greater than 2/3");
		} else if (rand > 1/3){
			System.out.println("rand is between 1/3 and 2/3");
		} else {
			System.out.println("rand is less than 1/3");
		}
		
		// switch statement
		int weekDays = 7;
		String day;
		switch(weekDays) {
			case 1: day = "Sunday";
					break;
			case 2: day = "Monday";
					break;
			case 3: day = "Tuesday";
					break;
			case 4: day = "Wednesday";
					break;
			case 5: day = "Thursday";
					break;
			case 6: day = "Friday";
					break;
			case 7: day = "Saturday";
					break;
		
		}
		
	}

}
