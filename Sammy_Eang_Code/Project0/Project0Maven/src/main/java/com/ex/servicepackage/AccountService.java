package com.ex.servicepackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ex.dao.AccountDAO;
import com.ex.dao.JunctionDAO;
import com.ex.pojo.Account;
import com.ex.pojo.Client_Account_Junction;

public class AccountService {
	
	//declaring objects from classes so their funcs can be used
	static AccountDAO aDao = new AccountDAO();
	static JunctionDAO jDao = new JunctionDAO();
	static Scanner scanner = new Scanner(System.in);
	
	//add account func which takes a client id
	public void addAccount(int cid) {
		
		//prompts user for what type of account they'd like to add
		System.out.println("What type of account would you like to add?\n"
				+ "1. Checkings\n"
				+ "2. Savings\n"
				+ "Please choose 1 or 2.");
		int accType = 0;
		try {
			accType = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you can only choose '1' or '2'");
			addAccount(cid);
		}
		
		//makes sure user only chooses checkings or savings accounts
		if(accType != 1 && accType != 2) {
			System.out.println("Sorry, those aren't valid options, try again!");
			addAccount(cid);
		}
		
		//prompts and stores for initial account balance
		System.out.println("What is your starting balance for this account?");
		Double accBal = Double.parseDouble(scanner.nextLine());
		//makes new account object of balance and type
		Account newAcc = new Account(accBal, accType);
		//retrieves said object from database and takes id
		Account newAcc2 = aDao.save(newAcc);
		int accId = newAcc2.getAccount_id();
		
		//once account is made and stored, reference to client and account is stored in junction table
		Client_Account_Junction caj = new Client_Account_Junction(cid, accId);
		jDao.save(caj);
		
		//success!
		System.out.println("Account successfully added! Returning to menu...");
	}
	
	//Gives clients a list of their own account and stores it into a list
	public List<Account> chooseFromOwn(int client_id) {
		//find all accounts
		List<Account> a = aDao.findAll();
		//finds all junctions
		List<Client_Account_Junction> j = jDao.findAll();
		//new empty account object
		List<Account> own = new ArrayList<Account>();
		
		//goes through junction table
		for(Client_Account_Junction ja: j) {
			//using client id passed, does it match any accounts in the junction table?
			if(client_id == (ja.getClient_id())) {
				//now go through each account since we know an account exists
				for(Account aa: a) {
					//get the account matching to the one currently pointed to in the junction table
					if(ja.getAccount_id() == aa.getAccount_id()) {
						//add it to the list
						own.add(aa);
					}
				}
			}
		}
		
		//number used to start listing accounts user has
		int num = 1;
		//for each account in list
		for(Account aa: own) {
			String temp_acc_type;
			//if account id is 1, display checkings
			if(aa.getAccount_type_id() == 1) {
				temp_acc_type = "Checkings";
			} else {
				//if account is not 0, display savings
				temp_acc_type = "Savings";
			}
			//display account balance and type
			System.out.println(num + ". Balance = " + aa.getBalance() + " | Type: " + temp_acc_type);
			num++;
		}
		//return all accounts the user owns (added in list)
		return own;
	}
	
	//withdraw function
	public void withdraw(List<Account> a) {
		
		//prompts user to choose an account that was displayed to them
		System.out.println("Choose an account: ");
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, please choose from the above options.");
			withdraw(a);
		}
		
		//asks them how much they want to withdraw
		System.out.println("How much money do you want to withdraw: ");
		Double money = 0.0;
		try {
			money = Double.parseDouble(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, that is not a valid option, try again.");
			withdraw(a);
		}
		
		//Makes sure user only chooses an option they have and resets if they don't
		if(option > a.size()) {
			System.out.println("Sorry, that is not a valid option, try again!");
			withdraw(a);
		}
		
		//grabs associated account, checks if withdraw amount is valid, and performs withdraw
		Account aa = a.get(option - 1);
		if(money <= aa.getBalance()) {
			aDao.withdraw(money, aa.getAccount_id());
			System.out.println("Withdraw successful! You just withdrew " + money + " dollars!");
		} else {
			System.out.println("Looks like you're trying to withdraw too much money, try again!");
			withdraw(a);
		}
	}
	
	//like withdraw but withdraw changed to deposit,flavor text changed, and no money amount check.
	public void deposit(List<Account> a) {
		
		System.out.println("Choose an account: ");
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, please choose from the above options.");
			withdraw(a);
		}
		
		System.out.println("How much money do you want to deposit: ");
		Double money = 0.0;
		try {
			money = Double.parseDouble(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, that is not a valid option, try again.");
			withdraw(a);
		}
		
		Account aa = a.get(option - 1);

		aDao.deposit(money, aa.getAccount_id());
		System.out.println("Deposit successful! You just deposited " + money + " dollars!");

	}
	
	
	
}
