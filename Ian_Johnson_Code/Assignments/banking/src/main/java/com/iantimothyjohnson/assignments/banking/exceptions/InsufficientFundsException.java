package com.iantimothyjohnson.assignments.banking.exceptions;

import java.math.BigDecimal;

/**
 * An exception thrown when an account does not have sufficient funds to perform
 * a particular transaction, such as a withdrawal or transfer.
 * 
 * @author Ian Johnson
 */
public class InsufficientFundsException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new InsufficientFundsException.
	 * 
	 * @param need How much money (in dollars) the account requires for the
	 *             transaction (e.g. the total amount of a withdrawal).
	 * @param have How much money (in dollars) the account actually has.
	 */
	public InsufficientFundsException(BigDecimal need, BigDecimal have) {
		super("Insufficient funds; need $" + need + ", have $" + have + ".");
	}
}
