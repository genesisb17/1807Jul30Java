package cjh.question11;

import cjh.question10.Minimum;

public class AccessPackage {
	/*
	 * Write a program that would access two float-variables from a class that exists in another package. Note, you will need 
	 * to create two packages to demonstrate the solution.
	 */
	
	public static float getMin() {
		return Minimum.getMinInt();
	}
	
	public static float getMax() {
		return Minimum.getMaxInt();
	}

}
