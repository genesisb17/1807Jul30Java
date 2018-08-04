package designpatterns;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		//Singleton
		Singleton s = Singleton.getInstance();
		s.name = "first instance";
		
		Singleton s2 = Singleton.getInstance();
		
		s2.name = "second instance";
		
		System.out.println(s.name);
		System.out.println(s2.name);
		
		System.out.println(s == s2);

		LazySingleton lazy = LazySingleton.getInstance();
		
		//FACTORY DEMO
		/*
		 * here, we will instantiate an object w/o exposing creation logic to the client.
		 * we refer to the newly created object using a common interface
		 * 
		 */
		System.out.println("Hey, Bob! What tool would you like to use?");
		Scanner scan = new Scanner(System.in);
		String tool = scan.nextLine();
		
		Tool t = ToolFactory.instantiate(tool);
		System.out.println(t.work());
	}

}
