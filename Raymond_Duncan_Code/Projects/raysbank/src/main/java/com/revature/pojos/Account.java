package com.revature.pojos;

import java.util.LinkedList;
import java.util.List;

public class Account {
	/*
	 * Abstract class used to represent any type of account (Savings, Checking, CertificateOfDeposit, Loan, Mortgage, etc.)
	 * 	-Defines all operations available to a type of account. More specific implementations in the extending classes
	 */
	private final AccountType accountType;
	private final int primaryAccountID;
	private int secondaryAccountID;
	private int balance;
	private List<Transaction> transactions;
	
	public Account(AccountType accountType, int primaryAccountID) {
		this.accountType = accountType;
		this.primaryAccountID = primaryAccountID;
		this.balance = 0;
		this.transactions = new LinkedList<Transaction>();
	}
	
	public Account(AccountType accountType, int primaryAccountID, int balance, List<Transaction> transactions) {
		super();
		this.accountType = accountType;
		this.primaryAccountID = primaryAccountID;
		this.balance = balance;
		this.transactions = transactions;
	}

	public String getAccountType() {
		return accountType.toString();
	}

	public int getPrimaryAccountID() {
		return primaryAccountID;
	}
	
	public int getSecondaryAccountID() {
		return secondaryAccountID;
	}
	
	public void setSecondaryAccountID(int secondaryAccountID) {
		this.secondaryAccountID = secondaryAccountID;
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public boolean addTransaction(Transaction transaction) {
		transactions.add(transaction);
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountType=" + accountType + ", primaryAccountID=" + primaryAccountID
				+ ", secondaryAccountID=" + secondaryAccountID + ", balance=" + balance + ", transactions="
				+ transactions + "]";
	}
	
	
	
}
