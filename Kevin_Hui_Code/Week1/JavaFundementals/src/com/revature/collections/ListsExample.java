package com.revature.collections;

import java.util.Stack;

public class ListsExample {

	public static void main(String[] args) {
		Stack<Integer> pile = new Stack<Integer>();
		
		System.out.println("empty() method output is " + pile.empty() + ".\n");
		System.out.println("Now pushing integers into stack.");
		
		// Push 10 random values to newly-create stack
		for(int i = 0; i < 10; i++) {
			System.out.println("Pushing " + pile.push((int)(Math.random() * 50)) + " to stack.");
		}
		
		// NOTE: push and pull methods return the value of the argument
		
		System.out.println("empty() method output is " + pile.empty() + ".\n");
		
		System.out.println("Stack is now: " + pile + ".\n");
		
		System.out.println("Popping " + pile.pop() + " from top of the stack.");
		System.out.println("Stack after 1st pop is now: " + pile + ".\n");
		
		System.out.println("Peeking " + pile.peek() + " from top of the stack.");
		System.out.println("Stack after peeking is: " + pile + ".\n");
		
		System.out.println("Popping " + pile.pop() + " from top of the stack.");
		System.out.println("Stack after 2nd pop is now: " + pile + ".\n");
		
		System.out.println("Pushing " + pile.push(9001) + " from top of the stack.");
		System.out.println("Stack after push is now: " + pile + ".\n");
		
		// Add 5 more!
		for(int i = 0; i < 5; i++) {
			System.out.println("Pushing " + pile.push((int)(Math.random() * 50)) + " to stack.");
		}
		
		System.out.println("\nStack is now: " + pile + ".\n");
		
		System.out.println("The integer 9001 is located " + pile.search(9001) + " positions from the top of the stack.\n");
	}

}
