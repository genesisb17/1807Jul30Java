//Created by Darius Moomivand @ 05Aug18
import java.util.Scanner;

public class Calc {
	static int first = 9;
	static int second = 20;

	// function that takes enum 
	public static void calculate(Func input) {
		switch(input) {
			case ADD: System.out.println(first + second); 
						break;
			case SUB: System.out.println(second - first); 
						break;
			case MUL: System.out.println(first * second); 
						break;
			case DIV: System.out.println(second / first); 
						break;
				
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter one of the following to execute the function: ");
		System.out.println(" 'add' to add");
		System.out.println(" 'sub' to subtract");
		System.out.println(" 'mul' to multiply");
		System.out.println(" 'div' to divide");

		Scanner sc = new Scanner(System.in);
		Func temp = Func.valueOf(sc.next().toUpperCase()); // Convert string to enum
		String y = sc.nextLine();
		
		Calc.calculate(temp);
	}

}
