package com.revature.datatypes;

public class Primitives {
	/*
	 * Java has 8 primitive datatypes, which represent raw data
	 * in an organized form
	 * int, boolean, byte, char, short, double, long, float
	 * 
	 * boolean N/A true or False
	 * byte		1 byte -128 to 127
	 * char		2 bytes 0 to 65536
	 * double	8 bytes	1.7e-308 to 1.7,,,
	 * int 4 bytes all the way up to 2.1 bil
	 * long 8 bytes all the way up to 9,,,,,,000
	 * float	4 bytes to 3.4e+308
	 * 
	 * when a number/string/array/etc is actually written out,
	 * it is called a literal
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int var; //declaring value
		var = 5; //initializing variable
		var = 10; //reassigning variable
		
		int x = 10; //declaring AND initializing var
		x = 100; //cannot declare the same var twice in the same scope
		/*
		 * in java there are scopes
		 * block scope
		 */
		char ch = 'a';
		>>>>>>> 2b9c7d7ed1b8f4b5d5e599d965bff0cf135f0037
		int million = 1_000_000;
/*
 * must put an l after a long to be recognize. number literals are interpreted as ints. must specify
 * l or L. also put an f for floating point values
 */
		long longNum = 10000000000000000000L;
		
		//CASTING
		// - to change the reference type of an entity
		
		char charAsNum = 160;
		System.out.println(charAsNum);
		
		int toChar = 80;
		char c = (char) toChar;
		System.out.println("int value -" + toChar);
		
		//wrapper classes
		
	}

}
