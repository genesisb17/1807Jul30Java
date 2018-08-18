package com.rev.main;

import java.util.Scanner;

import com.rev.pojos.Users;
import com.rev.service.CheckingsService;
import com.rev.service.SavingsService;
import com.rev.service.UsersService;

public class App {
	
	// To allowing the storing of input
	static Scanner sc = new Scanner(System.in);
	
	// To hold each response from the user
	static String option;
	
	// Introduction to app. Will only run once.
	public static void main(String[] args) throws CustomException {
		System.out.println("Welcome to the Not Greedy Banking App!");
		System.out.println("---------------START-----------------\n");
		intro();
	}
	
	// The portal for logging in and creating an account
	static void intro() throws CustomException {
		System.out.println("Please enter a number for one of the options:\n"
				+ "1. Login\n"
				+ "2. Create an Account\n"
				+ "3. Exit");
		
		// Used in switch
		option = sc.nextLine();
		
		// Testing for not-numbers
		try {
			@SuppressWarnings("unused")
			int checkForNumberInString = Integer.parseInt(option);
		} catch (NumberFormatException e) {
			System.out.println("Sorry, please enter a number.");
			intro();
		}
		
		// Parses it into integer primitive
		int choice = Integer.parseInt(option);
		
		// To determine whether to login, create an account, or exit
		switch (choice) {
			case 1:		logIn();
						break;
			case 2:		createBankingAccount();
						break;
			case 3: 	System.exit(0); // Guess you came here for nothing...
						break;
						// Entered a number that wasn't an option.
			default:	System.out.println("Please choose a valid response.");
						intro();
						break;
		}
	}

	private static void createBankingAccount() throws CustomException {
	 	System.out.println("Please enter a username.");
		String username = sc.nextLine().toLowerCase();
		
		// Checks to see if your username has not already been taken
		boolean status = UsersService.isUsernameUnique(username);
		
		// If statement to check if a match was found (null if no match was found)
		if (status == true) {
			System.out.println("Please enter a password");
			String password = sc.nextLine();
			
			// Sends to createBankingAccount() to create the account
			UsersService.createBankingAccount(username, password); // Adds your credentials to the table
			
		}
		else if (status == false) {
			createBankingAccount();
		}
		
		intro();
	}
	
	private static void logIn() throws CustomException {
		// Needed for when object is sent to be initialized
		int userid = 0;
		
		System.out.println("Please enter your username.");
		// .toLowerCase since usernames are not normally case-sensitive
		String username = sc.nextLine().toLowerCase();
		
		if (username.equals(null) || username.equals("")) {
			throw new CustomException("You can't have empty string as a username! For angering me, I kick you out!");
		}
		
		System.out.println("Please enter your password.");
		String password = sc.nextLine();
		
		// Will store the results of the check to thes DB
		Users user = UsersService.logIn(userid, username, password);
		
		// Will start over if null is returned (meaning creds didn't match to anything in the DB)
		if (user == null) {
			logIn();
		}
		
		// Send user to fork
		fork(user);
	}

	private static void fork(Users user) throws CustomException {
		System.out.println("Select one of the following options:");
		System.out.println("1. Checkings\n"
				+ "2. Savings\n"
				+ "3. Log Out\n"
				+ "9. Nuke account(s)");
		
		option = sc.nextLine();
		
		// Catch non-numbers
		try {
			@SuppressWarnings("unused")
			int checkForNumberInString = Integer.parseInt(option);
		} catch (NumberFormatException e) {
			System.out.println("Sorry, please enter a number.");
			fork(user);
		}
		
		// Parse to int
		int choice = Integer.parseInt(option);
		
		// Determine whether to go checkings or savings
		switch (choice) {
			case 1: checkingsAccountExist(user);
					break;
			case 2: savingsAccountExist(user);
					break;
					// If they wanna get out of here
			case 3: System.out.println("You are now logged out.");
					intro();
					break;	
					// GOODBYE ACCOUNTS
			case 9: System.out.println("Are you sure you wish to delete ALL accounts?\n"
					+ "This includes your savings, checkings, and main account.\n"
					+ "To delete your account(s), please enter your name.");
					String name = sc.nextLine();
					UsersService.nuke(user, name);
					intro();
					break;
					
					// If they entered an illegal argument
			default: System.out.println("Please choose a valid response.");
					fork(user);
		}
	}

