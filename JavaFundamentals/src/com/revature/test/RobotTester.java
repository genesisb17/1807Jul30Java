package com.revature.test;

public class RobotTester {
		
	public static void main(String[] args) {
		
		Robot myRobo = new Robot();	
		
		int num = myRobo.getMaxSpeed();
		
		System.out.println(num);
		
		Robot yourRobo = new Robot(6);
		
		int x = yourRobo.getMaxSpeed();
		
		System.out.println(x);
		
		myRobo.setMaxSpeed(10);	
				
		myRobo.travel();
	}
}