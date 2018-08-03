package com.iantimothyjohnson.notes;

import java.util.Scanner;
// We can use 'in' without the 'System.' qualification by doing this:
// import static java.lang.System.in;

public class FileIOScanner {
	public static void main(String[] args) {
		// Here's an example of how to use a Scanner on the console:
		System.out.println("Hello! Welcome to my app. Enter your name:");
		Scanner scan = new Scanner(System.in);

		String name = scan.nextLine();
		System.out.println("Hi, " + name + "! Please enter your age:");

		String age = scan.nextLine();
		int a;
		try {
			a = Integer.parseInt(age);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			System.out.println("That's not a valid number; assuming 5.");
			a = 5;
		}
		System.out.println(a);
		
		scan.close();
	}
}
