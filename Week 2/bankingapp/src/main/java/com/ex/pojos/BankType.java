package com.ex.pojos;

import java.math.BigDecimal;

public class BankType{
	private double current_balance;
	private BigDecimal amount;
	private String username;
	private String userpassword;
	private String firstname;
	private String lastname;
	private int bank_type;
	private int action;
	
	public BankType() {
		
	}
	
	public BankType(double current_balance, BigDecimal amount, String username, String userpassword) {
		super();
		this.current_balance = current_balance;
		this.amount = amount;
		this.username = username;
		this.userpassword = userpassword;
	}

	public double getCurrent_balance() {
		return current_balance;
	}

	public void setCurrent_balance(double current_balance) {
		this.current_balance = current_balance;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getBank_type() {
		return bank_type;
	}

	public void setBank_type(int bank_type) {
		this.bank_type = bank_type;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}
	
	
	
	
	
}
