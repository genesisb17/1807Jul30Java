package com.revature.substring;

public class Substring {

	public static void main(String[] args) {
		
		// Need to convert args[1] from a string to int
		int index = Integer.parseInt(args[1]);
		
		// Just prints out the results from 0 to the index
		// they don't want to print
		System.out.println(args[0].substring(0, index));
	}
}
