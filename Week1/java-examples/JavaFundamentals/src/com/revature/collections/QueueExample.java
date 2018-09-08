package com.revature.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

public class QueueExample {
	

	public static void main(String[] args) {
	
	}
	
	public static void queueExample() {
		Queue<Integer> myFifo = new ArrayDeque<>();
		
		// We use the methods poll/peek/offer
		// offer(E e) is used to add an element to the end of the Queue
		myFifo.offer(13);
		myFifo.offer(7);
		myFifo.offer(1);
		
		// If I want to look at an element of a Queue, I would use peek
		//System.out.println(myFifo.peek());
		
		// There are two options
		// Option 1: Using a while loop
		while (!myFifo.isEmpty()) {
			System.out.println("Current size: " + myFifo.size());
			System.out.println(myFifo.poll()); 		// poll() will return the first element, and remove it
		}
		
		System.out.println("What is result when calling poll() now? " + myFifo.poll());
		
		myFifo.offer(13);
		myFifo.offer(7);
		myFifo.offer(1);
		
		// Option 2: Iterator
		Iterator<Integer> it = myFifo.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("Current size: " + myFifo.size());
	}
	
	public static void stackExample() {
		Deque<Integer> myLifo = new ArrayDeque<>();
		// When using LIFO, we use the methods push/poll/peek
		myLifo.push(13);
		myLifo.push(7);
		myLifo.push(1);
		
		Iterator<Integer> it = myLifo.iterator();
		while (it.hasNext()) {
			System.out.println("Current size: " + myLifo.size());
			System.out.println(it.next());
		}
	}


}
