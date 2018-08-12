package com.revature.pojo;

public class Accounts {
	private int accountTypeId;
	private double balance;
	private int accId;
	
	public Accounts() {}
	public Accounts(int accountTypeId) {
		this.accountTypeId = accountTypeId;
		this.balance = 100;
	}
	public Accounts(int accountTypeId, double balance) {
		super();
		this.accountTypeId = accountTypeId;
		this.balance = balance;
	}
	public int getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Accounts [accountTypeId=" + accountTypeId + ", balance=" + balance + "]";
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}
	
	

}
