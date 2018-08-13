package com.iantimothyjohnson.assignments.banking.exceptions;

public class ConsoleNotSupportedException extends Exception {
	private static final long serialVersionUID = 1L;

	public ConsoleNotSupportedException() {
		super("I/O using a Console object is not supported on this terminal.");
	}
}
