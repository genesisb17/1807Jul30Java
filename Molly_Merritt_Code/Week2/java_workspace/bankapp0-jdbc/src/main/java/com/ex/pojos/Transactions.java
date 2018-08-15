package com.ex.pojos;

public class Transactions {
	
	private int transactionID;
	private int accountID;
	private double balance;
//	private enum transactionType {
//		WITHDRAWAL, DEPOSIT, TRANSFER;
//	}
	private String transactionType;
	
	public Transactions() {}

	public Transactions(int transactionID, int accountID, double balance, String transactionType) {
		super();
		this.transactionID = transactionID;
		this.accountID = accountID;
		this.balance = balance;
		this.transactionType = transactionType;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "Transactions [transactionID=" + transactionID + ", accountID=" + accountID + ", balance=" + balance
				+ ", transactionType=" + transactionType + "]";
	}
	
	

}
