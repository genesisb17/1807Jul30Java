package Q18;

public class methodDefiner extends threeMethods
{

	@Override
	public boolean uppercase(String str) 
	{
		char[] input = str.toCharArray();
		
		for (char c : input)
		{
			if (Character.isUpperCase(c))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public String convertToUpper(String str) 
	{
		char[] input = str.toCharArray();
		
		for (char c : input)
		{
			if(Character.isLowerCase(c)) 
			{
				c = Character.toUpperCase(c);
			}
		}
		return str;
	}

	@Override
	public int convertToInt(String num) 
	{
		int input = Integer.parseInt(num);
		input = input + 10;
		
		return input;
	}
	
}
