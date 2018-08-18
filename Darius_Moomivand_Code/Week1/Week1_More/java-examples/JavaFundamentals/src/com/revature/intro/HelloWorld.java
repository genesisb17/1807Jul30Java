package com.revature.intro;

import java.util.ArrayList;

/* the first line of any Java class is the 
 * package that it is in 
 * 
 * following the package declaration is any 
 * import statements for resources you may 
 * need outside of this package
*/

//[access modifier] [non-access modifiers] class [className] {}
public class HelloWorld {
	/*
	 * This is a multi-line comment
	 * Access Modifiers!
	 * public - any class can access this entity
	 * protected - any class in this package OR its subclasses can access
	 * __ (default/package) - only accessible from package
	 * private - only accessible within the class 
	 */

	// this is a comment
	
	
	//[access modifier] [non-access mods] [return type*] [methodName]([parameters]){}
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		ArrayList<String> list = new ArrayList<String>();
	}
}
