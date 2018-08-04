package questionfifteen;

public class Operations implements Operators{

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

	@Override
	public float addition(float a, float b) {
		// adds two numbers
		return a + b;
	}

	@Override
	public float subtraction(float a, float b) {
		// subtracts two numbers
		return a - b;
	}

	@Override
	public float multiplication(float a, float b) {
		// multiplies two numbers
		return a * b;
	}

	@Override
	public float division(float a, float b) {
		// divides two numbers
		return a /b;
	}
}