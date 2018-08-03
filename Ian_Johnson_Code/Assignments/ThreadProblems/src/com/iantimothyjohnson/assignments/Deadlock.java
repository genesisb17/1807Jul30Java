package com.iantimothyjohnson.assignments;

public class Deadlock {
	// Here are two "resources" for the thread to use.
	private static Object resource1 = new Object();
	private static Object resource2 = new Object();

	public static void main(String[] args) throws InterruptedException {
		// Here's an example of how a thread might deadlock:
		Runnable r1 = () -> {
			// Start using resource1:
			synchronized (resource1) {
				System.out.println("r1 is using resource1");
				// Take some time...
				delay();
				// Start using resource2:
				synchronized (resource2) {
					System.out.println("r1 is using resource2");
					delay();
				}
			}
		};

		Runnable r2 = () -> {
			// Start using resource2:
			synchronized (resource2) {
				System.out.println("r2 is using resource2");
				// Take some time...
				delay();
				// Start using resource1:
				synchronized (resource1) {
					System.out.println("r2 is using resource1");
					delay();
				}
			}
		};

		// Spawn our two threads:
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();
		// Wait for our threads to finish, which will never happen, because
		// there is a deadlock. Since r1 gobbles up resource1 and refuses to let
		// go until it gets resource2 as well, and r2 does the same but in
		// reverse order, r1 will never be able to use resource2, and thus it
		// will never release resource1 (preventing r2 from using resource1).
		t1.join();
		System.out.println("t1 finished");
		t2.join();
		System.out.println("t2 finished");
	}
	
	/**
	 * Delay the current thread for a second.
	 */
	private static void delay() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
