package com.revature.pojo;

public class AccountType {

	private int accType;
	private String type;
	
	public AccountType() {}
	
	public AccountType(int accType, String type) {
		super();
		this.accType = accType;
		this.type = type;
	}
	
	public int getAccType() {
		return accType;
	}
	public void setAccType(int accType) {
		this.accType = accType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "AccountType [accType=" + accType + ", type=" + type + "]";
	}

	
	
}
