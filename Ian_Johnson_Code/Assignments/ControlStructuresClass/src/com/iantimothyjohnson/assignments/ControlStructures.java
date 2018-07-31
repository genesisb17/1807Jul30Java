package com.iantimothyjohnson.assignments;

import java.util.Scanner;

public class ControlStructures {
	public static void main(String[] args) {
		int[][] stuff = { { 1, 2, 3 }, { 4, 5, 6 } };
		if (!isIn2DArray(stuff, 5)) {
			System.err.println("Failed first test!");
			System.exit(1);
		}
		if (isIn2DArrayEach(stuff, -1)) {
			System.err.println("Failed second test!");
			System.exit(1);
		}
		System.out.println("Passed all tests!");

		System.out.println("Moving to the interactive portion...");
		Scanner input = new Scanner(System.in);
		boolean running = true;
		do {
			System.out.print("Command (q to quit, h for help): ");
			String command = input.nextLine();
			if (command.length() != 1) {
				System.out.println("All valid input commands are one character long.");
				continue;
			}
			switch (command.charAt(0)) {
			case 'h':
				System.out.println("n - Check your name");
				System.out.println("w - Use a while loop to do something");
				break;
			case 'n':
				System.out.print("What is your name? ");
				String name = input.nextLine();
				if (name.equals("Ian")) {
					System.out.println("Hello, me!");
				} else if (name.equals("Nobody")) {
					System.out.println("Don't be so hard on yourself :(");
				} else {
					System.out.println("Hi, " + name + "!");
				}
				break;
			case 'w':
				int i = 0;
				while (i < 100) {
					if (i > 6) {
						break; // Gotcha; the loop doesn't go past 6!
					}
					System.out.println(i);
					i++;
				}
				System.out.println("A for loop could have done this too.");
				break;
			case 'q':
				System.out.println("Goodbye!");
				running = false;
				break;
			default:
				System.out.println("I don't know how to do that :(");
			}
		} while (running);
		
		input.close();
	}

	public static boolean isIn2DArray(int[][] array, int toFind) {
		boolean found = false;

		outer: for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == toFind) {
					found = true;
					break outer;
				}
			}
		}

		return found;
	}

	public static boolean isIn2DArrayEach(int[][] array, int toFind) {
		for (int[] row : array) {
			for (int n : row) {
				if (n == toFind) {
					return true;
				}
			}
		}
		return false;
	}
}
