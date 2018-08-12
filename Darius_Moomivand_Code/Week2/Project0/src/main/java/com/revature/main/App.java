package com.revature.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.pojo.Accounts;
import com.revature.pojo.Client;
import com.revature.service.AccountsService;
import com.revature.service.ClientService;

public class App {
	
	ArrayList<Accounts> allAccounts = new <Accounts> ArrayList();
	ArrayList<Client> allClients = new <Client> ArrayList();
	
	static Scanner scanner = new Scanner(System.in);
	static int option;

	public static void main(String[] args) {
		
		checkUser();
		menu();
	}
	
	static void menu() {
		System.out.println("Main menu\n"
					+ "1 - WITHDRAW MONEY\n"
					+ "2 - DEPOSIT MONEY\n"
					+ "3 - CHECK BALANCE\n"
					+ "4 - CREATE A NEW ACCOUNT\n");
		String input;
		try {
		input = scanner.nextLine();
		option = Integer.parseInt(input);
		} catch(InputMismatchException e) {
			System.out.println("You did not input a valid option.\n Please select again.\n");
			menu();
		}	
		
		switch(option) {
		
		case 1: // Call function to pull up user accounts.
				// call function to selection account
				break;
				
		case 2: // Call function to pull up user accounts.
				// call function to selection account 
				break;
		case 3: // Call function to pull up user accounts.
				// call function to selection account
				break;
			
		case 4: addClient();
				
				break;		
	
		}
		
	

	}
	
	static void checkUser() {
		Boolean check = true;
		do {
				
			String user;
			String pw;
			System.out.println("Welcome to Revature banking.\n1. "
					+ "Goto my accounts.\n2. Create a new account.\n");
			option = Integer.parseInt(scanner.nextLine());
			if(option == 1) {
				System.out.println("Please enter your Username.");
				user = scanner.nextLine();
				System.out.println("Please enter your password");
				pw = scanner.nextLine();
				
				
				
				check = false;

			} else if(option == 2){
				addClient();
				check = false;

			} else {
				System.out.println("Invalid Response.");
			}
		}while(check);
	}
	
	static void addClient() {
		System.out.println("All new accounts require an initial $100.00 deposit.\nLets create your account.\n");

		System.out.println("Enter your first name:\n");
		String firstName = scanner.nextLine();
		System.out.println("Enter your last name:\n");
		String lastName = scanner.nextLine();
		System.out.println("Enter a user name:\n");
		String userName = scanner.nextLine(); 
		System.out.println("Enter a password");
		String password = scanner.nextLine(); 

		Client newClient = new Client(firstName, lastName, userName, password);
		ClientService cs = new ClientService();
		cs.enterClient(newClient);		

		System.out.println("What type of account would you like to create?\n"
				+ "1. Checking.\n2. Savings.\n");
		Integer accSelect = Integer.parseInt(scanner.nextLine());
		Accounts newAccount = new Accounts(accSelect);
		AccountsService ac = new AccountsService();
		ac.saveNew(newAccount);
		System.out.println("Congradulations! You have created a new account!\n Press Enter to Continue.");
		String confirm = scanner.nextLine();
	}
	
	
	static getAccounts() {
		
	}
	
}


















