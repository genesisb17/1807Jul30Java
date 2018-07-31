package com.revature.intro;

public class ControlStructures {
	
	private static String slist[] = {"Never", "Gonna", "Give", "You", "Up", ":)"};
	
	public static void forLoop() {
		System.out.println("For Loop");
		for(int i = 0; i < slist.length; i++) {
			System.out.println(slist[i]);
		}
	}
	
	public static void forEach() {
		System.out.println("For-Each/Enchanced For Loop");
		for(String s: slist) {
			System.out.println(s);
		}
	}
	
	public static void whileLoop() {
		System.out.println("While Loop");
		int count = 0;
		while(count < 50) {
			count += slist[(int)(Math.random() * slist.length)].length();
			// NOTE: This is not the same string used for the count.
			System.out.println(slist[(int)(Math.random() * slist.length)]);
		}
	}
	
	public static void doWhileLoop() {
		System.out.println("Do-While Loop");
		String s;
		do {
			s = slist[(int)(Math.random() * slist.length)];
			System.out.println(s);
		} while(!s.equals(":)"));
	}
	
	public static void ifElseIfElse(int num) {
		// what kind of method name is that???
		if(num >= 50) {
			System.out.println("Big number!");
		} else if (num >= 25) {
			System.out.println("Sort-of big number.");
		} else {
			System.out.println("An ant could lift that much...");
		}
	}
	
	public static void switchCase(String s) {
		switch (s) {
			case "Kevin":
				System.out.println("Kevin is cool.");
				break;
			case "Genesis":
				System.out.println("Genesis is awesome!");
				break;
			case "William":
				System.out.println("William is also awesome!");
				break;
			default:
				System.out.println("What? Who?");
		}
				
	}
	
	public static int notFactorial(int in) {
		// you think it does the factorial, but it does something weird.
		if(in < 1) {
			return 1;
		}
		
		return in * notFactorial((int)(Math.random() * (in - 1)));
	}
	

	public static void main(String[] args) {
		forLoop();
		forEach();
		whileLoop();
		doWhileLoop();
		ifElseIfElse(24);
		ifElseIfElse(100);
		ifElseIfElse(5);
		switchCase("Genesis");
		switchCase("Jake from Statefarm");
		System.out.println(notFactorial(1));
		System.out.println(notFactorial(10));
		
		
	}

}
