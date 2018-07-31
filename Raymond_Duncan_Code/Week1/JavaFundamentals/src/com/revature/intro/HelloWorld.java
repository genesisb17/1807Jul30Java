package com.revature.intro;

import java.util.ArrayList;

/*
 * the first line of any Java class is the 
 * package that it is in
 * 
 * following the package declaration is nay
 * import statements for resources you may
 * need outside of this package
 */

//[access modifier] [non-access modifiers] class [className] {}
public class HelloWorld {
	//The following is used for javadocs
	/**@author Raymond
	 * @since 7/30/18
	 * 
	 * @param args
	 */
	
	/*
	 * Access Modifiers:
	 * public - any class can access this entity
	 * protected - any class in this package OR its subclasses can access
	 * _ (no access modifier. default/package) - only accessible from this package
	 * private - only accessible within the class
	 */
	
	//[access mod] [non-access mod] [return type*] [method name]([params]){}
	public static void main(String[] args) {
		System.out.println("Hello world!");
		
		ArrayList<String> list = new ArrayList<String>();
	}
	
}
