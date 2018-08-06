package com.revature.designpatterns;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		s.name = "first instance";
		
		Singleton s2 = Singleton.getInstance();
		s2.name = "second instance";
		
		System.out.println(s.name);
		System.out.println(s2.name);
		// this prints out the same thing b/c there's only one instance
		
		System.out.println(s == s2);
		// true because s and s2 are different references to the same object
		
		s = null;
		s2 = null;
		Singleton s3 = Singleton.getInstance();
		System.out.println(s3.name);
		// this will print "second instance" because you made the reference null
			// but not the object
		
		LazySingleton lazy = LazySingleton.getInstance();
		lazy.test();
		LazySingleton lazy2 = LazySingleton.getInstance();
		
		
		// FACTORY DEMO
		/*
		 * Here, we will instantiate an object without exposing creation logic
		 * to the client. We refer to the newly created object using a common
		 * interface.
		 */
		
		System.out.println("Hey Bob! What tool would you like to build with?");
		Scanner scan = new Scanner(System.in);
		String tool = scan.nextLine();
		
		Tool t = ToolFactory.instantiate(tool);
		System.out.println(t.work());
	}

}
