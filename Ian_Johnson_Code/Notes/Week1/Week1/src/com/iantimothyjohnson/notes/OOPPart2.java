package com.iantimothyjohnson.notes;

/**
 * Part 2 of the OOP notes, with more focus on examples.
 */
@SuppressWarnings("unused")
public class OOPPart2 {
	private static interface Livable {
		// There is an implicit abstract keyword on every interface method.
		// Interface methods are also always public.
		public abstract void breathe();

		void consume();

		void excrete();

		// Any concrete method needs the default keyword.
		default void stayinAlive() {
			System.out.println("ha ha ha ha stayin aliiiiiiiiiiiiiiiiiiiiiiive");
		}
	}

	private static abstract class Animal implements Livable {
		@Override
		public void consume() {
			// Stuffing your face as usual
			System.out.println("I gotta have a good meal");
		}
	}

	private static class Dog extends Animal {
		@Override
		public void breathe() {
			System.out.println("Huff puff");
		}

		@Override
		public void excrete() {
			System.out.println("gross");
		}
		
		@Override
		public void consume() {
			System.out.println("I'm getting kicked off the table for sure");
		}
	}

	public static void main(String[] args) {
		Dog d = new Dog();
		d.consume();
	}
}
