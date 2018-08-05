package com.revature.test;

public class Robot {

	private int maxSpeed;

	public Robot() {
		this.maxSpeed = 5;
	}
	
	public Robot(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		if (maxSpeed >= 0)
			this.maxSpeed = maxSpeed;
		else
			this.maxSpeed = 0;
	}
	
	public void travel() {
		System.out.println("The robot moves a distance of " + maxSpeed + " units.");
	}
}
