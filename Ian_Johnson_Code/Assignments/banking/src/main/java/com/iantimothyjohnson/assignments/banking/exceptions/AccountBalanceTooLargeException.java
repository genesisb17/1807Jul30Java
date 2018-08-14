package com.iantimothyjohnson.assignments.banking.exceptions;

import java.math.BigDecimal;

import com.iantimothyjohnson.assignments.banking.pojos.Account;
import com.iantimothyjohnson.assignments.banking.util.StringUtils;

public class AccountBalanceTooLargeException extends Exception {
	private static final long serialVersionUID = 1L;

	public AccountBalanceTooLargeException(BigDecimal balance) {
		super("Desired balance " + StringUtils.formatDollarString(balance)
				+ " is larger than the maximum account balance of "
				+ StringUtils.formatDollarString(Account.MAX_BALANCE) + ".");
	}
}
