package threads;

public class Threads101 {
/*
 * Thread - a single path of execution in your code
 * multithreading - multiple flows of control in program execution
 * - each thread gets its own stack and follows its own sequence of method calls with 
 * associated variables
 * we create a separate thread of execution by either implementing the runnable interface
 * or by extending the thread class. There are nuances associated w both
 * 
 * Types of threads:
 * - uer- main() or any other explicitly requested processes
 * - daemon threads - background processes ie garbage collector
 * 
 * isAlive() checks if thread is active
 * join()- allows one thread to wait for the completion of another
 * 
 * --> JVM terminates when no more user threads are active
 * 
 * Thread safe is better worded as synchronization which is when a method or statement
 * is syncgronized if only one thread may access it at a time
 * 
 * Threads have state. they are;
 * 	New- thread is new
 * 	Runnable - when threads are ready to run(may be running or simply ready 2 run at
 * 				any time
 * 	Blocked - aka waiting state
 * 			when a thread is temporarily inactive it is either blocked or waiting
 * 			A thread is in the blocked state when it tries to access a protected section of code this is currently
 * 			licked in another thread
 * Waiting - threads can be made to wait for other actions
 * Timed waiting - can call a timed wait method in threads
 * Terminated - a thread terminate because either it completes its task naturally of because
 * 			some unusual or exceptional event occurs.
 * 
 * 
 * Related topics: deadlock, starvation, producer-consumer problem
 */
	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		
		
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);
		
		
		Runnable anonymous = new Runnable() {
			@Override
			public void run() {
				System.out.println("in anon class implementatio");
				for(int i = 0; i< 50; i++) {
					System.out.println("Anon: " + i);
				}
			}
		};
		
		Thread anonThread = new Thread(anonymous);
		
		//LAMBDAAASSSSSSSSSSSSSSSSSSSSSSSSSS
		//can be only used with functional interfaces
		Runnable lambda = () ->{
			//you know you're overriding run() bc it's the only method to override
			System.out.println("in Lambda");
			for(int i = 0; i< 50; i++) {
				System.out.println("Lambda: " + i);
			}
		};
		
		Thread l = new Thread(lambda);
		isThread.setPriority(Thread.MAX_PRIORITY);
		l.setPriority(Thread.MIN_PRIORITY);
		
		l.start();
		System.out.println("STATE of lambda thread" + l.getState());
		anonThread.start();
		et.start();
		isThread.start();
		//System.out.println("STATE of lambda thread" + l.getState());
		System.out.println("STATE of anon thread" + anonThread.getState());
		System.out.println("STATE of ir thread" + isThread.getState());
	}
	
}
