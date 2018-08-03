package com.revature.oopbasics;

public abstract class Pie {
	int slicesLeft = 8;
	String temp;
	String filling;
	String crust;
	
	public abstract void serve();
	
	public static void main(String[] args) {
		CherryPie myPie = new CherryPie();
		myPie.typeCrust();
		myPie.serve();
		myPie.serve();

	}
}
