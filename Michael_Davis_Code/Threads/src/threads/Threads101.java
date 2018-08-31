package threads;

public class Threads101 {
	
	/*
	 * Thread- a single path of execution in your code
	 * multithreadsing- multiple flows of contron in program execution
	 *  - each thread gets its own stack and follows its own sequence 
	 *  of method calls with associate variables
	 *  we create a seperate thread of exetuion by either implementing the 
	 *  Runnable interface  or by extending the thread class.
	 *  
	 *  Types of threads;
	 *  
	 *  -user-main() or any other explicitly requested processes
	 *  -daemon threads- background processes ie garbage collector
	 *  
	 *  isAlive-checks if thread is alive
	 *  join() allows one thread to wait for the completion of another
	 *  --JVM terminate when no more user threads are active
	 *  
	 *  synchronization- a method or statement is synchronized if only one 
	 *  thread may access it at a time
	 *  
	 *  Threads have state.they are:
	 *  New-thread is new
	 *  
	 *  Runnable-when ready to run(may be running or simply ready to run at 
	 *  any time)
	 *  
	 *  Blocked-aka waiting stage;when a thread is temporarily inactive it is either blocked 
	 *  or waiting. A thread is in the blocked state when it tries to acess
	 *   a protected section of code that is currently locked in another thread
	 *   
	 *   Waiting- threads can be made to wait for other actions
	 *   
	 *   Timed waiting- can call a timed wait method in threads
	 *   
	 *   Terminated- a thread terminate because either it completes its task naturally or 
	 *   because some unusual or exceptional event occurs
	 *   
	 *   Related topics: deadlock,starvation,producer-consumer problem
	 *   
	 *   
	 */
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExtendsThread et= new ExtendsThread();
		ImplementsRunnable ir=new ImplementsRunnable();
		Thread isThread=new Thread(ir);
		
		et.start();
		isThread.start();
		
		
		Runnable anonymous=new Runnable() {
			@Override
			public void run() {
				System.out.println("In anon");
				
				for(int i=0;i<100;i++) {
					System.out.println("ANON: "+i);
				}
			}	
			
		};
		Thread anonThread=new Thread(anonymous);
		
		
		//LABDASSSSSSSSSSSSSSSSSSSSS
		
		Runnable lambda=()->{
			System.out.println("In anon");
			
			for(int i=0;i<100;i++) {
				System.out.println("Lambda: "+i);
			}
		};
		
		Thread l=new Thread(lambda);
		l.start();
		System.out.println("State of 1 thread: "+l.getState());
		anonThread.start();
		et.start();
		isThread.start();
		System.out.println("State is isThread: "+isThread.getState());
		
	
		//ir.run();
		
		
		
	}

}
