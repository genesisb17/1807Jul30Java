package com.revature.datatypes;

public class Primitives {
	/*
	 * Java has 8 primitive datatypes, which represent raw data
	 * i an organized form
	 * int, boolean, byte, char, short, double, long, float
	 * boolean - N/A - True or False
	 * byte - 1 byte - -128 to 127
	 * char - 2 bytes 0 to 65536
	 * double - 8 bytes - 1.7e-308 to 1.7e+308
	 * int - 4 bytes - [fill]
	 * long - 8 bytes - [fill]
	 * float - 4 bytes - [fill]
	 * short - 2 bytes - [fill]
	 * 
	 * When a number/string/array/etc is actually written out, it is called a literal
	 */

	public static void main(String[] args) {
		int var; //declaring variable
		var = 5; //initializing a variable
		var = 10; //reassigning variables=-
		
		int x = 10; //declaring AND initializing car
//		int x = 100 Wont work because x is already declared. Cannot declare the same var twice in the same scope
		
		int ch = 'a';
		
		int _num = 0;
		int $dolla = 50;
		
		boolean namingConventionIsCamelCase = true;
		
		double riches = 10_141_400.99; //Underscores can be used to make large numbers more readable
		int million = 1_000_000;
		
//		int longNum = 100000000000000; This won't work because the number is out of the range representable by the int type
		long longNum = 100000000000000L; //In order to represent long numbers, they need an "L" at the end
		
		//CASTING
		//Casting is changing the reference type of an entity
		
		char charAsNum =100;
		System.out.println(charAsNum);
		
		int toChar = 80;
		char c = (char) toChar;
		System.out.println("A" + (char) toChar);
		
		short isShort = 10;
		int shortAsInt = isShort;
		
		int notShort = 10_000_000;
		short sh = (short) notShort;
		System.out.println("Casted int 10_000_000 into short " + sh); //Casting to a smaller datatype truncates the number before evaluating the two's compliment value
		
		//non decimal number representations
		
		//Decimal - base 10
		int decimal = 10;
		
		//Binary - base 2
		int binary = 0B10001010; //Binary values must be preceded by 0B
		System.out.println("binary: " + binary);
		
		//Octal - base 8
		int octal = 017634; //Octal must be preceded by 0
		System.out.println("octal: " + octal);
		
		//Dexadecimal - base 16
		int hex = 0xff3ae; //Hexadecimal must be preceded by 0x
		System.out.println("hex: " + hex);
		
	}
}
