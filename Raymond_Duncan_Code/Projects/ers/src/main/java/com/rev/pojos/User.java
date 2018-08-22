package com.rev.pojos;

public class User {
	
	private long user_id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String company_role;
	public User() {}
	public User(long user_id, String username, String firstname, String lastname, String email, String company_role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.company_role = company_role;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
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
	public String getCompany_role() {
		return company_role;
	}
	public void setCompany_role(String company_role) {
		this.company_role = company_role;
	}
	
	
}