	private static void checkingsAccountExist(Users user) throws CustomException {
		boolean status = CheckingsService.doesAccountExist(user); // Will always check if they have an checkings account
		// User will be prompted to do this until they create an account
		if (status == false) {
			
			String option = sc.nextLine();
			
			try {
				@SuppressWarnings("unused")
				int checkForNumberInString = Integer.parseInt(option);
			} catch (NumberFormatException e) {
				System.out.println("Sorry, please enter a number.");
				fork(user);
			}
			
			int create = Integer.parseInt(option);
			
			// Determine whether to create the account or send them back
			switch (create) {
				case 1: 	createCheckings(user);
							break;
				case 2: 	System.out.println("Sure.\n");
							fork(user);
							break;
				default: 	System.out.println("Invalid Response.\n");
							checkingsAccountExist(user);
							break;
			}
		}
		checkings(user);	
	}
	
	private static void savingsAccountExist(Users user) throws CustomException {
		boolean savingsExist = SavingsService.doesAccountExist(user);
		
		if (savingsExist == false) {
			
			String option = sc.nextLine();
			
			try {
				@SuppressWarnings("unused")
				int checkForNumberInString = Integer.parseInt(option);
			} catch (NumberFormatException e) {
				System.out.println("Sorry, please enter a number.");
				fork(user);
			}
			
			int create = Integer.parseInt(option);
			
			switch (create) {
				case 1: 	createSavings(user);
							break;
				case 2: 	System.out.println("Sure.");
							fork(user);
							break;
				default: 	System.out.println("Invalid Response.\n");
							savingsAccountExist(user);
							break;
			}
		}
		savings(user);
	}
	
	private static void createCheckings(Users user) throws CustomException {
		System.out.println("How much would you like to put into your new account?");
		String input = sc.nextLine();
		
		try {
			@SuppressWarnings("unused")
			double checkForDoubleInString = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			System.out.println("Sorry, please enter a proper number.\n");
			createCheckings(user);
		}
		
		double amount = Double.parseDouble(input);
		
		// User isn't allowed to put in a negative number or 0
		if (amount <= 0) {
			System.out.println("You cannot enter a negative number or 0. Please try again.\n");
			createCheckings(user);
		}
		
		// Stores results so that it can either send the user to their checkings interface or punt them back to the fork
		boolean complete = CheckingsService.create(user, amount);
		
		if (complete == true) {
			checkings(user);
		}
		else {
			fork(user);
		}
	}
	
	private static void createSavings(Users user) throws CustomException {
		// Same as createCheckings
		System.out.println("How much would you like to put into your new account?");
		String input = sc.nextLine();
		
		try {
			@SuppressWarnings("unused")
			double checkForDoubleInString = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			System.out.println("Sorry, please enter a proper number.\n");
			createSavings(user);
		}
		
		double amount = Double.parseDouble(input);
		
		if (amount <= 0) {
			System.out.println("You cannot enter a negative number or 0. Please try again.\n");
			createSavings(user);
		}
		
		boolean complete = SavingsService.create(user, amount);
		
		if (complete == true) {
			savings(user);
		}
		else {
			fork(user);
		}
	}

