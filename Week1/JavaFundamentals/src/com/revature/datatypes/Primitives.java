package com.revature.datatypes;

public class Primitives {

	/*
	 * Java has 8 primitive datatypes, which represent raw
	 * data in an organized form. int, bool, byte, char,
	 * short, double, long, float
	 * 
	 * When a number/string/array/etc is written out, it is called
	 * a literal.
	 */
	
	//Primitive Data is raw data that cannot be broken down into more values
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char ch = 'a';
		
		int var; //declaring variable
		var = 5; //initializing variable
		var = 10; //reassigning variable
		
		int x = 10; //declaring and initializing variable
		//cannot declare the same var twice in the same scope
		
		int _num = 0;
		int $dolla = 50;
		
		boolean namingConventionisCamelCase = true; //You can have Uppercase variable names to start though, just unrecommended
		
		double riches = 10_141_400.99; //You can separate numbers like commas using underscores. It has to be between 2 digits
		
		long longNum = 10000000000000L; //Longs must have a capital L after them. Otherwise interpreted as Int
		
		//CASTING - to change the reference type of an entity
		//Implicit Casting
		char charAsNum = 75;
		System.out.println(charAsNum);
		
		//Explicit Casting
		int toChar = 80;
		char c = (char) toChar;
		System.out.println("int value - " + toChar + "\ncharacter value - " + c);
		
		//Implicit Casting. You can make smaller data types into bigger data types (i.e. short to int) but not vice versa
		short isShort=10;
		int shortAsInt = isShort;
		
		int notShort = 10000;
		short sh = (short) notShort;
		System.out.println("casted int 100,000 to short: " + sh);
		
		//non decimal number representations
		
		//Decimal - base 10
		int decimal = 10;
		
		//Binary - base 2. Add 0b or 0B to the beginning of a binary to treat it as a binary
		int binary = 0b101001101;
		System.out.println("binary: " + binary);
		
		//Octal - base 8. Numbers 0 - 7. Add a 0 to the beginning of the int
		int octal = 0107624;
		System.out.println("octal: " + octal);
		
		//Hexadecimal - base 16. -9, a-f. Add 0x to the beginning
		int hex = 0xa3f19d2b;
		System.out.println("hex: " + hex);
		
		System.out.println(Boolean.parseBoolean("false"));
		Long testing = Long.parseLong("98240128L");
	}

}
