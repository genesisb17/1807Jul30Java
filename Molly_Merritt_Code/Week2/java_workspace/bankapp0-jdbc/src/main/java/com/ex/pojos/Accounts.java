package com.ex.pojos;

public class Accounts {
	
	private int accountID;
	private int accountNumber;
	private int userID;
	private double balance;
	private int accountType;
	
	public Accounts() {}

	public Accounts(int accountID, int accountNumber, int userID, double balance, int accountType) {
		super();
		this.accountID = accountID;
		this.accountNumber = accountNumber;
		this.userID = userID;
		this.balance = balance;
		this.accountType = accountType;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Accounts [accountID=" + accountID + ", accountNumber=" + accountNumber + ", userID=" + userID
				+ ", balance=" + balance + ", accountType=" + accountType + "]";
	}
	
	

}
