package com.ex.pojo;

public class AccountType {
	
	private int account_type_id;
	private String account_type;
	
	public AccountType() {}

	public AccountType(String account_type) {
		super();
		this.account_type = account_type;
	}
	
	public AccountType(int account_type_id, String account_type) {
		super();
		this.account_type_id = account_type_id;
		this.account_type = account_type;
	}

	public int getAccount_type_id() {
		return account_type_id;
	}

	public void setAccount_type_id(int account_type_id) {
		this.account_type_id = account_type_id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	@Override
	public String toString() {
		return "AccountType [account_type_id=" + account_type_id + ", account_type=" + account_type + "]";
	}
	
}
