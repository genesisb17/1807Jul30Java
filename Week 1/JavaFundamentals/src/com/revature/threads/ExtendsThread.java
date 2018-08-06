package com.revature.threads;

public class ExtendsThread extends Thread{
	@Override
	public void run() {
		System.out.println("In extends thread");
		for(int i = 0; i < 300; i++) {
			System.out.println("ET: " + i);
		}	
	}
}
