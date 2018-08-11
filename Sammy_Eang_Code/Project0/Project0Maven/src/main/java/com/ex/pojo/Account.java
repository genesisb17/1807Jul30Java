package com.ex.pojo;

public class Account {
	
	private int account_id;
	private double balance;
	private int account_type_id;
	
	public Account() {}

	public Account(double balance, int account_type_id) {
		super();
		this.balance = balance;
		this.account_type_id = account_type_id;
	}
	
	public Account(int account_id, double balance, int account_type_id) {
		super();
		this.account_id = account_id;
		this.balance = balance;
		this.account_type_id = account_type_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccount_type_id() {
		return account_type_id;
	}

	public void setAccount_type_id(int account_type_id) {
		this.account_type_id = account_type_id;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", balance=" + balance + ", account_type_id=" + account_type_id
				+ "]";
	}
	
	
	
	
}
