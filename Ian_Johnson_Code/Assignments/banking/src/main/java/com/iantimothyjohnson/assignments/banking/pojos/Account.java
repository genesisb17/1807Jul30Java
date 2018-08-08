package com.iantimothyjohnson.assignments.banking.pojos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.iantimothyjohnson.assignments.banking.exceptions.InsufficientFundsException;

/**
 * A class representing a single bank account.
 * 
 * @author Ian Johnson
 */
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * The account ID number.
	 */
	private int id;
	/**
	 * The name of the account.
	 */
	private String name;
	/**
	 * The account balance, in dollars. We use a BigDecimal here to avoid
	 * floating-point precision errors.
	 */
	private BigDecimal balance;

	public Account(int id, String name, BigDecimal balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	/**
	 * Gets the account's account ID number.
	 * 
	 * @return The account's account ID number.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the name of the account.
	 * 
	 * @return The name of the account.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the account.
	 * 
	 * @param name The new name of the account.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the account balance.
	 * 
	 * @return The account balance, in dollars.
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * Deposits money into the account.
	 * 
	 * @param amount The amount of money to deposit. The amount must not be
	 *               negative.
	 */
	public void deposit(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Cannot deposit a negative amount.");
		}
		balance = balance.add(amount);
	}

	/**
	 * Withdraws money from the account.
	 * 
	 * @param amount The amount of money to withdraw. The amount must not be
	 *               negative.
	 * @throws InsufficientFundsException If the account does not contain sufficient
	 *                                    funds to perform the withdrawal.
	 */
	public void withdraw(BigDecimal amount) throws InsufficientFundsException {
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Cannot withdraw a negative amount.");
		}
		if (amount.compareTo(balance) < 0) {
			throw new InsufficientFundsException(amount, balance);
		}
		balance = balance.subtract(amount);
	}
}
