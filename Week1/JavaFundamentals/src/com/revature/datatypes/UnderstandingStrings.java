package com.revature.datatypes;

public class UnderstandingStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String a = "hello";
			String b = new String("hello");
			String c = new String();
			String d = "";
			
			System.out.println(c == d);
			System.out.println(a == b);
			System.out.println(c == null);
			System.out.println(d == "");
			System.out.println(c.equals(new String("")));
			
			String conc = a + b;
			conc = conc + 100;
			System.out.println(conc);
			
			conc = conc.concat("more things");
			System.out.println(conc);
			
			StringBuilder sbuild = new StringBuilder("hello");
			sbuild.append(" world!");
			System.out.println(sbuild);
			sbuild.reverse();
			System.out.println(sbuild);
	}

}
