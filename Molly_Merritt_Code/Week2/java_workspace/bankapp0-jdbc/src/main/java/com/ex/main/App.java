package com.ex.main;

import java.util.List;
import java.util.Scanner;

import com.ex.pojos.Accounts;
import com.ex.pojos.Users;
import com.ex.service.AccountService;
import com.ex.service.TransactionService;
import com.ex.service.UserService;

public class App {
	
	static Scanner scanner = new Scanner(System.in);
	static UserService uService = new UserService();
	static AccountService aService = new AccountService();
	static TransactionService tService = new TransactionService();

	public static void main(String[] args) {
		welcomeMenu();
		
//		String firstName = "Mickey";
//		String lastName = "Mouse";
//		String username = "mickeymouse";
//		String password = "disney";
//		Users u = new Users(firstName, lastName, username, password);
//		u = uService.addUser(u);
//		
//		List<Users> users = uService.getAllUsers();
////		System.out.println(users.size());
//		for (Users user : users) {
//			System.out.println(user.getUserID());
//			System.out.println(user.getFirstName());
//			System.out.println(user.getLastName());
//			System.out.println(user.getUsername());
//			System.out.println(user.getPassword());
//		}
	}
	
	static void welcomeMenu() {
		System.out.println("Welcome to your bank!\n");
		loginMenu();
	}
	
	static void loginMenu() {
		// LOGIN OR SIGN UP
		System.out.println("---------Login Menu--------\n"
				+ "1. Log in\n"
				+ "2. Sign up");
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("\nPlease enter a number\n");
			loginMenu();
		}
		Users u = new Users();
		switch(option) {
		case 1:	// Log in
			u = logIn();
			menu(u);
			break;
		case 2: // Sign up
			u = signUp();
			menu(u);
			break;
		default:
			System.out.println("\nPlease enter one of the following numbers: 1, 2\n");
			loginMenu();
			break;
		}
				
	}
	
	
	static void menu(Users u) {		
		// MAIN MENU
		System.out.println("\n---------Main Menu--------\n"
				+ "1. View My User\n"
				+ "2. View All Users\n"
				+ "3. View Account\n"
				+ "4. View Transactions\n"
				+ "5. Add User\n"
				+ "6. Add Account\n"
				+ "7. Add Transaction\n"
				+ "8. Update User\n"
				+ "9. Update Account\n"
				+ "10. Update Transaction\n"
				+ "11. Logout\n");
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Please enter a number between 1 and 11");
			menu(u);
		}
		
		switch(option) {
		case 1:	// View my user
			viewUser(u);
			break;
		case 2: // View all users
			viewAllUsers();
			break;
		case 3:	// View accounts
		case 4:	// View transactions
		case 5:	// Add user
			addUser();
			break;
		case 6:	// Add account
			addAccount(u);
			System.out.println("\nAccount created successfully\n");
			break;
		case 7:	// Add transaction
		case 8: // Update user
			updateUser(u);
			System.out.println("\nInformation updated successfully\n");
			break;
		case 9: // Update account
		case 10: // Update transaction
		case 11: // Logout
			logOut();
			break;
		}
		menu(u);
	}
	
	static Users logIn() {
		System.out.println("Enter your username: ");
		String username = scanner.nextLine();
		System.out.println("Enter your password: ");
		String password = scanner.nextLine();
		Users u = uService.getUser(username, password);
		return viewUser(u);
	}
	
	static Users signUp() {
		return addUser();
	}
	
	static void logOut() {
		System.out.println("\nSuccessfully logged out\n");
		welcomeMenu();
	}
	
	// CASE 1 - view user information
	static Users viewUser(Users u) {
		System.out.println("\nUser information");
		System.out.println("First name: " + u.getFirstName());
		System.out.println("Last name: " + u.getLastName());
		System.out.println("Username: " + u.getUsername());
		return u;
	}
	
	// CASE 2 - view all users
	static List<Users> viewAllUsers() {
		System.out.println("\nAll users\n");
		List<Users> users = uService.getAllUsers();
		for (Users user : users) {
			System.out.print("\nName: " + user.getFirstName());
			System.out.print(" " + user.getLastName() + "\n");
			System.out.println("Username: " + user.getUsername());
		}
		return users;
	}
	
	// CASE 3 - view accounts
	
	
	// CASE 4 - view transactions
	
	
	// CASE 5 - add user
	static Users addUser() {
		/*
		 * SHOULD DO SOME INPUT VALIDATION
		 */
		System.out.println("Enter first name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter last name: ");
		String lastName = scanner.nextLine();
		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		System.out.println("Enter password: ");
		String password = scanner.nextLine();
		
		Users u = new Users(firstName, lastName, username, password);
		
		// call user service addUser() which calls dao addUser()
		return u = uService.addUser(u);
	}
	
	// CASE 6 - add account
	static Accounts addAccount(Users u) {
		System.out.println("Enter account number: ");
		int accountNumber = Integer.parseInt(scanner.nextLine());
		int userID = u.getUserID();
		System.out.println("Enter account type: \n"
				+ "1. Savings\n"
				+ "2. Checking");
		int accountType = Integer.parseInt(scanner.nextLine());
		double balance = 0;
		Accounts a = new Accounts();
		a.setAccountNumber(accountNumber);
		a.setUserID(userID);
		a.setAccountType(accountType);
		a.setBalance(balance);
		return aService.addAccount(a);
	}
	
	// CASE 7 - add transaction
	
	
	// CASE 8 - update user
	static Users updateUser(Users u) {
		System.out.println("What information would you like to update?\n"
				+ "1. First name\n"
				+ "2. Last name\n"
				+ "3. Username\n"
				+ "4. Password\n");
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter a number between 1 and 4");
			updateUser(u);
		}
		switch(option) {
		case 1: // update first name
			System.out.println("Enter your new first name:");
			String firstname = scanner.nextLine();
			u.setFirstName(firstname);
		case 2: // update last name
			System.out.println("Enter your new last name:");
			String lastname = scanner.nextLine();
			u.setLastName(lastname);
		case 3: // update username
			System.out.println("Enter your new username:");
			String username = scanner.nextLine();
			u.setUsername(username);
		case 4: // update password
			System.out.println("Enter your new password:");
			String password = scanner.nextLine();
			u.setPassword(password);
		}
		return uService.updateUser(u);
	}
	
	// CASE 9 - update account
	static Accounts updateAccount(Accounts a) {
		System.out.println("Enter your account number:");
		int accountNumber = Integer.parseInt(scanner.nextLine());
		return aService.updateAccount(a);
	}
	
	
	// CASE 10 - update transaction
	

}
