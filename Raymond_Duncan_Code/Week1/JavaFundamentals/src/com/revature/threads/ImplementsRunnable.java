package com.revature.threads;

public class ImplementsRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i< 100; i++) {
			System.out.println("ET " + Thread.currentThread().getId() + ":\t" + i);
		}
	}

}
