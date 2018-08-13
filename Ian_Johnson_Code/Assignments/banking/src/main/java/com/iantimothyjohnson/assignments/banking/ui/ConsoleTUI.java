package com.iantimothyjohnson.assignments.banking.ui;

import java.io.Console;
import java.io.EOFException;

import com.iantimothyjohnson.assignments.banking.exceptions.ConsoleNotSupportedException;

/**
 * A fancier TUI that uses System.console to get a Console object for more
 * advanced features (where available). Currently, the only additional feature
 * over StandardTUI is the suppression of password echoing; color support would
 * be nice, but Windows doesn't support the ANSI color codes that everyone else
 * does, so we would need to detect the user's platform.
 * 
 * @author Ian Johnson
 */
public class ConsoleTUI extends TUI {
	/**
	 * The underlying Console to use for I/O.
	 */
	private Console console;
	public ConsoleTUI() throws ConsoleNotSupportedException {
		console = System.console();
		if (console == null) {
			throw new ConsoleNotSupportedException();
		}
	}

	@Override
	public String readLine() throws EOFException {
		String line = console.readLine();
		if (line == null) {
			throw new EOFException();
		}
		return line;
	}
	
	@Override
	public char[] readPassword() throws EOFException {
		char[] password = console.readPassword();
		if (password == null) {
			throw new EOFException();
		}
		return password;
	}

	@Override
	public void print(String text) {
		console.writer().print(text);
		console.flush();
	}
}
