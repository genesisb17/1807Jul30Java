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

	public static void main(String[] args) {
		forLoop();
		forEach();
		whileLoop();
		doWhileLoop();
	}

}
