package com.revature.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import com.revature.dao.ClientDAO;
import com.revature.dao.Dao;
import com.revature.pojo.Accounts;
import com.revature.pojo.AllAccounts;
import com.revature.pojo.Client;
import com.revature.pojo.ClientAccount;
import com.revature.service.AccountsService;
import com.revature.service.AllAccountService;
import com.revature.service.ClientAccountService;
import com.revature.service.ClientService;

public class App {
	static List<Accounts> allAccounts = new <Accounts> ArrayList();
	static List<Client> allClients = new <Client> ArrayList();
	static List<ClientAccount> allCA = new <ClientAccount>ArrayList();
	static List<Accounts> allMyAccounts = new<Accounts> ArrayList();
	static ClientAccountService caService = new ClientAccountService();
	static AccountsService aService = new AccountsService();
	static ClientService cService = new ClientService();
	static AllAccountService aaService = new AllAccountService();
	static int AccountId;
	static int clientId;
	static String user;
	static String pw;
	static Scanner scanner = new Scanner(System.in);
	static int option;
	static int updater;
	static Boolean mainMenu = true;
	static double userCID;
	static double userAID; 	
	static List<Integer> myAList = new <Integer>ArrayList();
	static int accountCounter = 0;
	static int nim;
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) {
		allAccounts = getAccounts();
		allClients = getClients();
		allCA = getClientAccount();
		
		String time = aService.time();
		System.out.println(time);
		
		checkUser();
		menu();
		
		
	}
	
	static void menu() {
		while(mainMenu) {
			
			System.out.println("Main menu\n"
						+ "1 - WITHDRAW MONEY\n"
						+ "2 - DEPOSIT MONEY\n"
						+ "3 - CREATE A NEW ACCOUNT\n"
						+ "4 - EXIT");

			try {
			option = Integer.parseInt(scanner.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("You did not input a valid option.\n Please select again.\n");
				menu();
			}	
			
			switch(option) {
			
			case 1: viewAccounts();
					withdrawCash();
					break;
					
			case 2: viewAccounts();
					depositCash();
					break;
				
			case 3: createAccount();
					//break;
		
					
			case 4: mainMenu = false;
					System.out.println("Goodbye!");
		
			}
	
		}	
		getAccounts();
		getClients();
		getClientAccount();
	}
	
	static void depositCash() {
		System.out.println("Enter the amount to deposit.\n");
		double withdraw = scanner.nextInt();
		Accounts w = allMyAccounts.get(updater-1);
		System.out.println("Before Transaction " + w.toString());

		Double prevBal = w.getBalance();
		prevBal += withdraw;
		w.setBalance(prevBal);
		System.out.println( "After Transaction " + w.toString());
		AccountsService ac = new AccountsService();
		ac.updateAccount(w);	
	}
	
	static void withdrawCash() {
		System.out.println("Enter the amount to withdraw.\n");
		double withdraw = scanner.nextInt();
		Accounts w = allMyAccounts.get(updater-1);
		System.out.println("Before Transaction " + w.toString());

		Double prevBal = w.getBalance();
		prevBal -= withdraw;
		if(prevBal < 0) {
			System.out.println("NOT ENOUGH FUNDS AVAILABLE!!!");
			return;
		}
		w.setBalance(prevBal);
		System.out.println( "After Transaction " + w.toString() + "\n");
		AccountsService ac = new AccountsService();
		ac.updateAccount(w);

	}
	
	
	static void viewAccounts() {
		getAccounts();
		for(Accounts t : allMyAccounts) {
			int i =1;
			System.out.print(i + ". ");
			System.out.println(t.toString());
		}
		System.out.println("Select which account");
		updater = scanner.nextInt();		
	}

	

	static void checkUser() {
		Boolean check = true;

		do{

			System.out.println("\n\nWELCOME TO REVATURE BANKING\n\n1. "
					+ "LOGIN TO YOUR ACCOUNT.\n2. CREATE A USERNAME.\n");
			int userOption = Integer.parseInt(scanner.nextLine());						
			
			if(userOption == 1) {
				System.out.println("Please enter your Username.\n");
				user = scanner.nextLine();
				System.out.println("Please enter your password\n");
				pw = scanner.nextLine();
	
	
				for(Client c : allClients) {
					if(user.equals(c.getUserName()) && pw.equals(c.getPassword())) {
						clientId = c.getClientId();
						check = false;
						break;
					} else {
					//	System.out.println("Incorrect Login.");
					}
				}
			
				
				
				
				for(ClientAccount a : allCA) {
					myAList = new <Integer>ArrayList();
					if(clientId == a.getClientId()){
						nim =a.getAccountId();                
					}
				}


				System.out.println("\nHere are your accounts:\n");
					for(Accounts t : allAccounts) {
					//	nim = stack.peek();
						if(nim == t.getAccId()){
							System.out.println((accountCounter+1) + ". " + t.toString() + "\n");
							allMyAccounts.add(t);
						//	stack.pop();
						}					
					}
				
				
				
			
			}else if(userOption == 2){
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
		
		
		
		System.out.println("Congratulations! You have created a new user!");

	}
	
	
	static void createAccount() {
		
		System.out.println("\nAll accounts require a $100 dollar starting fee.\n"
				+ "What type of account would you like to create?\n"
				+ "1. Checking.\n2. Savings.\n");
		
		Integer accSelect = Integer.parseInt(scanner.nextLine());
		Accounts newAccount = new Accounts(accSelect, 100);
		AccountsService ac = new AccountsService();
		AccountId = ac.saveNew(newAccount);		
		
		ClientAccount newCA = new ClientAccount();
		newCA.setAccountId(AccountId);
		newCA.setClientId(clientId);
		caService.saveNew(newCA);
		
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
















