package com.revature.classbasics;

/**
 * 
 * @author Genesis
 *
 */
public class Operators {

	/* A Java operator is a special symbol that can be applied to a set of 
	 * variables, values, or literals - referred to as operands - and that 
	 * returns a result 
	 * 
	 * There are Unary, Binary, and Ternary operators - with 1, 2, and 3 
	 * operands, respectively 
	 * 
	 */

	//UNARY

	//post-unary operators
	static void postUnary(int count) {
		count++; // count = count + 1
		count--; // count = count - 1
	}

	static void preUnary(int count) {
		++count;
		--count;
	}
	
	void test(int count){ //4
		if(count++ < 5) {
			System.out.println("hi");
		}
	}

	// ~ 2's complement n = -(n+1)
	/*
	 * Bitwise complement is denoted by ~
	 * It inverts the bit pattern
	 * 
	 * 35 = 00100011
	 * ~
	 * 		11011100 = 220 
	 * 
	 * The compiler, however, gives us the 2's complement of the number
	 * For any int n, 2's complement of n = -(n+1)	 
	 * 
	 * If placed in front of a string, it will convert that string to a
	 * number for the calculation 
	 * https://www.joezimjs.com/javascript/great-mystery-of-the-tilde/*/
	static int complement(int x) {
		return ~x;
	}

	static void moreOperators(int x) { // in order from left to right
		int y = -x;
		y = +4;
		boolean a = !true;
	}

	//BINARY

	static int binary(int a, int b) { // in order from left to right
		a = a * 2;
		b = 2 /a;
		int even = b % 2;
		return even;
	}

	// shift operators - left to right << >> >>>
	/* Signed Left Shift is denoted by <<
	 * It shifts a bit pattern to the left by a certain number of specified bits,
	 * and zero bits are shifted into the low order positions
	 * 
	 * 212	 = 	  11010100
	 * 212 << 1 = 110101000    = 424
	 * 212 << 0 = 11010100     = 212
	 * 212 << 4 = 110101000000 = 3392 	 */

	static int leftShift(int num, int shift) {
		return num << shift;
	}

	/* Signed Right Shift is denoted by >>
	 * Shifts a bit pattern to the right
	 * If the number is a 2's complement signed number, the sign bit
	 * is shifted to the high order positions 	 */
	static int rightShift(int num, int shift) {
		return num >> shift;
	}

	static int unsignedRightShift (int num, int shift) {
		return num >>> shift;
	}

	// relational   > < >= <= instanceof
	static int relational(int a, int b) {
		String hi = "hi";
		if(hi instanceof String) {
			System.out.println("hi is a string");
		}

		return 0;
	}

	//equals
	public boolean equals (int a , int b) {
		if (a != b) return true;
		else return false;
	}

	/* Bitwise OR is a binary operator denoted by |
	 * It compares corresponding bits of two operands. If either of 
	 * the bits is 1, it gives 1. if not it gives 0. For example
	 * 
	 * 12 = 00001100	|
	 * 25 = 00011001
	 * 
	 * 		00011101 = 29  */

	static int bitwiseOR(int a, int b){
		return a | b;
	}


	static int bitwiseAND(int a, int b) {
		return a & b;
	}

	/* Short circuit operators 
	 * doesn't necessarily evaluate all of its operands
	 * https://users.drew.edu/bburd/JavaForDummies4/ShortCircuitEval.pdf
	 */
	public String shortCircuit(boolean first, boolean second) {
		if (first && second) { // if(x++ == 5 && y-- == x)
			return "if first is false, second is not evaluated because the "
			+ "statement cannot be true regardless of whether or not"
			+ "second is true";
		}
		else if (first || second) {
			return "if first is true, second is not evaluated because the OR "
					+ "will always be true regardless of the value of second";
		}
		else return null;
	}

	// TERNARY --> [expression] ? [if yes] : [if no]
	static String ternary(int x) {
		return (x > 10) ? (x < 200 ? "x less than 200" : " no " ): "x is less than 10"; 
	}


	public static void main(String[] args) {
		int x = 5;
		int y = 6;
		System.out.println(toBinary(-100)); //1100100
		System.out.println(toBinary(x>>2));//0011001
		System.out.println(toBinary(x<<2));//110010000
		System.out.println(toBinary(x>>>2));
		
		
		if(x++ == 5 && y-- == x) {
			System.out.println(x+ ", " + y);
		}
		else {
			System.out.println(false);
		}
		boolean value = true;
		String greeting = value ? "hi" : "bye";
		System.out.println(greeting);
	}
	
	
	static StringBuilder toBinary(int x) {
		String out = "";
		while(x>0) {
			out += x%2;
			x = x/2;
			}
		StringBuilder sb = new StringBuilder(out);
		
		return sb.reverse();
	}

}