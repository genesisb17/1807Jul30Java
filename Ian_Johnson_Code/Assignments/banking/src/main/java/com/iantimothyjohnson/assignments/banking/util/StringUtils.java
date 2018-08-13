package com.iantimothyjohnson.assignments.banking.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParsePosition;

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
	public static String formatDollarString(BigDecimal amount) {
		DecimalFormat df = new DecimalFormat("$#,##0.00");
		return df.format(amount);
	}

	/**
	 * Parses a dollar input string by stripping unnecessary but allowable
	 * characters and then converting it to a BigInteger. Currently, these
	 * characters are a leading dollar sign and commas as separators before the
	 * decimal point.
	 * 
	 * @param input The input to normalize.
	 * @return The normalized input.
	 * @throws NumberFormatException If the given input, after stripping unnecessary
	 *                               characters, is not a valid decimal number.
	 */
	public static BigDecimal parseDollarString(String input) {
		if (input.charAt(0) == '$') {
			input = input.substring(1).trim();
		}
		DecimalFormat format = new DecimalFormat("#,##0.00");
		format.setParseBigDecimal(true);
		// The parse method of a DecimalFormat takes a String input as well as a
		// ParsePosition; the ParsePosition is updated to point to the character
		// after the last character parsed during the method. Since we want the
		// entire string to match the format, we check to make sure it is past
		// the end of the string before returning the result.
		ParsePosition pos = new ParsePosition(0);
		BigDecimal parsed = (BigDecimal) format.parse(input, pos);
		if (parsed == null || pos.getIndex() != input.length() || parsed.scale() > 2) {
			// The reason why we throw a NumberFormatException when the scale is
			// greater than 2 is because we don't want the user to be able to
			// make transactions involving fractions of a cent.
			throw new NumberFormatException();
		}
		return parsed;
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
