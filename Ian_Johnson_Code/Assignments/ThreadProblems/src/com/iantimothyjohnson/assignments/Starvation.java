package com.iantimothyjohnson.assignments;

public class Starvation {
	private static class Lasaga {
		public synchronized void provideNourishment(int amount) {
			try {
				Thread.sleep(amount);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * The only lasaga in the whole world.
	 */
	private static final Lasaga lasaga = new Lasaga();

	private static class Garfielf implements Runnable {
		private int id;

		public Garfielf(int id) {
			this.id = id;
		}

		@Override
		public void run() {
			for (;;) {
				// Enough with the chit-chat, let's get some grub going.
				// Garfielf is very greedy and constantly wants lots of food.
				lasaga.provideNourishment(1000);
				System.out.println("Garfelo " + id + " ate those food.");
			}
		}
	}

	public static void main(String[] args) {
		// Let's create 10 high-priority Garfielfs.
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new Garfielf(i));
			t.setPriority(Thread.MAX_PRIORITY);
			t.start();
		}

		// And one Odie, who doesn't need food as often.
		Thread odie = new Thread(() -> {
			for (;;) {
				// Gets kicked off the table for a second.
				// GAAAAaAAAAAaaaAAfIIIIIIIELD!
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// Consumes some lasaga.
				lasaga.provideNourishment(100);
				System.out.println("Woof");
			}
		});
		// To add insult to injury, Odie is low priority.
		odie.setPriority(Thread.MIN_PRIORITY);
		odie.start();
		// OK, I want to say that the Odie thread is getting starved, but the
		// Java scheduler is actually good, so Odie is getting foods about as
		// often as each of the Garfelos. So... bad example?
	}
}
