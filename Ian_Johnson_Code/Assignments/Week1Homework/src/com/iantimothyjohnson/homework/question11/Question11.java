package com.iantimothyjohnson.homework.question11;

// We need to import our package for easy reference to Question11Floats.
import com.iantimothyjohnson.homework.question11.otherpackage.Question11Floats;

/**
 * Write a program that would access two float-variables from a class that
 * exists in another package. Note, you will need to create two packages to
 * demonstrate the solution.
 * 
 * @author Ian Johnson
 */
public class Question11 {
	public static void main(String[] args) {
		System.out.println("First float: " + Question11Floats.FLOAT1);
		System.out.println("Second float: " + Question11Floats.FLOAT2);
	}
}
