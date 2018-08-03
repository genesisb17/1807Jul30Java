package com.iantimothyjohnson.assignments;

import java.util.concurrent.Semaphore;

/**
 * This class presents a solution to the producer-consumer problem that doesn't
 * lead to the deadlock described on the Wikipedia page:
 * https://en.wikipedia.org/wiki/Producer%E2%80%93consumer_problem
 * 
 * @author Ian Johnson
 */
public class ProducerConsumer {
	private static final int MAX_OBJECTS = 10;
	/**
	 * The number of milliseconds it takes to produce an object.
	 */
	private static final int PRODUCE_MS = 100;
	/**
	 * The number of milliseconds it takes to consume an object.
	 */
	private static final int CONSUME_MS = 1000;
	/**
	 * The number of objects that are done. We assume here that all objects are
	 * filled initially.
	 */
	private static final Semaphore finishedObjects = new Semaphore(MAX_OBJECTS);

	private static class Producer implements Runnable {
		@Override
		public void run() {
			for (;;) {
				System.out.println("Waiting to produce...");
				produce();
			}
		}

		private void produce() {
			try {
				Thread.sleep(PRODUCE_MS);
				finishedObjects.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static class Consumer implements Runnable {
		@Override
		public void run() {
			for (;;) {
				System.out.println("Waiting to consume...");
				consume();
			}
		}

		private void consume() {
			try {
				finishedObjects.acquire();
				Thread.sleep(CONSUME_MS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread producer = new Thread(new Producer());
		Thread consumer = new Thread(new Consumer());

		producer.start();
		consumer.start();
	}
}
