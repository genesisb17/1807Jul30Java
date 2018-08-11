package com.ex.main;
import com.ex.servicepackage.*;

import java.util.Scanner;

public class App {

	static Scanner scanner = new Scanner(System.in);
	static ClientService cService = new ClientService();
	
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
			Boolean successfulLogin = cService.login();
			if(successfulLogin) {
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
			System.out.println("Sorry, you can only choose '1' or '2'");
			menu();
		}
		
		switch(option) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			System.out.println("Signed out! Now returning to login menu...");
			menu();
			break;
		default:
			System.out.println("Sorry, you may only enter values from '1' through '5'.");
			menu2();
			break;
		}
	}

}
