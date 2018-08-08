package com.revature.hw1.q14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Case {

	public static void main(String[] args) {
		
		// Scanners that assign each input to a variable
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number 1 for math, 2 for date, 3 for string");
        String str = sc.next();
        // Passes the input to the switches class
        switches(str);
        System.out.println("This is the reponse you get for entering " + str);
		// Closes the scanner resource     
		sc.close();
		
	}
	
	public static String switches(String str) {
		
		// Houses the argument passed
		String answer = str;
		
		switch (answer) {
			case "1": // Will ask for a number and will print the square root of it
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter a number");
				int num = sc.nextInt();
				System.out.println("The square root of " + num + " is: " + Math.sqrt(num));
				sc.close();
				break;
			case "2": // Will print the current date
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.now();
				System.out.println(dtf.format(localDate));
				break;
			case "3": // Will store each part of the string into an ArrayList then print it.
				ArrayList<String> sting = new ArrayList<>();
				String string = "I am learning Core Java";
				// \\s+ is needed to signify that the "space" between words is how you will split them
				String[] parts = string.split("\\s+");
				// Loosp to add each part to the Arraylist
				for (int i = 0 ; i < parts.length ; i++) {
					sting.add(parts[i]);
				}
				System.out.println(sting);
				break;
		}
		
		// Here because it yells at me if I don't have this
		return answer;
		
	}
}


