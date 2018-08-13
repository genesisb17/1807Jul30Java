package com.iantimothyjohnson.assignments.banking.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * A class consisting of various static helper methods for working with strings.
 * 
 * @author Ian Johnson
 */
public final class StringUtils {
	private StringUtils() {
	}

	/**
	 * Formats the given amount (in dollars) into a nice-looking currency string.
	 * 
	 * @param amount The amount of money to format.
	 * @return The formatted monetary string (e.g. "$1,506.50").
	 */
	public static String formatDollarValue(BigDecimal amount) {
		DecimalFormat df = new DecimalFormat("$#,##0.00");
		return df.format(amount);
	}

	/**
	 * Word-wraps the given string so that it fits within the given number of
	 * columns.
	 * 
	 * @param s     The string to wrap.
	 * @param width The number of columns into which to fit the string.
	 * @return The wrapped string.
	 */
	public static String wordWrap(String s, int width) {
		StringBuilder wrapped = new StringBuilder();
		StringBuilder line = new StringBuilder();
		for (String word : s.split("\\s")) {
			if (line.length() + word.length() > width) {
				line.append('\n');
				wrapped.append(line);
				line.setLength(0);
			}
			line.append(word);
			// Don't append the space if we're at the end of a line.
			if (line.length() != width) {
				line.append(' ');
			}
		}
		// Make sure we get stuff from the last line in the buffer.
		if (line.length() != 0) {
			wrapped.append(line);
		}

		return wrapped.toString();
	}
}
