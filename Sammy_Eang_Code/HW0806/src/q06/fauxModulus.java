package q06;

public class fauxModulus {

	public static void main(String[] args) {
		
		mod(7);
		
	}

	static void mod(int num) {
		while (num > 1) {
			num = num - 2;
		}
		if (num == 1) {
			System.out.println("The number is odd!");
		} else if (num == 0) {
			System.out.println("The number is even!");
		}
	}
	
}
