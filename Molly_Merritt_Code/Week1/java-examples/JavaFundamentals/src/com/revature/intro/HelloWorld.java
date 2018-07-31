package com.revature.intro;

import java.util.ArrayList;

/* the first line of any Java class is the
 * package that it is in
 * 
 * following the package declaration is any
 * import statements or resources you may
 * need outside of this package
 */


// [access modifier] class [className] {}
public class HelloWorld {
	// the following is a javadocs comment
	/**@author Molly
	 * @since 7/30/2018
	 * @param args
	 */
	
	/*
	 * this is a multi-line comment
	 * 
	 * Access Modifiers!
	 * public - any class can access this entity
	 * protected - any class in this package OR its subclasses can access
	 * _ (default/package) - only accessible from package
	 * private - only accessible within the class
	 */
	
	// this is a comment
	
	// [access modifier] [non-access modifiers] [return type] [methodName](parameters){}
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		ArrayList<String> list = new java.util.ArrayList<String>();
		
		/* if we didn't import, it would have to look like this:
		 * java.util.ArrayList<String> list = new java.util.ArrayList<String>();
		 */
		
	}

}
