package com.ex.pojos;

public class Login {
	private String username;
	private String userpassword;
	private String firstname;
	private String lastname;
	private int accountid;
	
	public Login() {
		
	}

	public Login(String username, String userpassword, String firstname, String lastname,
			int accountid) {
		super();
		this.username = username;
		this.userpassword = userpassword;
		this.firstname = firstname;
		this.lastname = lastname;
		this.accountid = accountid;
	}
	
	public Login(String username, String userpassword, String firstname, String lastname) {
		super();
		this.username = username;
		this.userpassword = userpassword;
		this.firstname = firstname;
		this.lastname = lastname;

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

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	
	
	
	
}
