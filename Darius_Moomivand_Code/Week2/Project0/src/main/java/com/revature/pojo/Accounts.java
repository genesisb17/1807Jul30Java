package com.revature.pojo;

public class Accounts {
	private int accountType;
	private String type;
	
	public Accounts() {}
	
	public Accounts(int accountType, String type) {
		super();
		this.accountType = accountType;
		this.type = type;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Accounts [accountType=" + accountType + ", type=" + type + "]";
	}
	
	

}
