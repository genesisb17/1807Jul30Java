package com.revature.intro;

public class UnderstandingArrays {
	
	public void loops(int n) {
		int i = 0;
		for (; i <= n; i++) {
			System.out.println(i);
		}
	}
	
	public void enhancedFor(int...n) {
		
		for(int num : n) {
			System.out.println(num);
		}
	}
	
	
	public void whileLoop(int n) {
		
		int x = 0;
		while(x < n) {
			x= x+1;
		System.out.println(x);
		}
		
	}
	
	public void doWhile(int n) {
		int i = 0;
		do {
			System.out.println(i);
			i++;
		} while(i<=n);
	}
	
	public void ifStatements(int n) {
		if (n <= 0) {
			System.out.println("your number was negative");
		} else if (n>=0) {
			System.out.println("your number is positive");
		} else {
			System.out.println("you did not supply a number");
		}
	}
	
	public void switchStatements(int n) {
		switch (n) {
		case 1 :
			System.out.println("the number was one");
		case 5 :
			System.out.println("you entered 5");
		}
	}
	
	public static void main(String[] args) {
		UnderstandingArrays ua = new UnderstandingArrays();
		ua.loops(100); 
		ua.enhancedFor(12,13,14);
		ua.whileLoop(10);
		ua.doWhile(10);
		ua.ifStatements(-5);
		ua.switchStatements(5);
	}
}