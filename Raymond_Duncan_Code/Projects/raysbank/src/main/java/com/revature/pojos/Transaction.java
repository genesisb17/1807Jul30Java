package com.revature.pojos;

import java.sql.Timestamp;

public class Transaction {
	/*
	 * Class that represents a single monetary exchange between two accounts
	 */
	private final long transactionID;
	private final long fromAccount;
	private final long toAccount;
	private final double amount;
	private final Timestamp dbTransactionTime;	
		
	public Transaction(long transactionID, long fromAccount, long toAccount, double amount, 
			Timestamp dbTransactionTime) {
		super();
		this.transactionID = transactionID;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.dbTransactionTime = dbTransactionTime;
	}

	public long getTransactionID() {
		return transactionID;
	}

	public long getFromAccount() {
		return fromAccount;
	}

	public long getToAccount() {
		return toAccount;
	}

	public double getAmount() {
		return amount;
	}

	public Timestamp getTransactionTime() {
		return dbTransactionTime;
	}

	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", fromAccount=" + fromAccount + ", toAccount="
				+ toAccount + ", amount=" + amount + ", dbTransactionTime=" + dbTransactionTime + "]";
	}
		
}
