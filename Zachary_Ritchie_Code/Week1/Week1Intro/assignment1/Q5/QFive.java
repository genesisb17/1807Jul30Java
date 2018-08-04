package Q5;

public class QFive {

	public static void main(String[] args) 
	{
		String s = "Infinity";
		int indexBegin = 0;
		int indexEnd = 5;
		String output = subString(s, indexBegin, indexEnd);
		System.out.println(output);
	}
	
	static String subString(String s, int begin, int end) 
	{
		char[] charArray = s.toCharArray();
		char[] placeHolder = new char[end];
		for(int i = begin; i <= end - 1; ++i)
		{
			placeHolder[i] = charArray[i];
		}
		String newString = String.valueOf(placeHolder);
		return newString;
	}
}
