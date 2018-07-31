package com.iantimothyjohnson.assignments;

public class FizzBuzz {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: FizzBuzz n");
			System.exit(1);
		}
		int n = 0;
		try {
			n = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.err.println("Bad number: " + e.toString());
			System.exit(1);
		}
		if (n < 1) {
			System.err.println("Your number needs to be at least 1");
			System.exit(1);
		}

		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else {
				System.out.println(i);
			}
		}
	}
}
