package com.revature.threads;

public class ImplementsRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("In Extends Thread");
		for (int i = 0 ; i < 50 ; i++) {
			System.out.println("IR: " + i);
		}
	}
}
