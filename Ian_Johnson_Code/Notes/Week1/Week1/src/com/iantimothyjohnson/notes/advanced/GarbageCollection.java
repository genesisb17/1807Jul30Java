package com.iantimothyjohnson.notes.advanced;

@SuppressWarnings("unused")
public class GarbageCollection {
	public static void main(String[] args) {
		System.out.println("Instantiating an unused object.");
		GarbageCollection obj = new GarbageCollection();
		System.out.println("Object created; about to sleep...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		obj = null;
		// You can't force garbage collection, but you can suggest it:
		System.gc();
		System.out.println("At end of main method.");
	}
	
	// Finalize is a method called by the garbage collector before an object
	// gets garbage collected.
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("I'm out!");
	}
}
