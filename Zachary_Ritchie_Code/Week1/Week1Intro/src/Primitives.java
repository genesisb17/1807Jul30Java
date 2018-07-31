//package com.revature.datatypes;

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
		
		//CASTING
		
		int toChar = 80;
		char c = (char) toChar;
		System.out.println("int value -" + toChar + "\ncharacter value");
		
		short isShort = 10;
		int shortAsInt = isShort;
		
		int notShort = 10_000_000;
		short sh = (short) notShort;
		System.out.println("casted int 10000 to short: " + sh);
		
		System.out.println("-------------------------");
		
		//non decimal number representations
		//decimal  - base 10 
		int decimal = 10;
		
		//Binary  - base 2
		int binary = 0B1010101;
		System.out.println(binary);
		
		//Octal - base 8 / 0-7
		int octal = 0107624;
		System.out.println("Octal: " + octal);
		
		int hex = 0x12349;
		System.out.println("Hex: " + hex);
		
		
		
	}

}