	private static void checkings(Users user) throws CustomException {
		System.out.println("What would you like to do with your checkings account?\n"
			+ "1. View the amount in your checkings account\n"
			+ "2. Withdraw funds from your checkings account\n"
			+ "3. Deposit funds into your checkings account\n"
			+ "4. Go back\n"
			+ "5. Exit");
		
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
			case 1: viewCheckings(user);
					break;
			case 2: withdrawCheckings(user);
					break;
			case 3: depositCheckings(user);
					break;
			case 4: fork(user);
					break;
			case 5: System.out.println("Thank you for using the Not Greedy App.");
					System.exit(0);
					break;
			default: System.out.println("Please choose a valid response.");
					checkings(user);
					break;
		}
	}

	private static void savings(Users user) throws CustomException {
		System.out.println("What would you like to do with your savings account?\n"
			+ "1. View the amount in your savings account\n"
			+ "2. Withdraw funds from your savings account\n"
			+ "3. Deposit funds into your savings account\n"
			+ "4. Go back\n"
			+ "5. Exit");
			
			option = sc.nextLine();
			
			try {
				@SuppressWarnings("unused")
				int checkForNumberInString = Integer.parseInt(option);
			} catch (NumberFormatException e) {
				System.out.println("Sorry, please enter a number.");
				savings(user);
			}
			
			int choice = Integer.parseInt(option);
			
			switch (choice) {
				case 1: viewSavings(user);
						break;
				case 2: withdrawSavings(user);
						break;
				case 3: depositSavings(user);
						break;
				case 4: fork(user);
						break;
				case 5: System.out.println("Thank you for using the Not Greedy App.");
						System.exit(0);
						break;
				default: System.out.println("Please choose a valid response.");
						savings(user);
						break;
			}
	}
	
	private static void depositSavings(Users user) throws CustomException {
		System.out.println("How much would you like to deposit?");
		String input = sc.nextLine();
		
		try {
			@SuppressWarnings("unused")
			double checkForDoubleInString = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			System.out.println("Sorry, please enter a proper number.\n");
			depositSavings(user);
		}
		
		double amount = Double.parseDouble(input);
		
		// Stops them from depositing $0.00
		if (amount <= 0) {
			System.out.println("You cannot enter a negative number or 0. Please try again.\n");
			depositSavings(user);
		}
		
		boolean complete = SavingsService.deposit(user, amount);
		if (complete == false) {
			depositSavings(user);
		}
		savings(user);
	}

	private static void withdrawSavings(Users user) throws CustomException {
		System.out.println("How much would you like to withdraw?");
		
		String input = sc.nextLine();
		
		try {
			@SuppressWarnings("unused")
			double checkForDoubleInString = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			System.out.println("Sorry, please enter a proper number.\n");
			withdrawSavings(user);
		}
		
		double amount = Double.parseDouble(input);
		
		// You can't withdraw a negative or 0 amount
		if (amount <= 0) {
			System.out.println("You cannot enter a negative number or 0. Please try again.\n");
			withdrawSavings(user);
		}
		
		boolean complete = SavingsService.withdraw(user, amount);
		if (complete == false) {
			withdrawSavings(user);
		}
		savings(user);
	}

	private static void viewSavings(Users user) throws CustomException {
		// Simply grabs the total and displays it
		SavingsService.total(user);
		savings(user);		
	}

	private static void withdrawCheckings(Users user) throws CustomException {
		System.out.println("How much would you like to withdraw?");
		
		String input = sc.nextLine();
		
		try {
			@SuppressWarnings("unused")
			double checkForDoubleInString = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			System.out.println("Sorry, please enter a proper number.\n");
			withdrawCheckings(user);
		}
		
		double amount = Double.parseDouble(input);
		
		if (amount < 0) {
			System.out.println("You cannot enter a negative number. Please try again.\n");
			withdrawCheckings(user);
		}
		
		boolean complete = CheckingsService.withdraw(user, amount);
		if (complete == false) {
			withdrawCheckings(user);
		}
		checkings(user);
	}

	private static void depositCheckings(Users user) throws CustomException {
		System.out.println("How much would you like to deposit?");
		String input = sc.nextLine();
		
		try {
			@SuppressWarnings("unused")
			double checkForDoubleInString = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			System.out.println("Sorry, please enter a proper number.\n");
			depositCheckings(user);
		}
		
		double amount = Double.parseDouble(input);
		
		if (amount < 0) {
			System.out.println("You cannot enter a negative number. Please try again.\n");
			depositCheckings(user);
		}
		
		boolean complete = CheckingsService.deposit(user, amount);
		if (complete == false) {
			depositCheckings(user);
		}
		checkings(user);
	
	}

	private static void viewCheckings(Users user) throws CustomException {
		// Same as viewSavings
		CheckingsService.total(user);
		checkings(user);
	}
}

class CustomException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CustomException(String message) {
		super(message);
	}
}
