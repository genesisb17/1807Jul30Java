package com.revature.threads;

public class Threads101{
	
	public static void main(String[] args) throws InterruptedException {
		
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);

		//anonymous instantiates one function and only one
		Runnable anonymous = new Runnable() {
			@Override
			public void run() {
				System.out.println("in anon class implementation");
				for(int i = 0; i < 50; i++) {
					System.out.println("ANON: " + i);
				}
			}
		};
		
		Thread anonThread = new Thread(anonymous);
		
		//LAMBDAS expressions can only be used with functional interfaces 
		Runnable lambda = () -> {
			System.out.println("In Lamda");
			for(int i = 0; i < 50; i++) {
				System.out.println("Lambda: " + i);
			}
		};
	
		Thread l = new Thread(lambda);
		isThread.setPriority(Thread.MAX_PRIORITY);
		l.setPriority(Thread.MIN_PRIORITY);
		l.start();
		System.out.println("STATE OF LAMBDA THREAD" + l.getState());
		anonThread.start();
		et.start();
		isThread.start();
		System.out.println("STATE OF LAMBDA THREAD" + l.getState());
		System.out.println("STATE OF IR THREAD" + isThread.getState());
	}
}
