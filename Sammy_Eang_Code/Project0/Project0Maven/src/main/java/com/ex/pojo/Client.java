package com.ex.pojo;

public class Client {

	private int client_id;
	private String client_first_name;
	private String client_last_name;
	private String username;
	private String pw;
	
	public Client() {}

	public Client(String client_first_name, String client_last_name, String username, String pw) {
		super();
		this.client_first_name = client_first_name;
		this.client_last_name = client_last_name;
		this.username = username;
		this.pw = pw;
	}
	
	public Client(int client_id, String client_first_name, String client_last_name, String username, String pw) {
		super();
		this.client_id = client_id;
		this.client_first_name = client_first_name;
		this.client_last_name = client_last_name;
		this.username = username;
		this.pw = pw;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getClient_first_name() {
		return client_first_name;
	}

	public void setClient_first_name(String client_first_name) {
		this.client_first_name = client_first_name;
	}

	public String getClient_last_name() {
		return client_last_name;
	}

	public void setClient_last_name(String client_last_name) {
		this.client_last_name = client_last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", client_first_name=" + client_first_name + ", client_last_name="
				+ client_last_name + ", username=" + username + ", password=" + pw + "]";
	}
	
	
	
	
}
