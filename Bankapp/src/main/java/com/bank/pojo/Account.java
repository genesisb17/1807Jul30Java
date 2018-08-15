package com.bank.pojo;

public class Account {
	//variables to display on login
	private int aid;
	private String aType;
	private double balance;
	private String time;
	
	//no arg constructor so i can create an object without any variable in it
	public Account() {
	}
	//constructor that uses the variables 
	public Account(int aid, double balance) {
		super();
		 
		this.aid = aid;
		this.balance = balance;
	}
	
	public String getaType() {
		return aType;
	}

	public void setaType(String aType) {
		this.aType = aType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	//this is what returns the balance to the loop.
	@Override
	public String toString() {
		return aType + " Account # " + aid  + ": $ " + balance;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}