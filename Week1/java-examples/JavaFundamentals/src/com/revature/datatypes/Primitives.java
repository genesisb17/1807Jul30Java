package com.revature.datatypes;

public class Primitives {
/*
 * Java has 8 primitive datatypes, which represent raw data
 * in an organized form. 
 * int, boolean, byte, char, short, double, long, float
 * 
 * When a number/string/array/etc is actually written out, 
 * it is called a literal
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int var; //declaring variable
		var = 5; //intializing variable 
		var = 10; // reassigning variable 
		
		
		int x = 10; // declaring AND initializing var
		x = 100; //cannot declare the same var twice in the same scope
		
		char ch = 'a';
		
		int _num = 0;
		int $dolla = 50;
		
		boolean namingConventionIsCamelCase = true;
		
		double riches = 10_141_400.99;
		int million = 1_000_000;
		
		//number literals are interpreted as ints. must specify L or l to be long
		long longNum = 1000000000000000L; 
		
		//CASTING
		// - to change the reference type of an entity
		
		char charAsNum = 100;
		System.out.println(charAsNum);
		
		int toChar = 80;
		char c = (char) toChar;
		System.out.println("int value - "  + toChar + "\ncharacter value - " + c);
		
		short isShort = 10;
		int shortAsInt = isShort;
		
		
		int notShort = 100000;
		short sh = (short) notShort;
		System.out.println("casted int 100000 to short: " + sh);
		
		System.out.println("-------------------------------");
		//non decimal number representations 
		
		//Decimal - base 10
		int decimal = 10;
		
		//Binary - base 2
		int binary = 0B10001101;
		System.out.println("binary: " + binary);
		
		//Octal - base 8 / 0-7
		int octal = 0107624;
		System.out.println("octal: " + octal);
		
		//Hexadecimal - base 16 / 0-9,a-f
		int hex = 0X3F19d2b;
		System.out.println("hex: " + hex);
		
		
		
		
		
		
		
		// WRAPPER CLASSES
		
	}

}
