package designpatterns;

public class SingletonExample {

	
	
	private static SingletonExample instance;
	
	private SingletonExample() {
		
	}
	
	static {
		try {
			instance=new SingletonExample();
		}
		
		catch(Exception e){
			throw new RuntimeException("Error creating singleton instance");
		}
		
	}
	
	public static SingletonExample getInstance() {
		return instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
