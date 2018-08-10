package com.p1.pojo;

public class customer 
{
	private String firstName;
	private String lastName;
	private int userId;
	private String user_Username;
	private String user_Password;
	
	public customer() {}
	
	public customer(String firstName, String lastName, int userId, String user_Username, String user_Password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.user_Username = user_Username;
		this.user_Password = user_Password;
	}
	@Override
	public String toString() {
		return "customer [firstName=" + firstName + ", lastName=" + lastName + ", userId=" + userId + ", user_Username="
				+ user_Username + ", user_Password=" + user_Password + "]";
	}
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUser_Username() {
		return user_Username;
	}
	public void setUser_Username(String user_Username) {
		this.user_Username = user_Username;
	}
	public String getUser_Password() {
		return user_Password;
	}
	public void setUser_Password(String user_Password) {
		this.user_Password = user_Password;
	}
	
	
}
