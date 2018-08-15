package com.revature.pojos;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

public class BankAccount {
	/*
	 * Abstract class used to represent any type of account (Savings, Checking, CertificateOfDeposit, Loan, Mortgage, etc.) 
	 * -Defines all operations available
	 *  to a type of account. More specific implementations in the extending classes
	 */
	private final AccountType accountType;
	private final long accountNumber;
	private final long primaryUserID;
	private long secondaryUserID;
	private double balance;
	private List<Transaction> transactions;
	private Timestamp openDate;
	private Timestamp closedDate;

	public BankAccount(AccountType accountType, long accountNumber, long primaryUserID) {
		// Primarily used when creating a new account
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.primaryUserID = primaryUserID;
		this.balance = 0;
		this.transactions = new LinkedList<Transaction>();
	}

	public BankAccount(AccountType accountType, long primaryUserID, long accountNumber, double balance) {
		super();
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.primaryUserID = primaryUserID;
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType.toString();
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public long getPrimaryUserID() {
		return primaryUserID;
	}

	public long getSecondaryUserID() {
		return secondaryUserID;
	}

	public void setSecondaryUserID(long secondaryUserID) {
		this.secondaryUserID = secondaryUserID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean loadTransactions() {
		return false;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public boolean addTransaction(Transaction transaction) {
		transactions.add(transaction);
		return true;
	}

	public Timestamp getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Timestamp openDate) {
		this.openDate = openDate;
	}

	public Timestamp getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Timestamp closedDate) {
		this.closedDate = closedDate;
	}

	@Override
	public String toString() {
		return "BankAccount [accountType=" + accountType + ", accountNumber=" + accountNumber + ", primaryUserID="
				+ primaryUserID + ", secondaryUserID=" + secondaryUserID + ", balance=" + balance + ", openDate="
				+ openDate + ", closedDate=" + closedDate + "]";
	}

	public static AccountType toAccountType(String str) {
		switch (str) {
		case "SAVINGS":
			return AccountType.SAVINGS;
		case "CHECKINGS":
			return AccountType.CHECKING;
		case "CERTIFICATEOFDEPOSIT":
			return AccountType.CERTIFICATEOFDEPOSIT;
		case "LOAN":
			return AccountType.LOAN;
		case "MORTGAGE":
			return AccountType.MORTGAGE;
		default:
			// This should never happen
			return null;
		}
	}

}
