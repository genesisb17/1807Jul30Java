package com.revature.threads;

public class ImplementsRunable implements Runnable {
	public void run() {
		System.out.println("In implementsrunable");
		for(int i = 0; i<100;i++) {
			System.out.println("IR: " + i);
		}
	}

}
