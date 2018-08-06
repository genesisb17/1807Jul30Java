package com.revature.threadexercises;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadExercises {
	//Explore the following common thread problems: deadlock, starvation, producer-consumer problem
	
	private static int[] input = new int[10000];
	private static int[] output = new int[10000];
	private static AtomicInteger inputFree;
	private static AtomicInteger outputFree;
	
	public ThreadExercises() {
		for(int i = 0; i < 10000; i++) {
			input[i] = i;
		}
		inputFree = new AtomicBoolean(true);
		outputFree = new AtomicBoolean(true);
	}

	public static void main(String[] args) {
		/* PRODUCER-CONSUMER:
		 * When there is some resource, commonly a buffer, that producers and consumers are trying to access at the same time. The resource has a fixed capacity.
		 * If it is full, the producers need something to do. When the buffer is empty, the consumers need something to do. Their options are to wait and to discard
		 * the data(if producing)
		 */
		
		//First we need a shared resource
		LinkedBlockingDeque<Integer> pcBuffer = new LinkedBlockingDeque<Integer>(50); //New deque represents buffer with a capacity of 50
		
		
		//Then we need the producer and consumer threads
		Thread[] producers = new Thread[10];
		Thread[] consumers = new Thread[10];
		for(int i = 0; i < 10; i++) {
			producers[i] = new Thread(new Runnable() {

				@Override
				public void run() {
					//Wait to acquire resource
					while(!inputFree.compareAndSet(1, 0)) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				
			});
		}

		/*STARVATION:
		 * When the shared resource is empty, the consumers have nothing to access and they stop executing before all the data is written to the 
		 * resource by the producers
		 */
		
		/*DEADLOCK:
		 * When threads contest for two shared resources necessary for their execution, they may threadA might have resourceA while threadB has resourceB
		 * Because of poor implementation, they both wait for eachother's respective resource, however neither will be given access. This causes the program
		 * to hang
		 */
	}

}
