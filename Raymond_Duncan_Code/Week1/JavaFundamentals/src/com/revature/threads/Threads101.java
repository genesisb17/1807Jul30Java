package com.revature.threads;

public class Threads101 {
	/*
	 * Thread - a single path of execution in your code
	 * Multithreading - multiple flows of control in program execution
	 * 	- each thread gets its own stack and follows its own 
	 * 	  sequence of method calls with associated variables
	 * We create a separate thread of execution by either
	 * implementing the Runnable interface or by extending
	 * the thread class. There are nuances associated with both
	 * 
	 * Types of threads:
	 * 	- user - main() or any other explicitly requested processes
	 *  - daemon threads - background processes i.e. garbage collector
	 *  
	 *  isAlive() - checks if thread is active
	 *  join() - allows one thread to wait for the completion of another
	 *  
	 *  --> JVM terminates when no more user threads are active
	 *  
	 *  synchronization - a method or statement is synchronized of only one thread may access it at a time
	 *  
	 *  Threadsafe state. They are:
	 *  	New - thread is new
	 *  	Runnable - when ready to run(may be running or simply ready to run at any time)
	 *  	Blocked - AKA waiting state
	 *  		When an thread is temporarily inactive it is either blocked or waiting
	 *  		A thread is in the blocked state when it tries to access a protected section of code that is currently locked in another thread
	 *  	Waiting - threads can be made to wait for other actions
	 *  	Timed Waiting - can call a timed wait method in threads
	 *  	Terminated - a thread terminates because either it completes it's task naturally or because some unusual or exceptional event occurs
	 *  
	 *  Related topics: deadlock, starvation, producer-consumer problem
	 */
	
	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		
		ImplementsRunnable ir = new ImplementsRunnable();
		
		Thread isThread = new Thread(ir);
		
		for(int i = 0; i < 5; i++) {
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					Long threadID = Thread.currentThread().getId();
					for(int i = 0; i < 20; i++) {
						System.out.println("T" + threadID + "." + i + "\t");
					}
					
				}
				
			});
			t.run();
		}
		
		//LAMDAS!
		Runnable lambda = () ->{
			System.out.println("In lambda");
			for(int i = 0; i < 50; i++) {
				System.out.println("Lambda: " + i);
			}
		};
		
		Thread l = new Thread(lambda);
		isThread.setPriority(Thread.MAX_PRIORITY);
		l.setPriority(Thread.MIN_PRIORITY);
		l.start();
		System.out.println("STATE OF LAMBDA THREAD" + l.getState());
		et.run();
		ir.run();
		isThread.start();
		System.out.println("STATE OF LAMBDA THREAD" + l.getState());
		System.out.println("STATE OF ISTHREAD" + isThread.getState());
		
	}
}
