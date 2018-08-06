package com.revature.threads;

public class Threads101 {
	/*
	 * Thread - a single path of execution in your code
	 * Multithreading - multiple flows of control in program execution
	 *  - each thread gets its own stack and follows its own sequence
	 *    of method calls with associated variables
	 * We create a separate thread of execution by either implementing
	 *  the Runnable interface or by extending the thread class. There
	 *  are nuances associated with both
	 *  
	 * There are various types of threads:
	 *  - user - main() or any other explicitly requested processes
	 *  - daemon threads - background processes, i.e. garbage collector
	 * 
	 * isAlive() - checks if thread is active
	 * join() - allows one thread to wait for the completion of another
	 * 
	 * --> JVM terminates when no more user threads are active
	 * 
	 * Synchronization - a method or statement is synchronized if only
	 * 	one thread may access it at a time
	 * 
	 * Threads have state. They are:
	 * 	New - thread is new
	 * 	Runnable - when ready to run (may be running or simply ready to
	 * 		run at any time
	 * 	Blocked - (aka waiting state) when a thread is temporarily
	 * 		inactive, it is either blocked or waiting. A thread is in
	 * 		the blocked state when it tries to access a protected section
	 * 		of code that is currently locked in another thread
	 * 	Waiting - threads can be made to wait for other actions
	 * 	Time Waiting - we can call a timed wait method in threads
	 * 	Terminated - a thread can terminate beacause either it completes,
	 * 		it is task naturally, or because some unusual or exceptional
	 * 		event occurs (like an unhandled exception)
	 * 
	 * Related topics: deadlock, starvation, producer-consumer problem
	 */
	
	public static void main(String[] args) {	// main method is one thread of execution
		ExtendsThread et = new ExtendsThread();
//		et.start();	// moves this out of the main method thread
		
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);
//		isThread.start();
		
		Runnable anonymous = new Runnable() {	
			// creating a class that immplements Runnable right in the main method
			// we're only going to use it here, so why create a separate class?
			// this is a class that implements Runnable
			// we didn't name the class, we just named the instance ("anonymous")
			
			public void run() {
				System.out.println("in anon class implementation");
				for (int i=0; i<50; i++) {
					System.out.println("ANON: " + i);
				}
			}
		};	// end of anon class
		
		Thread anonThread = new Thread(anonymous);
		
		// LAMBDASSSSSSSS
		Runnable lambda = () -> {
			// we know we're overriding run() b/c it's the only method
			System.out.println("In LAMBDA");
			for(int i=0; i<50; i++) {
				System.out.println("Lambda: " + i);
			}
		};
		
		Thread l = new Thread(lambda);
		isThread.setPriority(Thread.MAX_PRIORITY);
		l.setPriority(Thread.MIN_PRIORITY);
		l.start();
		System.out.println("STATE OF LAMBDA THREAD: " + l.getState());
		anonThread.start();
		et.start();
		isThread.start();
		System.out.println("STATE OF LAMBDA THREAD: " + l.getState());
		System.out.println("STATE OF IR THREAD: " + isThread.getState());
	}

}
