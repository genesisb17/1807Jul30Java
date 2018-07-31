
// unboxing is from wrapper class to primitive
// boxing is from primitive to wrapper class

public class Wrappers 
{
	public static void main(String[] args) 
	{
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		int five = Integer.parseInt("5");
		//int willCauseException = Integer.parseInt("one hundred");
		
		Integer i = new Integer(80);
		int numeighty = i; //unboxing 
		
		int x = 10;
		Integer wrapper = x; //autoboxing
		
		
	}
}
