package com.revature.threads;

public class Threads101 {
	
	/*
	 * Thread - a single path of execution in your code
	 * Multithreading - multiple flows of control in program execution
	 * - each thread gets its own stack and follows its own 
	 * - sequence of method calls with associated variables
	 * We create a separate thread of execution by either
	 * - implementing the Runnable interface or by extending
	 * - the thread class. There are nuances associated with both
	 * 
	 * Types of Threads:
	 * - user - main() or any other explicitly requested processes
	 * - deamon threads - background processes i.e. garbage collection
	 * 
	 * isAlive() - checks if thread is active
	 * join() - allows one thread to wait for the completion of another
	 * 
	 * --> JVM terminates when no more user threads are active
	 * 
	 * synchronization - a method or statement is synchronized if
	 * only one thread may access it at a time
	 * 
	 * Threads have state, they are
	 * New - Thread is new
	 * Runnable - When ready to run (may be running or simply
	 * 		ready to run at any time)
	 * Blocked - a.k.a waiting state
	 * 		when a thread is temporarily inactive it is either
	 * 		blocked or waiting
	 * 		A thread is in a blocked state when it tries to
	 * 		access a protected section of code that is currently locked in another thread
	 * Waiting - threads can be made to wait for other actions
	 * Timed Waiting - can call a timed wait method in threads
	 * Terminated - a thread terminate because either it
	 * 		completes its task naturally or because some unusual or exception event occurs	
	 * 
	 * Related topics: deadlock, starvation, producer-consumer problem
	 * 
	 */

	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);
		
		Runnable anonymous = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("in anon class implementation");
				for( int i = 0 ; i < 50 ; i++) {
					System.out.println("ANON: " + i);
				}
			}
		};
		
		Thread anonThread = new Thread(anonymous);
		
		Runnable lamdba = () -> {
			System.out.println("In LAMBDA");
			for (int i = 0 ; i < 50 ; i++) {
				System.out.println("Lambda: " + i);
			};
		
		Thread l = new Thread(lamdba);
		isThread.setPriority(Thread.MAX_PRIORITY);
		l.setPriority(Thread.MIN_PRIORITY);
		l.start();
		System.out.println("State of LAMBDA THREAD" + l.getState());
		anonThread.start();
		et.run();
		isThread.start();
		System.out.println("State of LAMBDA THREAD" + l.getState());
		System.out.println("State of IR THREAD" + isThread.getState());
		};
	
	}
}
