
public interface Liveable 
{
	//abstract keyword is implicit in interfaces 
	//olny keywords allowed are public abstract default static strict
	abstract void breathe();
	void consume();
	void excrete();
	
	default void stayinAlive()
	{
		System.out.println("ah ah ah ah stayin aliiiiiive");
	}
}
