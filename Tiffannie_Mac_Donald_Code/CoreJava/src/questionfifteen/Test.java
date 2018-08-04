package questionfifteen;

public class Test {

	public static void main(String[] args) {
		//instantiate an Operations object to call operand methods.
		Operations math = new Operations();
				
		//object . method allows us to use functionality of other classes
		float a = math.addition(9, 3);
		
		float b = math.division(a, 3);
		
		System.out.println(a);
		System.out.println(b);
	}

}
