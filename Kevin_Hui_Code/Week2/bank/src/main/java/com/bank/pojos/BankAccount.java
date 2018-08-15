package com.bank.pojos;

public class BankAccount {
	private int accountNumber;
	private String accountType;
	private double balance;
	private int userid;
	
	public BankAccount() {
		super();
	}

	public BankAccount(int accountNumber, String accountTypeId, double balance, int userid) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountTypeId;
		this.balance = balance;
		this.userid = userid;
	}

	public BankAccount(String accountType, double balance, int userid) {
		super();
		this.accountType = accountType;
		this.balance = balance;
		this.userid = userid;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", accountType=" + accountType + ", balance="
				+ balance + ", userid=" + userid + "]";
	}

	
	
}
