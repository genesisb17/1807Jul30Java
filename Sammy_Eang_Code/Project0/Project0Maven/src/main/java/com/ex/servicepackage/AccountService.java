package com.ex.servicepackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ex.dao.AccountDAO;
import com.ex.dao.AccountTypeDAO;
import com.ex.dao.JunctionDAO;
import com.ex.pojo.Account;
//import com.ex.pojo.AccountType;
import com.ex.pojo.Client_Account_Junction;

public class AccountService {
	
	static AccountDAO aDao = new AccountDAO();
	static JunctionDAO jDao = new JunctionDAO();
	static AccountTypeDAO atDao = new AccountTypeDAO();
	static Scanner scanner = new Scanner(System.in);
	
	
//	public void viewAll(int client_id) {
//		List<Account> a = aDao.findAll();
//		List<Client_Account_Junction> j = jDao.findAll();
//		List<AccountType> at = atDao.findAll();
//		
//		for(Client_Account_Junction ja: j) {
//			if(client_id == (ja.getClient_id())) {
//				for(Account aa: a) {
//					if(ja.getAccount_id() == aa.getAccount_id()) {
//						for(AccountType ata: at) {
//							if(aa.getAccount_type_id() == ata.getAccount_type_id())
//								System.out.println("Balance = " + aa.getBalance() + "| Account Type = " + ata.getAccount_type());
//						}
//					}
//				}
//			}
//		}
//	}
	
	public void addAccount(int cid) {
		
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
		
		System.out.println("What is your starting balance for this account?");
		Double accBal = Double.parseDouble(scanner.nextLine());
		Account newAcc = new Account(accBal, accType);
		Account newAcc2 = aDao.save(newAcc);
		int accId = newAcc2.getAccount_id();
		
		Client_Account_Junction caj = new Client_Account_Junction(cid, accId);
		jDao.save(caj);
		
		System.out.println("Account successfully added! Returning to menu...");
	}
	
	public List<Account> chooseFromOwn(int client_id) {
		List<Account> a = aDao.findAll();
		List<Client_Account_Junction> j = jDao.findAll();
		List<Account> own = new ArrayList<Account>();
		
		for(Client_Account_Junction ja: j) {
			if(client_id == (ja.getClient_id())) {
				for(Account aa: a) {
					if(ja.getAccount_id() == aa.getAccount_id()) {
						own.add(aa);
					}
				}
			}
		}
		
		int num = 1;
		for(Account aa: own) {
			String temp_acc_type;
			if(aa.getAccount_type_id() == 1) {
				temp_acc_type = "Checkings";
			} else {
				temp_acc_type = "Savings";
			}
			
			System.out.println(num + ". Balance = " + aa.getBalance() + " | Type: " + temp_acc_type);
			num++;
		}
		return own;
	}
	
	public void withdraw(List<Account> a) {
		
		System.out.println("Choose an account: ");
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, please choose from the above options.");
			withdraw(a);
		}
		
		System.out.println("How much money do you want to withdraw: ");
		Double money = 0.0;
		try {
			money = Double.parseDouble(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, that is not a valid option, try again.");
			withdraw(a);
		}
		
		Account aa = a.get(option - 1);
		if(money < aa.getBalance()) {
			aDao.withdraw(money, aa.getAccount_id());
			System.out.println("Withdraw successful! You just withdrew " + money + " dollars!");
		} else {
			System.out.println("Looks like you're trying to withdraw too much money, try again!");
			withdraw(a);
		}
	}
	
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
