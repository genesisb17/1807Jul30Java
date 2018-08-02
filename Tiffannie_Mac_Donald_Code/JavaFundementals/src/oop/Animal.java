package oop;

//access mod / non-access mods / class / className
public abstract class Animal implements Livable{
	 /*
	 * abstract classes have the ability to have abstract methods (unimplemented
	 * methods)
	 * they do NOT need to have an abstract method to be abstract. they just
	 * have the ability to
	 */

	public void consume() {
		System.out.println("Animals eat things to consume");
	}
	
	private static int helperMethod() {
		return 0;
	}
}
