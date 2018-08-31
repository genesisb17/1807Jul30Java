package designpatterns;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Singleton s=Singleton.getInstance();
		s.name='first instance';
		
		Singleton s2=Singleton.getInstance
				
			*/	
	LazySingleton lazy=LazySingleton.getInstance();
	LazySingleton lazy2=LazySingleton.getInstance();
	
	
	System.out.println(" Hey Bob! what tool would you like");
	Scanner scan=new Scanner(System.in);
	String tool=scan.nextLine();
	
	Tool t=ToolFactory.instantiate(tool);
	System.out.println(t.work());
	
/*
 * Fatory Demo
 * 
 * Here we instantiate  an object without exposing creation object to the client
 * w refer to the newly created object using a common interface
 */
	}

}
