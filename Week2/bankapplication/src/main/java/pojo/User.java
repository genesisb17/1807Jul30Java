package pojo;

import java.util.ArrayList;

public class User {
	
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private ArrayList<Integer> accountIds = new ArrayList<Integer>();
	
	public User() {}

	public User(int id, String firstName, String lastName, String username, String password,
			ArrayList<Integer> accountIds) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.accountIds = accountIds;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	
	public ArrayList<Integer> getAccountid() {
		return accountIds;
	}

	public void setAccountid(ArrayList<Integer> accountids) {
		this.accountIds = accountids;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", accountIds=" + accountIds + "]";
	}


	
}
