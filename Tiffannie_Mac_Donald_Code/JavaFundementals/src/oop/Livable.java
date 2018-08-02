package oop;

/*
 * abstract keyword is implicit in interfaces.
 * only keywords allowed are public abstract default staticfp
 */
public interface Livable {
	
	abstract void breathe(); //you can or don't have to write abstract since ^
	void consume();
	void excrete();
	
	//you must give it the default keyword in order to impliment otherwise
	//it is assumed to be abstract
	default void stayinAlive() {
		System.out.println("ha ha ha ha stayin aliiiiiiive");
	}
	
	
	
}
