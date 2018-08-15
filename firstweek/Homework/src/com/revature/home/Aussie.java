package com.revature.home;

public class Aussie extends Dog {
	public void crazy() {
		System.out.println("I have so much energy and act crazy the first time i see you.");
	}
	public static void main(String[] args) {
		Aussie rex = new Aussie();
		rex.shitting();
		rex.living();
		rex.tailWagging();
		rex.eating();
		rex.liveBirth();
		
	}
	public void shitting() {
		System.out.println("My owners always pick up my shit");
		
	}
	
}
