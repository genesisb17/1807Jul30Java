package com.revature.threads;

public class Threads101 {
	/*
	 * Thread - a single path of execution in your code 
	 * Multithreading - multiple flows of control in program execution
	 *  - each thread gets its own stack and follows its own sequence
	 *    of methods calls with associated variables
	 *  We create a separate thread of execution (essentially a series 
	 *  of things that happen in a sequential order) by either implementing the 
	 *  Runnable interface or by extending the thread class. There are 
	 *  nuances associated with both.
	 *  
	 *  Types of threads: 
	 *   - user - main() or any other explicitly requested processes
	 *   - daemon threads - background processes ie garbage collector
	 *   
	 *   isAlive() - checks if thread is active
	 *   join() -  allows one thread to wait for the completion of another
	 *   
	 *   --> JVM terminates when no more user threads are active
	 *   
	 *   synchronization - a method or statement is synchronized if only
	 *   one thread may access it at a time
	 *   
	 *   Threads have state. They are:
	 *     New - thread is new
	 *     Runnable - when ready to run (may be running or ready to run at any time)
	 *     Blocked - aka waiting state, when a thread is temporarily inactive it is
	 *      either blocked or waiting. A thread is in the block state when it tries to 
	 *      access a protected section of code that is currently locked in another thread.
	 *     Waiting - threads can be made to wait for other actions
	 *     Timed Waiting - can call a timed wait method in threads
	 *     Terminated - a thread can terminate because either it completes its task 
	 *      naturally or because some unusual or exceptional event occurs
	 *   
	 *   Related topics: deadlock, starvation, producer-consumer problem
	 */
	
	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();

		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);
		
		
		Runnable anon = new Runnable() {//Defining an interface within the class. Creating a class that implements and instantiates at the same time.

			@Override
			public void run() {
				
				System.out.println("In anon class implementation");
				for(int i = 0; i < 50; i++) {
					System.out.println("Anon: " + i);
					
				}
			}
		};
		
		Thread anonThread = new Thread(anon);
		
		//anonThread.start();
		//et.start();//run(); using run with et.run() and ir.run() just does them each on order once
		//isThread.start();
		//There are 4 threads. The program's main thread, the et thread, etc. for each .start()
		//It's multithreading because we are not waiting for 1 to finish
		
		//LAMBDA EXPRESSIONS - Can only be used with functional interfaces. Anons can be used with any
		Runnable lambda = () -> {
			System.out.println("In Lambda");
			for(int i = 0; i < 50; i++) {
				System.out.println("Lambda: " + i);
			}
		};
		
		Thread lamb = new Thread(lambda);
		
		isThread.setPriority(Thread.MAX_PRIORITY);
		lamb.setPriority(Thread.MIN_PRIORITY);
		lamb.start();
		System.out.println("State of Lambda Thread: " + lamb.getState());
		anonThread.start();
		et.start();
		isThread.start();
		System.out.println("State of Lambda Thread: " + lamb.getState());
		System.out.println("State of IR Thread: " + isThread.getState());
	}
}
