package com.revature.pojos;

import java.time.ZonedDateTime;

public class Transaction {
	/*
	 * Class that represents a single monetary exchange between two accounts
	 */
	private final int transactionID;
	private final int fromAccount;
	private final int toAccount;
	private final double amount;
	private final double balance;
	private final ZonedDateTime dbTransactionTime;	
		
	public Transaction(int transactionID, int fromAccount, int toAccount, double amount, double previousBalance, 
			ZonedDateTime dbTransactionTime) {
		super();
		this.transactionID = transactionID;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.balance = amount + previousBalance;
		this.dbTransactionTime = dbTransactionTime;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public int getFromAccount() {
		return fromAccount;
	}

	public int getToAccount() {
		return toAccount;
	}

	public double getAmount() {
		return amount;
	}
	
	public double getBalance() {
		return balance;
	}

	public ZonedDateTime getTransactionTime() {
		return dbTransactionTime;
	}
	
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", fromAccount=" + fromAccount + ", toAccount="
				+ toAccount + ", amount=" + amount + "]";
	}
		
}
