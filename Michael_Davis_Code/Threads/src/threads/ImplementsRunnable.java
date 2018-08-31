package threads;

public class ImplementsRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("In  implement IR thread");
		
		for(int i=0;i<100;i++) {
			System.out.println("IR: "+i);
		}
	}

}
