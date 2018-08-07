package com.revature.advancedtopics;

public class GarbageDriver {
	
	public static void main(String[] args) {
		System.out.println("instantiating an unused object");
		
		GarbageDriver obj = new GarbageDriver();
		
		System.out.println("object created. about to sleep...");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		obj=null;
		System.gc();
		System.out.println("at end of main method");
	}
	
	
	//finalize() = method called by GC before object gets garbage collected
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("Goodbye cruel world! I am leaving you");
	}

}
