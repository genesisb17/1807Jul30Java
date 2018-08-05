package com.revature.test;

public class RobotTester {
		
		public static void main(String[] args) {
			
		Robot myRobo = new Robot();	
		
		int num = myRobo.getMaxSpeed();
		
		System.out.println(num);
		
		myRobo.setMaxSpeed(10);	
				
		myRobo.travel();
	}
}
