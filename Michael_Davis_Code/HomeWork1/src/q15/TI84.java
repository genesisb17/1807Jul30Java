package q15;

public class TI84 implements TheCalc {

	public static void main(String[] args) {
		TI84 b=new TI84();
		System.out.println(b.add(6,7));
		System.out.println(b.multiply(6,7));
		// TODO Auto-generated method stub

	}

	public double add(int a,int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	public double subtract(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	public double multiply(int a,int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	public double divide(int a,int b) {
		// TODO Auto-generated method stub
		return a/b;
	}


	@Override
	public double add() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double subtract() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double multiply() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double divide() {
		// TODO Auto-generated method stub
		return 0;
	}

}
