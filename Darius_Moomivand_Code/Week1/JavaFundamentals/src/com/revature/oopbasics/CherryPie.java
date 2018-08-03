package com.revature.oopbasics;

public class CherryPie extends Pie implements Crust {
	CherryPie(){
	temp = "cold";
	filling = "cherry";
	crust = "crunchy";
	}
	
	public void typeCrust(){
		System.out.println("This type of crust is " + crust);
	}

	public void serve() {
		System.out.println("You have a slice of pie!");
		slicesLeft--;
		System.out.println("There are " + slicesLeft + " slices of pie left!" );
	}

}
