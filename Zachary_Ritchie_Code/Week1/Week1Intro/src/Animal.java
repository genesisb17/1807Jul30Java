

//access mod / non-access modts / class / className
public abstract class Animal implements Liveable
{
	/*
	 * Absttract classes have the ability to have 
	 * abstract methods (unimplemented methods)
	 * The do NOT need to have and abstract method
	 * to be abstract, they just have the ability to.
	 */
	
	public void consume()
	{
		System.out.println("Animals eat things to comsume");
	}
	
	private static int helperMethod()
	{
		return 0; 
	}
}
