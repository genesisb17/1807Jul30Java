package com.revature.threads;

public class ExtendsThread extends Thread {
	@Override
	public void run() {
		System.out.println("In ExtendsThread");
		for(int i = 0; i< 100; i++) {
			System.out.println("ET " + currentThread().getId() + ":\t" + i);
		}
	}
	
}
