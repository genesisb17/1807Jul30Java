package com.iantimothyjohnson.notes.junit;

public class NotJUnit {
	public static void main(String[] args) {
		// Don't confuse jUnit assertions with Java assertions! The assert line
		// below will be ignored if assertions are not explicitly enabled, but
		// will throw an AssertionError if they are.
		assert args.length > 0 : "No arguments!";
		System.out.println("Assert worked.");
	}
}
