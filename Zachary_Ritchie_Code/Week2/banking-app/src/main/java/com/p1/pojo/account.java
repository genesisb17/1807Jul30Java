package com.p1.pojo;

import java.util.Arrays;

public class account 
{
	private String account_Name;
	private int account_Id;
	private double balance;
	private String account_type;
	private int customer_id;
	private int counter;
	//private String[] account_type = new String[]{"Checking", "Savings", "Other"};
	
	
	public account() {}


	@Override
	public String toString() {
		return "account [account_Name=" + account_Name + ", account_Id=" + account_Id + ", balance=" + balance
				+ ", account_type=" + account_type + ", customer_id=" + customer_id + ", counter=" + counter + "]";
	}


	public account(String account_Name, int account_Id, double balance, String account_type, int customer_id,
			int counter) {
		super();
		this.account_Name = account_Name;
		this.account_Id = account_Id;
		this.balance = balance;
		this.account_type = account_type;
		this.customer_id = customer_id;
		this.counter = counter;
	}


	public String getAccount_Name() {
		return account_Name;
	}


	public void setAccount_Name(String account_Name) {
		this.account_Name = account_Name;
	}


	public int getAccount_Id() {
		return account_Id;
	}


	public void setAccount_Id(int account_Id) {
		this.account_Id = account_Id;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getAccount_type() {
		return account_type;
	}


	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public int getCounter() {
		return counter;
	}


	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
	
}
