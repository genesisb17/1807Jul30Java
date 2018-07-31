package com.revature.exercises;

// import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		/* 
		 * Takes in a number n
		 * Prints out the numbers 1 through n
		 * Instead of any multiple of 3, prints "Fizz"
		 * Instead of any multiple of 5, prints "Buzz"
		 * Instead of any multiple of 3 and 5, prints "FizzBuzz"
		 */
		
		// If we want the user to type something instead of using args, do this:
		// 
		// Scanner scan = new Scanner(System.in);
		// int n = scan.nextInt();
		
		// each primitive has a wrapper class
		// to convert between primitive and wrapper class is called boxing
		
		String num = args[0];
		int n = Integer.parseInt(num);
		
		for (int i = 1; i <= n; i++) {
			if (i % (3*5) == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				String iStr = Integer.toString(i);
				System.out.println(iStr);
			}
		}

	}

}
