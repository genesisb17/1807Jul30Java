package com.revature.exception;

public class Exceptions {
	
	static void exploreStack(String[] args) {
		doThings(args);
		}
	static void doThings(String[] args) {
		System.out.println(args[5].toLowerCase());
	}
	
	public static void main(String[] args) {
		exploreStack(args);
	}
	

}
