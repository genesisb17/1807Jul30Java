package com.bank.pojo;

public class AccountType {
	//variables to display When selecting an account to create;
	private int atid;
	private String aType;
	
	
	//no arg constructor so i can create an object without any variable in it
	public AccountType() {
	}
	//constructor that uses the variables 
	public AccountType(int atid,String aType) {
		super();
		this.setAtid(atid); 
		this.aType = aType;
		
	}
	
	public String getaType() {
		return aType;
	}

	public void setaType(String aType) {
		this.aType = aType;
	}

	

	
	//this is what returns the account types to the loop.
	@Override
	public String toString() {
		return aType + " Account # " + atid;
	}
	public int getAtid() {
		return atid;
	}
	public void setAtid(int atid) {
		this.atid = atid;
	}
	
	public static Integer uaid(int uaid) {
		return uaid;
	}
	

}