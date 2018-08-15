package com.revature.intro;

public abstract class Animal implements Livable {
//private int x = 5; does not allow me to use this variable in another class since private
	public int x = 5;

	 public void breathe() {
		 System.out.println("breathing" + helperMethod());
	 }
	 
	 public void consume() {
		 System.out.println("animals eat stuff" + helperMethod());
	 }
	 
	 private static int helperMethod() {
		 return 0;
	 }
}
