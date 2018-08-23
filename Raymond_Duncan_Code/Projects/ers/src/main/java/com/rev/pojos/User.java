package com.rev.pojos;

public class User {
	
	private long userID;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String companyRole;
	public User() {}
	public User(long userID, String username, String firstname, String lastname, String email, String companyRole) {
		super();
		this.userID = userID;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.companyRole = companyRole;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompanyRole() {
		return companyRole;
	}
	public void setCompanyRole(String companyRole) {
		this.companyRole = companyRole;
	}
	
	
}
