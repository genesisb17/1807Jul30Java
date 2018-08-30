package com.ex.pojos;

public class RequestForm {
	
	private double amount;
	private String description;
	private int requestType;
	private String username;
	public double getAmount() {
		return amount;
	}
	
	RequestForm() {}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRequestType() {
		return requestType;
	}
	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public RequestForm(double amount, String description, int requestType, String username) {
		super();
		this.amount = amount;
		this.description = description;
		this.requestType = requestType;
		this.username = username;
	}
	@Override
	public String toString() {
		return "RequestForm [amount=" + amount + ", description=" + description + ", requestType=" + requestType
				+ ", username=" + username + "]";
	}

}
