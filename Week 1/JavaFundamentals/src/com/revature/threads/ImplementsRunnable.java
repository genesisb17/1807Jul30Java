package com.revature.threads;

public class ImplementsRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("ImplementsRunnable");
		for(int i = 0; i < 300; i++) {
			System.out.println("IR: " + i);
		}
	}
}
