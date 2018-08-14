package com.ex.main;
import com.ex.pojo.Account;
import com.ex.servicepackage.*;

import java.util.List;
import java.util.Scanner;

public class App {

	//will be using functions from these classes very often so they are statically called
	static Scanner scanner = new Scanner(System.in);
	static ClientService cService = new ClientService();
	static AccountService aService = new AccountService();
	//will be storing client_id of whoever logged in for future reference and ease of access
	public static int loggedInId;
	
	public static void main(String[] args) {
		//activates program, starting with menu
		menu();

	}
	
	static void menu() {
		
		//Gives options
		System.out.println("---------Sign in or Sign Up--------\n"
				+ "1. Login\n"
				+ "2. Sign Up\n"
				+ "Enter a number to proceed: ");
		
		//Tells user to enter option
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		}
		//Catching error if they try any funny business for inputs and returns to menu
		catch(NumberFormatException e) {
			System.out.println("Sorry, you can only choose '1' or '2'");
			menu();
		}
		
		//depending on the option they chose:
		switch(option) {
		case 1: //login
			//call login function which returns a client_id
			int loginid = cService.login();
			//login auto set to return -1 for there is no client_id
			if(loginid > -1) {
				//if non default client_id is returned, it is passed into static variable and user proceeds onto second menu
				loggedInId = loginid;
				System.out.println("Login successful!");
				menu2();
			} else {
				//if login fails, aka no client_id is assigned and default id of -1 is returned, five error and go back to menu
				System.out.println("Wrong username/password combination.");
				menu();
			}
			break;
		case 2: //sign up and return to menu
			cService.signup();
			menu();
			break;
		default:
			//any non valid number option returns user to menu
			System.out.println("Sorry, you can only choose '1' or '2'");
			menu();
			break;
		}
	}
	
	//menu after login screen
	static void menu2() {//gives user options
		System.out.println("---------Hello, what would you like to do today?--------\n"
				+ "1. View Accounts\n"
				+ "2. Add Accounts\n"
				+ "3. Deposit\n"
				+ "4. Withdraw\n"
				+ "5. Logout\n"
				+ "Enter a number to proceed: ");
		
		//same shpiel as above
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you may only enter values from '1' through '5'.");
			return2menu();
		}
		
		switch(option) {
		case 1: //View all accounts
			//View own accounts then return to menu
			aService.chooseFromOwn(loggedInId);
			return2menu();
			break;
		case 2: //Add account then return to menu
			aService.addAccount(loggedInId);
			return2menu();
			break;
		case 3: //Receive list of own accounts, then activates deposit function, then returns to menu
			List<Account> ad = aService.chooseFromOwn(loggedInId);
			aService.deposit(ad);
			return2menu();
			break;
		case 4: //Receive list of own accounts, then activates withdraw function, then returns to menu
			List<Account> aw = aService.chooseFromOwn(loggedInId);
			aService.withdraw(aw);
			return2menu();
			break;
		case 5: // Logout and return to first meny
			System.out.println("Signed out! Now returning to login menu...");
			menu();
			break;
		default: //invalid options returns to menu
			System.out.println("Sorry, you may only enter values from '1' through '5'.");
			return2menu();
			break;
		}
	}
	
	//brings user back to menu after they enter any input
	static void return2menu() {
		System.out.println("Enter any key to return to menu...");
		String anykey = scanner.nextLine();
		if(anykey != null) {
			System.out.println("Now returning to menu...");
			menu2();
		}
	}

}
