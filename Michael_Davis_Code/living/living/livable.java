package living;

public interface livable {
	//abstract keyword is implicit in interfaces
	
	/*
	 * only keywords allowed are pubic abstract default static strict
	 * 
	 * 
	 
	 */
	abstract void breath();
	void consume();
	void excrete();
	
	default void stayinAlive() {
		System.out.println("ha ha ha stayin alive stayin alive");
	}

}