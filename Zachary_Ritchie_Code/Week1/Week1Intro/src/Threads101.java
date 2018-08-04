
public class Threads101 {

	public static void main(String[] args) 
	{
		ExtendsThread et = new ExtendsThread();
		
		
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);
		
		
		Runnable anonymous = new Runnable() 
		{
			@Override
			public void run()
			{
				System.out.println("In anon class implemnetation");
				for(int i = 0; i < 50; i++)
				{
					System.out.println("ANON: "+i);
				}
			}
		};
		
		Thread anonThread = new Thread(anonymous);
		
		//LAMBDAS
		Runnable lambda = () ->{
			System.out.println("In LAMBDA");
			for(int i = 0; i < 50; i++)
			{
				System.out.println("LAMBDA: "+i);
			}
		};
		
		Thread l = new Thread(lambda);
		isThread.setPriority(Thread.MAX_PRIORITY);
		l.setPriority(Thread.MIN_PRIORITY);
		l.start();
		System.out.println("State of lambda thread " + l.getState());
		anonThread.start();
		et.start();
		isThread.start();
		System.out.println("State of lambda thread " + l.getState());
		System.out.println("State of IR thread " + isThread.getState());
	}

}
