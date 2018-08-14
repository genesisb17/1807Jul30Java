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
	 * This method is not complicated, and is <em>not</em> a sufficient
	 * implementation for all real-world use-cases. It is only sufficient for
	 * wrapping a single line of text, since it does not take paragraph structure
	 * into account (it replaces all whitespace, even newlines, with single spaces).
	 * 
	 * Also note that this method will produce somewhat unexpected results when
	 * given a string that contains ANSI escape sequences, assuming you expect it to
	 * wrap the string to fit in a given number of <em>terminal</em> columns. This
	 * method ensures that lines are no longer than the given width, counting width
	 * as the length of the line in characters, but does not do any special handling
	 * for escape sequences.
	 * 
	 * @param s     The string to wrap.
	 * @param width The number of columns into which to fit the string.
	 * @return The wrapped string.
	 */
	public static String wordWrap(String s, int width) {
		StringBuilder wrapped = new StringBuilder();
		StringBuilder line = new StringBuilder();
		for (String word : s.split("\\s")) {
			// If we don't make sure line.length() != 0 here, then a very long
			// word would cause this method to loop infinitely and keep trying
			// to push the current line out to the wrapped text. With the test,
			// we add a word into the line unconditionally as long as it is the
			// first word in a line.
			if (line.length() != 0 && line.length() + word.length() + 1 > width) {
				line.append('\n');
				wrapped.append(line);
				line.setLength(0);
			}
			// We need to prepend a space unless we're at the beginning of the
			// line.
			line.append(line.length() == 0 ? word : ' ' + word);
		}
		// Make sure we get stuff from the last line in the buffer.
		if (line.length() != 0) {
			wrapped.append(line);
		}

		return wrapped.toString();
	}
}
