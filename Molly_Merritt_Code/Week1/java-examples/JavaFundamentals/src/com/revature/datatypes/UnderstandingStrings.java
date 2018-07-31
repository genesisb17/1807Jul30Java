package com.revature.datatypes;

public class UnderstandingStrings {

	public static void main(String[] args) {
		String a = "hello";
		String b = new String("hello");
		String c = new String();
		String d = "";
		
		System.out.println(a == b);	//false
		System.out.println(c == null);	//false
		System.out.println(c == "");	//false
		System.out.println(c.equals(new String("")));	//true
		System.out.println(d == "");	//true
		
		String conc = a + b;	//concatenate without using the concat method
		conc = conc + 100;	//we can add numbers (don't need to convert to string)
		System.out.println(conc);
		
		conc.concat("more things");	//this doesn't do anything bc we didn't
									//assign it to anything
		
		StringBuilder sbuild = new StringBuilder("hello");
		sbuild.append(" world!");	//this assigns the appended value to sbuild
		System.out.println(sbuild);
		sbuild.reverse();
		System.out.println(sbuild);
		
		StringBuffer sbuff = new StringBuffer(conc);
		// can't do this:
		// Stringbuffer test = "asdfghjkl;"

	}

}
