package com.revature.pojos;

import java.util.LinkedList;
import java.util.List;

public class BankAccount {
	/*
	 * Abstract class used to represent any type of account (Savings, Checking, CertificateOfDeposit, Loan, Mortgage, etc.)
	 * 	-Defines all operations available to a type of account. More specific implementations in the extending classes
	 */
	private final AccountType accountType;
	private final int accountNumber;
	private final int primaryUserID;
	private int secondaryUserID;
	private int balance;
	private List<Transaction> transactions;
	
	public BankAccount(AccountType accountType, int accountNumber, int primaryUserID) {
		//Primarily used when creating a new account
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.primaryUserID = primaryUserID;
		this.balance = 0;
		this.transactions = new LinkedList<Transaction>();
	}
	
	public BankAccount(AccountType accountType, int primaryUserID, int accountNumber, int balance, List<Transaction> transactions) {
		super();
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.primaryUserID = primaryUserID;
		this.balance = balance;
		this.transactions = transactions;
	}

	public String getAccountType() {
		return accountType.toString();
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public int getPrimaryUserID() {
		return primaryUserID;
	}
	
	public int getSecondaryUserID() {
		return secondaryUserID;
	}
	
	public void setSecondaryUserID(int secondaryUserID) {
		this.secondaryUserID = secondaryUserID;
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
		return "Account [accountType=" + accountType + ", primaryUserID=" + primaryUserID
				+ ", secondaryUserID=" + secondaryUserID + ", balance=" + balance + ", transactions="
				+ transactions + "]";
	}
	
	
	
}
