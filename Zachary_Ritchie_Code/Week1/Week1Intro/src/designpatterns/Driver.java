package designpatterns;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args)
	{
		//FACTORY DEMO
		
		System.out.println("Hey bob! What tool would you like");
		Scanner scan = new Scanner(System.in);
		String tool = scan.nextLine();
		
		Tool t = ToolFactory.instatiate(tool);
		System.out.println(t.work());
		System.out.println(t.getClass());
	}

}
