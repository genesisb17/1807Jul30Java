package com.revature.advancedtopics;

public class GarbageDriver {

	public static void main(String[] args) {
		System.out.println("Instantiating an unused object");
		
		GarbageDriver obj = new GarbageDriver();
		
		System.out.println("Object created. About to sleep...");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		obj = null;
		System.gc(); //Here, 
		System.out.println("At the end of main method");
	}
	
	//finalize() = method called before Garbage Collector before object gets garbage collected
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("Goodbye cruel world! I a leaving you");
	}
	
}
