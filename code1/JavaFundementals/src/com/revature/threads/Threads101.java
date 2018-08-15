package com.revature.threads;

public class Threads101 {
	
	/* a thread is a single path of execution
	 * multithreading allows multiple control flow in the program execution
	 */
	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		et.start();
		ImplementsRunable ir = new ImplementsRunable();
		Thread isThread = new Thread(ir);
		isThread.start();
		et.start();
		
		
		Runnable anonymous = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		
	}
}
