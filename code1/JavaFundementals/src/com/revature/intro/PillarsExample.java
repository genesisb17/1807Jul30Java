package com.revature.intro;

public class PillarsExample {

	static String name = "Dylan";

	public void polymorphismOverload(int a) {
		System.out.println(a);
	}

	public void polymorphismOverload(String name) {
		System.out.println(name);
	}

	public void drives(String name) {
		System.out.println("Driving");
	}

	public static void main(String[] args) {
		PillarsExample pe = new PillarsExample();
		pe.polymorphismOverload(10);
		pe.polymorphismOverload("Dylan");
	}

}
