package com.revature.designpatterns;

import java.util.Scanner;

import javax.tools.Tool;

public class Driver {

	public static void main(String[] args) {
		/*Singleton s = Singleton.getInstance();
		s.name = "first instance";
		
		Singleton s2 = Singleton.getInstance();
		s2.name = "second 'instance'";
		
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
		
		Singleton.test();
		LazySingleton.test();
		*/
		
		//FACTORY DEMO
		/*
		 * Here, we will instantiate an object without
		 * exposing creation logic to the client. We
		 * refer to the newly created object using 
		 * a common interface
		 */
		
		System.out.println("Hey Bob! What toold would you like to build with?\n");
		Scanner scan = new Scanner(System.in);
		String tool = scan.nextLine();
		
		Tools t = ToolFactory.instantiate(tool);
		System.out.println(t.work());
		System.out.println(t.getClass());
		
	}

}
