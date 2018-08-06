package com.revature.designpatterns;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		s.name = "First instance";
		
		Singleton s2 = Singleton.getInstance();
		s2.name = "Second integer";
		
		System.out.println(s.name);
		System.out.println(s2.name);
		System.out.println(s == s2);
		
		s = null;
		s2 = null;
		Singleton s3 = Singleton.getInstance();
		System.out.println(s3.name);
		
		
		LazySingleton lazy = LazySingleton.getInstance();
		lazy.test();
		LazySingleton lazy2 = LazySingleton.getInstance();
		lazy2.test();
		
		
		
		//FACTORY DEMO
		/*
		 * Here, we will instantiate an object without
		 * exposing creation logic to the client. We 
		 * refer to the newly created object using a 
		 * common interface
		 */
		
		System.out.println("Hey Bob! What tool would you like to use?");
		Scanner scan = new Scanner(System.in);
		String tool = scan.nextLine();
		
		Tool t = ToolFactory.instantiate(tool);
		System.out.println(t == null? "Sorry! I don't have that tool" : t.work());
		
	}
}
