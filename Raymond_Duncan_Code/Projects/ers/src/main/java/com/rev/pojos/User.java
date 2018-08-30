package com.rev.pojos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private Long userID;
	private String username;
	private transient String password;
	private String firstname;
	private String lastname;
	private String email;
	private String companyRole;
	private Long creator;
	public User() {}
	public User(Long userID, String username, String firstname, String lastname, String email, String companyRole) {
		super();
		this.userID = userID;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.companyRole = companyRole;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
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
	public Long getCreator() {
		return creator;
	}
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", companyRole=" + companyRole + ", creator=" + creator + "]";
	}
	
	
}
