package com.revature.pojo;

public class Client {

	private int clientId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private int id;
	
	public Client() {}
	
	public Client(String firstName, String lastName, String userName, String password) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + "]";
	}

	public void setId(int int1) {
		this.id = int1;
	}
	
	
}
