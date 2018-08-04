package Q15;

public class mathMethods implements mathClass
{
	@Override
	public int addition(int num1, int num2) 
	{
		int output = num1+num2;
		return output;
	}

	@Override
	public int subtraction(int num1, int num2) 
	{
		int output = num1-num2;
		return output;
	}

	@Override
	public int multiplication(int num1, int num2) 
	{
		int output = num1*num2;
		return output;
	}

	@Override
	public int division(int num1, int num2)
	{
		int output = num1/num2;
		return output;
	}

}
