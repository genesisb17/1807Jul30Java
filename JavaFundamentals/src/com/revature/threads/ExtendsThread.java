package com.revature.threads;

public class ExtendsThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("In Extends Thread");
		for (int i = 0 ; i < 50 ; i++) {
			System.out.println("ET: " + i);
		}
	}
}
