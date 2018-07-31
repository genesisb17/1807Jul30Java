package com.revature.classbasics;

public class Controls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int [] arr = { 8, 7, 6, 5, 4, 3, 2, 1};
		boolean y = true;
		
		do {
			for(int i = 0; i < x; i++) {
				x--;
				System.out.println(x);
			}
		}while (x > 0);
		
		while(y == true) {
			for(int i : arr) {
				if(i == 5) {
					System.out.println(" WE GOT A FIVE!!!");
				} else if(i == 4) {
					System.out.println("WE GOT A FOUR!!");
					y = false;
				} else {
					System.out.println(i);
				}
			}
			
		}
		
		int z = 3;
		String name = "c";
		
		// onlystrings char int short byte enums can be used
		switch(z){
			case 1: name = "Keth";
					break;
			case 2: name = "John";
					break;
			case 3: name = "Amy";
					break;
		}
		
		System.out.print(name);
		
		
		

	}

}
