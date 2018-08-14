package com.revature.service;

import java.util.List;

import com.revature.pojos.BankAccount;

public class AccountManager {
	/*
	 * Class used to contain all the user's information
	 */
	private final int userID;
	private NameTitle nameTitle = null;
	private final String firstName;
	private final String lastName;
	private final String userName;
	private double totalBalance;
	private boolean bankAccountsLoaded;
	private List<BankAccount> bankAccounts;
	
	public AccountManager(int userID, NameTitle nameTitle, String firstName, String lastName, String userName) {
		super();
		this.userID = userID;
		this.nameTitle = nameTitle;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		bankAccountsLoaded = false;
	}

	public int getUserID() {
		return userID;
	}

	public NameTitle getNameTitle() {
		return nameTitle;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserName() {
		return userName;
	}

	public double getTotalBalance() {
		return totalBalance;
	}
	
	public boolean loadBankAccounts() {
		if(!bankAccountsLoaded) {
			//This needs to load the bank accounts and set the flag to true!
		}
		return true;
	}

}
