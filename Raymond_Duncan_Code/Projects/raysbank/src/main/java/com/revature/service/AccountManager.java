package com.revature.service;

import java.util.List;

import com.revature.dao.BankAccountDAO;
import com.revature.pojos.AccountType;
import com.revature.pojos.BankAccount;

public class AccountManager {
	/*
	 * Class used to contain all the user's information
	 */
	private final long userID;
	private NameTitle nameTitle = null;
	private final String firstName;
	private final String lastName;
	private double totalBalance;
	private List<BankAccount> bankAccounts;
	
	static BankAccountDAO badao = new BankAccountDAO();
	
	public AccountManager(long userID, NameTitle nameTitle, String firstName, String lastName) {
		super();
		this.userID = userID;
		this.nameTitle = nameTitle;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getUserID() {
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

	public double getTotalBalance() {
		return totalBalance;
	}
	
	public List<BankAccount> getBankAccounts() {
		if(bankAccounts == null) {
			//This needs to load the bank accounts and set the flag to true!
			bankAccounts = badao.getBankAccounts(userID);
		}
		return bankAccounts;
	}
	
	private void updateBankAccounts() {
		bankAccounts = badao.getBankAccounts(userID);
	}
	
	public void depositMoney(BankAccount ba,double amount) {
		ba.setBalance(ba.getBalance()+amount);
		badao.update(ba);
	}
	
	public boolean withdrawMoney(BankAccount ba, double amount) {
		if(ba.getBalance() >= amount) {
			ba.setBalance(ba.getBalance()-amount);
			badao.update(ba);
			return true;
		} else return false;
	}
	
	public void createNewAccount(AccountType accountType, double startingBalance) {
		BankAccount ba = new BankAccount(accountType,1,userID,startingBalance);
		badao.save(ba);
		updateBankAccounts();
	}
	
	public static NameTitle toNameTitle(String str) {
		switch(str) {
			case "None":
				return NameTitle.None;
			case "Mr":
				return NameTitle.Mr;
			case "Mrs":
				return NameTitle.Mrs;
			case "Dr":
				return NameTitle.Dr;
			default:
				//Should never reach here
				return null;
		}
	}

}
