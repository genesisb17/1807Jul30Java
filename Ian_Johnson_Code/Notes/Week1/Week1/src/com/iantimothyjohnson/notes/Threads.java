package com.iantimothyjohnson.notes;

@SuppressWarnings("unused")
public class Threads {
	// A thread is a single path of execution in your code. Multithreading means
	// having multiple flows of control in program execution: each thread gets
	// its own stack, and follows its own sequence of method calls with
	// associated variables.

	// There are two ways to make a thread: either extend the Thread class or
	// implement the Runnable interface. There are nuances associated with both
	// of these methods.

	// Types of threads:
	// - User threads: main() or any other explicitly requested processes
	// - Daemon threads: background processes, i.e. the garbage collector

	// Important methods:
	// isAlive() - checks if thread is active
	// join() - allows one thread to wait for the completion of another

	// The JVM terminates when no more user threads are active.

	// Synchronization: a method or statement is synchronized if only one thread
	// may access it at a time. Related topics include deadlocks, starvation and
	// the producer-consumer problem.

	// Threads have state. They are:

	// new - when the thread is new

	// runnable - when ready to run (may be running already or simply ready)

	// blocked (waiting state) - when a thread is temporarily inactive, due to
	// trying to access a protected section of code that is currently locked in
	// another thread

	// waiting - threads can be made to wait for other actions

	// timed waiting - can call a timed wait method in threads

	// terminated - a thread terminates either because it completes its task
	// naturally or because some unusual/exceptional event occurs

	// Here's an example of a thread that extends Thread:
	private static class ExtendsThread extends Thread {
		@Override
		public void run() {
			System.out.println("In ExtendsThread");
			for (int i = 0; i < 50; i++) {
				System.out.println("ET: " + i);
			}
		}
	}

	// Here's an example of a thread that implements Runnable:
	private static class ImplementsRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("In ImplementsRunnable");
			for (int i = 0; i < 50; i++) {
				System.out.println("IR: " + i);
			}
			try {
				System.out.println("I'm going to sleep.");
				Thread.sleep(10_000);
			} catch (InterruptedException e) {
				System.out.println("Hey, you woke me up!");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread irThread = new Thread(ir);

		System.out.println("State of ET thread: " + et.getState());
		et.start();
		// You can set the priority of a thread as a suggestion to the
		// scheduler.
		et.setPriority(Thread.MIN_PRIORITY);
		System.out.println("State of ET thread: " + et.getState());
		irThread.start();
		irThread.setPriority(Thread.MAX_PRIORITY);
		System.out.println("State of IR thread: " + irThread.getState());
		Thread.sleep(1000);
		irThread.interrupt();

		// Anonymous classes are useful in contexts like this:
		Runnable anon = new Runnable() {
			@Override
			public void run() {
				System.out.println("I'm anonymous!");
			}
		};

		// So are lambdas:
		Runnable anon2 = () -> {
			System.out.println("I'm a lambda!");
		};
	}
}
