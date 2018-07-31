package com.revature.datatypes;

public class Primitives {
/*
 * Java has 8 primitives datatypes, which represent raw data
 * in an organized form.
 * int, boolean, byte, char, short, double, long, float
 * 
 * When a number/string/array/etc is actually written out,
 * it is called a literal
 */
	public static void main(String[] args) {
		
		int var; //declaring variable
		var = 5; //initializing variable
		var = 10; //reassigning variable
		char ch = 'a'; 
		
		int x = 10; //declaring AND initializing var
		//int x = 100; //cannot declare the same var twice in the same scope
		
		boolean namingConventionIsCamlCase = true;
		
		double riches = 10_003_131.32;
		int million = 1_000_000;
		
		//number literals are interpreted as ints. must specify L or l to be long
		long longNum = 10000000000000000L; //anything longer than an int use an L at the end
		
		//CASTING
		// - to change the reference type of an entity
		//can change char into an int
		
		char charAsNum = 75;
		System.out.println(charAsNum);
		
		int toChar = 80;
		char c = (char) toChar;
		System.out.println("int value - " + toChar +"\ncharacter value is " + c);
		
		int notShort = 10000000;
		short sh = (short) notShort;
		System.out.println("casted int 1000000: " + sh);
		
		System.out.println("--------------------------------");
		//non decimal number representations
		
		//Decimal - base 10
		int decimal = 10;
		//Binary - base 2
		int binary = 0b101010110;
		System.out.println("binary: " + binary);
		//Octal - base 8 (0-7) insert 0 in beginning to represent octal
		int octal = 0107624;
		System.out.println("octal: " + octal);
		//Hexadecimal - base 16/0-9,a-f
		int hex = 0xa3f19d2b;
		System.out.println("hex: " + hex);
		
	}
	//scopes : object, class/static, method, block

}
