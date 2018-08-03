package com.iantimothyjohnson.homework.question15;

/**
 * Write a program that defines an interface having the following methods:
 * addition, subtraction, multiplication, and division. Create a class that
 * implements this interface and provides appropriate functionality to carry out
 * the required operations. Hard code two operands in a test class having a main
 * method that calls the implementing class.
 * 
 * @author Ian Johnson
 */
public class Question15 {
	public static final double ARG1 = 5.0;
	public static final double ARG2 = 2.0;
	
	public static void main(String[] args) {
		// We simply make a new instance of our DoubleCalculator and use it to
		// operate on the two arguments above.
		DoubleCalculator calc = new DoubleCalculator();
		System.out.println(ARG1 + " + " + ARG2 + " = " + calc.add(ARG1, ARG2));
		System.out.println(ARG1 + " - " + ARG2 + " = " + calc.subtract(ARG1, ARG2));
		System.out.println(ARG1 + " * " + ARG2 + " = " + calc.multiply(ARG1, ARG2));
		System.out.println(ARG1 + " / " + ARG2 + " = " + calc.divide(ARG1, ARG2));
	}
}
