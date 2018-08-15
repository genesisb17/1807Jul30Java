package com.revature.home;

public class Whale extends Mammal{
	
	public void swimming() {
		System.out.println("I swim deep in the ocean");
	}
	
	public static void whatILookLike() {
		System.out.println("This is what i look like(whale)");
	}
	
	public static void main(String[] args) {
		Living freeWilly = new Whale();
		((Whale) freeWilly).swimming();
		Mammal a = new Whale();
		a.whatILookLike();
}	
}
