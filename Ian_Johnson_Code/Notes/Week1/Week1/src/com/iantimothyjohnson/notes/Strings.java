package com.iantimothyjohnson.notes;

public class Strings {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// A string is just a series of characters (text).
		String str = "hello";
		// Java conserves memory by using a "string pool" on the heap. The new
		// keyword always creates a new object, so the following will not be in
		// the string pool:
		String outside = new String("hello");
		String inside = "hello";
		System.out.println("Am I right? " + (str != outside));
		System.out.println("String pool works? " + (str == inside));
		
		// Interaction with garbage collection:
		String a = "hello";
		String b = null;
		String c = a;
		assert a == c;
		String d = "bye";
		d = a; // Now, the old value of d is eligible for garbage collection.
		
		// The String class is final; it cannot be extended. Strings are also
		// immutable, but this has nothing to do with the String class being
		// final.
		
		// Side note on final keyword:
		// On class: cannot be extended.
		// On method: cannot be overridden, but CAN be overloaded.
		// On variable: cannot be changed once initialized.
		
		// When you need a mutable String, use StringBuilder or StringBuffer.
		// StringBuilder is faster, but StringBuffer is thread-safe.
		StringBuilder sb = new StringBuilder("hello");
		sb.reverse();
		System.out.println(sb);
		
		// You can concatenate strings:
		String test = "hi".concat("bye");
		// Or get substrings:
		System.out.println(test.substring(2)); // Outputs "bye".
	}
}
