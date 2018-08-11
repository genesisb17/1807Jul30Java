package com.rev.main;

import java.util.Scanner;

import com.rev.pojos.Users;
import com.rev.service.UsersService;

public class App {
	
	// To store input
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Not Greedy Banking App!");
		Intro();
	}
	
	static void Intro() {
		System.out.println("----------START----------\n"
				+ "Please enter a number for one of the options:\n"
				+ "1. Login\n"
				+ "2. Create an Account\n"
				+ "3. Exit");
		
		// Used in switch
		String option = sc.nextLine();
		
		// Test for not-numbers
		try {
			@SuppressWarnings("unused")
			int checkForNumberInString = Integer.parseInt(option);
		} catch (NumberFormatException e) {
			System.out.println("Sorry, please enter a number.");
			Intro();
		}
		
		// Parses it into integer primitive
		int choice = Integer.parseInt(option);
		
		// To determine whether to exit, make an account, or login
		switch (choice) {
			case 1:		System.exit(0); // Guess you came here for nothing...
						break;
			case 2:		createAccount();
						break;
			case 3: 	// Log In Module
						break;
						// Entered a number that wasn't an option.
			default:	System.out.println("Please choose a valid response.");
						Intro();
						break;
		}
	}

	private static void createAccount() {
	 	System.out.println("Please enter a username.");
		String username = sc.nextLine();
		Users result = UsersService.isUsernameUnique(username); // Checks to see if your username has not already been taken
		if (result == null) {
			System.out.println("Please enter a password");
			String password = sc.nextLine();
			boolean insert = UsersService.createBankingAccount(username, password); // Adds your credentials to the table
			if (insert == true) {
				System.out.println("You have now created an account! You can now log in now.");
				Intro();
			}
		
			else {
			System.out.println("Your account was not created. Please start over.");
			Intro();
			}
		}
		else {
			System.out.println("That username is taken. Start over.");
			createAccount();
		}	
	}
}
