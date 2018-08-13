package com.iantimothyjohnson.assignments.banking.util;

/**
 * A wrapper around a String that allows it to be styled with ANSI escape codes
 * (colors, bold, underline, etc.). See
 * <a href="https://en.wikipedia.org/wiki/ANSI_escape_code">the Wikipedia page
 * on ANSI escape codes</a> for details on how these work.
 * 
 * Instances of this class are immutable, just like String. Also, since ANSI
 * escape codes don't work on Windows, the toString method just returns the
 * original text there.
 * 
 * @author Ian Johnson
 */
public class ANSIString {
	/**
	 * The "control sequence introducer".
	 */
	private static final String CSI = "\033[";

	/**
	 * The underlying text of the string.
	 */
	private String text;
	private Color fgColor;
	private Color bgColor;
	private boolean isBold;
	private boolean isUnderlined;

	public enum Color {
		BLACK(0), RED(1), GREEN(2), YELLOW(3), BLUE(4), MAGENTA(5), CYAN(6), WHITE(7);

		/**
		 * The foreground color minus 30, or the background color minus 40 (these are
		 * the same).
		 */
		private int offset;

		private Color(int offset) {
			this.offset = offset;
		}

		public int foregroundColorId() {
			return offset + 30;
		}

		public int backgroundColorId() {
			return offset + 40;
		}
	}

	public ANSIString(String text) {
		this.text = text;
	}

	public ANSIString foreground(Color fg) {
		ANSIString ret = this;
		ret.fgColor = fg;
		return ret;
	}

	public ANSIString background(Color bg) {
		ANSIString ret = this;
		ret.bgColor = bg;
		return ret;
	}

	public ANSIString bold() {
		ANSIString ret = this;
		ret.isBold = true;
		return ret;
	}

	public ANSIString underlined() {
		ANSIString ret = this;
		ret.isUnderlined = true;
		return ret;
	}

	public String toString() {
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			// Windows doesn't support ANSI escapes :(
			return text;
		}

		StringBuilder sb = new StringBuilder();
		if (fgColor != null) {
			sb.append(CSI + fgColor.foregroundColorId() + "m");
		}
		if (bgColor != null) {
			sb.append(CSI + bgColor.backgroundColorId() + "m");
		}
		if (isBold) {
			sb.append(CSI + "1m");
		}
		if (isUnderlined) {
			sb.append(CSI + "4m");
		}
		sb.append(text);
		sb.append(CSI + "0m");

		return sb.toString();
	}
}
