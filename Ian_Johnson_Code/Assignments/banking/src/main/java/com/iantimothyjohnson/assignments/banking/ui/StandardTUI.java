package com.iantimothyjohnson.assignments.banking.ui;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A TUI that uses the standard System.{in,out} streams for I/O.
 * 
 * @author Ian Johnson
 */
public class StandardTUI extends TUI {
	private static final Logger LOGGER = Logger.getLogger(StandardTUI.class.getName());

	/**
	 * This is a nice reusable way to get lines from System.in (so that we don't
	 * have to create a new BufferedReader each time).
	 */
	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	@Override
	public String readLine() throws EOFException {
		try {
			String line = input.readLine();
			if (line != null) {
				return line;
			}
		} catch (IOException e) {
			LOGGER.log(Level.WARNING, "Could not read from standard input.", e);
		}
		throw new EOFException();
	}

	@Override
	public void print(String text) {
		System.out.print(text);
		System.out.flush();
	}
}
