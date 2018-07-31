package com.iantimothyjohnson.notes;

public class Primitives {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Here are the primitive types:
		// boolean, byte, char, short, int, long, float, double

		// You can cast like this:
		int toChar = 80;
		char c = (char)toChar;
		System.out.println("As int: " + toChar);
		System.out.println("As char: " + c);
		
		// You can implicitly convert to larger types:
		short isShort = 10;
		int shortAsInt = isShort;
		
		// Need explicit cast for loss of precision:
		int notShort = 10_000_000;
		short sh = (short)notShort;
		System.out.println("Casted " + notShort + " to " + sh);
		
		// Non-decimal number representations:
		// Decimal - base 10
		int decimal = 10;
		// Binary - base 2
		int binary = 0b10010;
		// Octal - base 8
		int octal = 0644;
		// Hexadecimal - base 16
		int hexadecimal = 0xBEEF;
	}
}
