
public class GCTest {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize invoked");
	}
	
	public static void main(String[] args) {
		GCTest gc = new GCTest();
		gc = null;
		System.gc();
	}
}
