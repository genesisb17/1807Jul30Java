package com.ex.pojo;

public class Client_Account_Junction {
	
	private int client_id;
	private int account_id;
	
	public Client_Account_Junction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client_Account_Junction(int client_id, int account_id) {
		super();
		this.client_id = client_id;
		this.account_id = account_id;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	@Override
	public String toString() {
		return "Client_Account_Junction [client_id=" + client_id + ", account_id=" + account_id + "]";
	}
	
	
	
	
}
