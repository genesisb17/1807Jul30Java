package com.rev.menu;

public class Account {

private int accID;
private int owner;
private int accNumber;
private String accType;
private double balance;


@Override
public String toString() {
	return "Account ID is: " + accID +"||| Account owners id: " + owner + "||| Account Number: " + accNumber + "||| Account Type: " + accType
			+ "||| Current balance: " + balance;
}
public int getAccID() {
	return accID;
}
public void setAccID(int accID) {
	this.accID = accID;
}
public int getOwner() {
	return owner;
}
public void setOwner(int owner) {
	this.owner = owner;
}
public int getAccNumber() {
	return accNumber;
}
public void setAccNumber(int accNumber) {
	this.accNumber = accNumber;
}
public String getAccType() {
	return accType;
}
public void setAccType(String accType) {
	this.accType = accType;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}

}
