package com.revature.pojo;

public class AllAccounts {
	
	private String firstName;
	private String lastName;
	private int accId;
	private double balance;
	
	public AllAccounts() {}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AllAccounts(String firstName, String lastName, int accId, double balance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accId = accId;
		this.balance = balance;
	}
	
	

}
