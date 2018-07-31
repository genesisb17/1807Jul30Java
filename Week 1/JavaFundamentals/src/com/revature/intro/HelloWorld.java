package com.revature.intro;
import java.util.ArrayList;
/*the first line of any Java class is the
 * package that it is in
 * 
 * following the package declaration is any
 * important statements for resources you may
 * need outside of this package
 */

//[access modifier] [non-access modifiers] class [className] {}
public class HelloWorld {

	/**
	 * This is a multi-line comment
	 * Access Modifiers!
	 * public - any class can access this entity
	 * can put in front of class, variable, and methods
	 * 
	 * protected - any class in this package OR its subclasses can
	 * access 
	 * 
	 * __ (default/package access) - only accessible from classes in the package
	 * 
	 * private - only accessible within the class
	 * INTERVIEW Q: Can a class be private? If we have a class (subclass) within a class, then 
	 * a private class is possible.
	 * 
	 */
	
	//[access modifier] [non-access mods] [return type*] [methodName]([parameters])
	public static void main(String[] args) {
		System.out.print("Hello World");
		ArrayList<String> list = new ArrayList<String>();
	}
	
}
