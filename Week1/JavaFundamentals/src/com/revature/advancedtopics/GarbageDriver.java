package com.revature.advancedtopics;

public class GarbageDriver {

	
	public static void main(String[] args) {
		System.out.println("instantiating an unused object");
		
		GarbageDriver obj = new GarbageDriver();
		
		System.out.println("object created. about to sleep...");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		obj = null;
		//The method the garbage collector calls before it removes something from memory
		//The garbage calls finalize, we just ask the garbage colllector to do so via gc()
		System.gc();
		System.out.println("at end of main method");
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("Goodbye cruel world! Komm susser tod!");
	}
	
}
