package com.revature.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.ClientDAO;
import com.revature.dao.Dao;
import com.revature.pojo.Accounts;
import com.revature.pojo.Client;
import com.revature.pojo.ClientAccount;
import com.revature.service.AccountsService;
import com.revature.service.ClientAccountService;
import com.revature.service.ClientService;

public class App {
	static List<Accounts> allAccounts = new <Accounts> ArrayList();
	static List<Client> allClients = new <Client> ArrayList();
	static List<ClientAccount> allCA = new <ClientAccount>ArrayList();
	static ClientAccountService caService = new ClientAccountService();
	static AccountsService aService = new AccountsService();
	static ClientService cService = new ClientService();
	static int AccountId;
	static int clientId;
	static String user;
	static String pw;
	static Scanner scanner = new Scanner(System.in);
	static int option;
	static Boolean mainMenu = true;
	static double userCID;
	static double userAID;

	public static void main(String[] args) {
		allAccounts = getAccounts();
		allClients = getClients();
		
		
		checkUser();
		menu();
	}
	
	static void menu() {
		while(mainMenu) {
			System.out.println("Main menu\n"
						+ "1 - WITHDRAW MONEY\n"
						+ "2 - DEPOSIT MONEY\n"
						+ "3 - CHECK BALANCE\n"
						+ "4 - CREATE A NEW ACCOUNT\n"
						+ "5 - EXIT");
			String input;
			try {
			input = scanner.nextLine();
			option = Integer.parseInt(input);
			} catch(InputMismatchException e) {
				System.out.println("You did not input a valid option.\n Please select again.\n");
				menu();
			}	
			
			switch(option) {
			
			case 1: withDraw();
					break;
					
			case 2: // Call function to pull up user accounts.
					// call function to selection account 
					break;
			case 3: // Call function to pull up user accounts.
					// call function to selection account
					break;
				
			case 4: createAccount();
					break;
		
					
			case 5: mainMenu = false;
					System.out.println("Goodbye!");
		
			}
			
	
		}	
	}

	static void withDraw() {
		
	}
	

	static void checkUser() {
		Boolean check = true;

		do{

			System.out.println("\n\nWelcome to Revature banking.\n1. "
					+ "Goto my accounts.\n2. Create a new username.\n");
			option = Integer.parseInt(scanner.nextLine());
			
			if(option == 1) {
				System.out.println("Please enter your Username.\n");
				user = scanner.nextLine();
				System.out.println("Please enter your password\n");
				pw = scanner.nextLine();
	
	
				for(Client c : allClients) {
					if(user.equals(c.getUserName()) && pw.equals(c.getPassword())) {
						System.out.println(c.getClientId());
						clientId = c.getClientId();
						check = false;
						break;
					}

				}
				
			System.out.println("User not found!");	
			
			}else if(option == 2){
				addClient();
				check = false;
			}else {
				System.out.println("Invalid Response.");
			}
		}while(check);
	}
	
	static void addClient() {
		
		System.out.println("Creating a new user.\n");

		System.out.println("Enter your first name:\n");
		String firstName = scanner.nextLine();
		System.out.println("Enter your last name:\n");
		String lastName = scanner.nextLine();
		System.out.println("Enter a user name:\n");
		String userName = scanner.nextLine(); 
		System.out.println("Enter a password\n");
		String password = scanner.nextLine(); 

		Client newClient = new Client( firstName, lastName, userName, password);

		ClientService cs = new ClientService();
		clientId = cs.enterClient(newClient);		
		System.out.println("Congradulations! You have created a new user!");

	}
	
	
	static void createAccount() {
		
		System.out.println("What type of account would you like to create?\n"
				+ "1. Checking.\n2. Savings.\n");
		
		Integer accSelect = Integer.parseInt(scanner.nextLine());
		Accounts newAccount = new Accounts(accSelect);
		AccountsService ac = new AccountsService();
		AccountId = ac.saveNew(newAccount);					// new account id
		System.out.println("new account id is: " + AccountId);
			
		System.out.println("Congradulations! You have created a account!");

	}
	
	
	static List<Client> getClients() {
		List<Client> tempClient = cService.getAll();
		return tempClient;
	}	
	
	static List<Accounts> getAccounts() {
		List<Accounts> tempAcc = aService.getAll();		
	return tempAcc;
	}
	
	static List<ClientAccount> getClientAccount() {
		List<ClientAccount> tempCA = caService.getAll();		
		return tempCA;
	}
		
}


















