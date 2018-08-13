package com.revature.pojo;

public class ClientAccount {
	private double clientId;
	private double accountId;
	
	public ClientAccount() {}
	
	public ClientAccount(double clientId, double accountId) {
		super();
		this.clientId = clientId;
		this.accountId = accountId;
	}
	public double getClientId() {
		return clientId;
	}
	public void setClientId(double clientId) {
		this.clientId = clientId;
	}
	public double getAccountId() {
		return accountId;
	}
	public void setAccountId(double accountId) {
		this.accountId = accountId;
	}
	
	@Override
	public String toString() {
		return "ClientAccount [clientId=" + clientId + ", accountId=" + accountId + "]";
	}

}
