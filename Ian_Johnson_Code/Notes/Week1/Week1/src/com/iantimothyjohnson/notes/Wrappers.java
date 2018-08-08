package com.iantimothyjohnson.notes;

public class Wrappers {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		int five = Integer.parseInt("5");
		
		Integer i = new Integer(80);
		int eighty = i; // unboxing
		
		int x = 10;
		Integer wrapped = x; // autoboxing
	}
}
