package com.ex.main;
import com.ex.pojo.Account;
import com.ex.servicepackage.*;

import java.util.List;
import java.util.Scanner;

public class App {

	static Scanner scanner = new Scanner(System.in);
	static ClientService cService = new ClientService();
	static AccountService aService = new AccountService();
	public static int loggedInId;
	
	public static void main(String[] args) {
		
		menu();

	}
	
	static void menu() {
		
		System.out.println("---------Sign in or Sign Up--------\n"
				+ "1. Login\n"
				+ "2. Sign Up\n"
				+ "Enter a number to proceed: ");
		
		int option = 0;
		
		try {
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you can only choose '1' or '2'");
			menu();
		}
		
		switch(option) {
		case 1:
			int loginid = cService.login();
			if(loginid > -1) {
				loggedInId = loginid;
				System.out.println("Login successful!");
				menu2();
			} else {
				System.out.println("Wrong username/password combination.");
				menu();
			}
			break;
		case 2:
			cService.signup();
			menu();
			break;
		default:
			System.out.println("Sorry, you can only choose '1' or '2'");
			menu();
			break;
		}
	}
	
	static void menu2() {
		System.out.println("---------Hello, what would you like to do today?--------\n"
				+ "1. View Accounts\n"
				+ "2. Add Accounts\n"
				+ "3. Deposit\n"
				+ "4. Withdraw\n"
				+ "5. Logout\n"
				+ "Enter a number to proceed: ");
		
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
			//aService.viewAll(loggedInId);
			aService.chooseFromOwn(loggedInId);
			return2menu();
			break;
		case 2: //Add account
			aService.addAccount(loggedInId);
			return2menu();
			break;
		case 3: // Deposit
			List<Account> ad = aService.chooseFromOwn(loggedInId);
			aService.deposit(ad);
			return2menu();
			break;
		case 4: // Withdraw
			List<Account> aw = aService.chooseFromOwn(loggedInId);
			aService.withdraw(aw);
			return2menu();
			break;
		case 5: // Logout
			System.out.println("Signed out! Now returning to login menu...");
			menu();
			break;
		default:
			System.out.println("Sorry, you may only enter values from '1' through '5'.");
			return2menu();
			break;
		}
	}
	
	static void return2menu() {
		System.out.println("Enter any key to return to menu...");
		String anykey = scanner.nextLine();
		if(anykey != null) {
			System.out.println("Now returning to menu...");
			menu2();
		}
	}

}
