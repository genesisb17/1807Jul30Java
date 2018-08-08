package com.iantimothyjohnson.assignments.banking.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A TUI that uses the standard System.{in,out} streams for I/O.
 * 
 * @author Ian Johnson
 */
public class StandardTUI extends AbstractTUI {
	/**
	 * This is a nice reusable way to get lines from System.in (so that we don't
	 * have to create a new BufferedReader each time).
	 */
	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	@Override
	public String readLine() {
		try {
			return input.readLine();
		} catch (IOException e) {
			System.err.println("Could not read from standard input:");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void print(String text) {
		System.out.print(text);
	}
}
