package com.ex.pojos;

public class Transactions {
	
	private int transactionID;
	private int accountID;
	private double balance;
	private enum transactionType {
		WITHDRAWAL, DEPOSIT, TRANSFER;
	}

}
