package com.revature.classbasics;

public class ControlStructure {

	public static void main(String[] args) {
		
		//for loop exmaple
		for(int i = 0; i < 5; i++)
		{
			System.out.println("i: " + i);
		}
		
		System.out.println("\n");
		
		//practicing arrays
		int[] practiceA =  new int[4];
		practiceA[0] = 1;
		practiceA[1] = 2;
		practiceA[2] = 3;
		practiceA[3] = 4;
		
		//for each example
		for(int n:practiceA) {
			System.out.println("practice: " + n);
		}
		
		//while loop example
		int j = 0;
		System.out.println("\nThis is the size of practiceA: ");
		while(j < practiceA.length) {
			j++;
		}
		System.out.println(j);
		
		//do-while loop example
		System.out.println("\nHumbling j in... ");
		do {
			System.out.println(j);
			j--;
		}while(j > 0);
		System.out.println("sit down.\n");
		
		//if example
		if(j == 0) {
			System.out.println("Advice of the day: \nThere is no substitute for hard"
					+ " work");
		}
		
		//if else-if example
		if(j != 0) {
			System.out.println("\nBaby groot is really the reincarnation"
					+ " of groot." + "\n...meaning the original one past away"
					+ " to save StarLord.\n");
		} else if(j == 0){
			System.out.println("\nEveryone was wondering what Captain America\n" 
					+ "would do against Thanos." +" Not much, except vigourously\n"
					+ "attempted to pull off his gauntlet :'(");
		}
		
		//switch example
		switch(j) {
		case 0:
			System.out.println("\nLet's level j up for being 0 up until now!");
			++j;
			System.out.println("\nj is now: " + j);
			System.out.println("\nGood job j! \nyou deserved it buddy.");
			break;
		case 1:
			System.out.println("Not going to happen in this code.");
		
		}

	}

}
