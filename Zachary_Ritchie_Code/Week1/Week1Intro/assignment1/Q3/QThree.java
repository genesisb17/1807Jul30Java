package Q3;

public class QThree {

	public static void main(String[] args) 
	{
		String word = "exception";
		char[] charArray = word.toCharArray();
		char[] n = new char[word.length()];
		int counter = 0;
		
		for (int i = word.length()-1; i >= 0; --i)
		{
			//enter letters into new array backwards
			n[counter] = charArray[i];
			counter++;
		}		
		
		for (char letters : n)
		{
			System.out.println(letters);
		}		
	}
}
