package com.revature.datatypes;

public class UnderstandingStrings {

	public static void main(String[] args) {
		String a = "hello";
		String b = new String("Hello");
		String c = new String();
		
		System.out.println(a == b);
		System.out.println(c == null);
		System.out.println(c == "");
		System.out.println(c.equals(new String("")));
		
		String conc = a + b;
		conc = conc + 100;
		System.out.println(conc);
		
		conc.concat("more things");
		System.out.println(conc);
		
		StringBuilder sbuild = new StringBuilder("hello");
		sbuild.append(" world!");
		System.out.println(sbuild);
	}
}
