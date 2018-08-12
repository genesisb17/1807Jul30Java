package com.rev.main;

import java.util.Scanner;

import com.rev.pojos.Checkings;
import com.rev.pojos.Users;
import com.rev.service.CheckingsService;
import com.rev.service.UsersService;

public class App {
	
	// To allowing the storing of input
	static Scanner sc = new Scanner(System.in);

	// For keep track of login attempt fails
	static int counter = 0;
	
	// To hold each response from the user
	static String option;
	
	// Introduction to app. Will only run once.
	public static void main(String[] args) {
		System.out.println("Welcome to the Not Greedy Banking App!");
		System.out.println("----------START----------\n");
		Intro();
	}
	
	// The portal for logging in and creating an account
	static void Intro() {
		System.out.println("Please enter a number for one of the options:\n"
				+ "1. Login\n"
				+ "2. Create an Account\n"
				+ "3. Exit");
		
		// Used in switch
		option = sc.nextLine();
		
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
			case 1:		logIn();
						break;
			case 2:		createAccount();
						break;
			case 3: 	System.exit(0); // Guess you came here for nothing...
						break;
						// Entered a number that wasn't an option.
			default:	System.out.println("Please choose a valid response.");
						Intro();
						break;
		}
	}

	// Method to create an account
	private static void createAccount() {
	 	System.out.println("Please enter a username.");
		String username = sc.nextLine().toLowerCase();
		
		// Checks to see if your username has not already been taken
		Users result = UsersService.isUsernameUnique(username);
		
		// If statement to check if a match was found (null if no match was found)
		if (result == null) {
			System.out.println("Please enter a password");
			String password = sc.nextLine();
			
			// Sends to createBankingAccount() to create the account
			boolean insert = UsersService.createBankingAccount(username, password); // Adds your credentials to the table
			
			// If statement merely takes the return of the method above and state if it succeeded or not
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
	
	// Method to Log In by checking the DB to the supplied creds
	private static void logIn() {
		int userid = 0;
		System.out.println("Please enter your username.");
		String username = sc.nextLine().toLowerCase();
		System.out.println("Please enter your password.");
		String password = sc.nextLine();
		
		// Will store the results of the check to the DB
		Users result = UsersService.logIn(userid, username, password);
		
		// Will start over if null is returned (meaning creds didn't match to anything in the DB
		if (result == null) {
			counter = counter + 1;
			System.out.println(counter + "Failed login attempt(s).");
			// If they fail 3 times, program will kick them out
			if (counter >= 3) {
				System.out.println("You have failed logging in too many times. Goodbye.");
				System.exit(0);
			// Will start over until kicked out	
			}
			System.out.println("Username and/or password is incorrect. Try again.");
			logIn();
		}
		System.out.println("Hello " + result.getUsername() + "! You are now logged in!");
		System.out.println(result);
		fork(result);
	}

	private static void fork(Users user) {
		System.out.println("Would you like to access your checkings or savings account? Or would you like to exit?");
		System.out.println("1. Checkings\n"
				+ "2. Savings\n"
				+ "3. Exit\n");
		
		option = sc.nextLine();
		
		try {
			@SuppressWarnings("unused")
			int checkForNumberInString = Integer.parseInt(option);
		} catch (NumberFormatException e) {
			System.out.println("Sorry, please enter a number.");
			fork(user);
		}
		
		int choice = Integer.parseInt(option);
		
		switch (choice) {
			case 1: checkings(user);
					break;
			case 2: // TODO: SAVINGS METHOD
					break;
			case 3: System.exit(0);
					break;
			default: System.out.println("Please choose a valid response.");
					fork(user);
		}
	}

	private static void checkings(Users user) {
		Checkings account = CheckingsService.doesAccountExist(user);
		if (account == null) {
			System.out.println("You do not have a checkings account.\n"
					+ "Would you like to create one?\n"
					+ "1. Yes\n"
					+ "2. No\n");
			
			String option = sc.nextLine();
			
			try {
				@SuppressWarnings("unused")
				int checkForNumberInString = Integer.parseInt(option);
			} catch (NumberFormatException e) {
				System.out.println("Sorry, please enter a number.");
				Intro();
			}
			
			int choice = Integer.parseInt(option);
			
			switch (choice) {
				case 1: 	//TODO: CREATE CHECKINGS ACCOUNT METHOD
							break;
				case 2: 	System.out.println("Sure.");
							fork(user);
							break;
				default: 	System.out.println("Please choose a valid response.");
							viewCheckings(account);
							break;
			}
		}
		
		System.out.println("Would you like to:\n"
				+ "1. View the amount in your checkings account\n"
				+ "2. Withdraw/Deposit funds into your checkings account\n"
				+ "3. Exit");
		
		option = sc.nextLine();
		
		try {
			@SuppressWarnings("unused")
			int checkForNumberInString = Integer.parseInt(option);
		} catch (NumberFormatException e) {
			System.out.println("Sorry, please enter a number.");
			checkings(user);
		}
		
		int choice = Integer.parseInt(option);
		
		switch (choice) {
			case 1: viewCheckings(account);
					break;
			case 2: //  TODO WITHDRAW/DEPOSIT CHECKINGS
					break;
			case 3: System.exit(0);
					break;
			default: System.out.println("Please choose a valid response.");
					checkings(user);
					break;
		}
	}

	private static void viewCheckings(Checkings account) {
		CheckingsService.total(account);
	}
}
