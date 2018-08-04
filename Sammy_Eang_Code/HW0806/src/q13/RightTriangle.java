package q13;

public class RightTriangle {

	public static void main(String[] args) {
		
		Boolean a = false;
		
		for(int i = 1;i < 5; i ++) {
			for(int j = 0; j < i; j++) {
				if (a == false) {
					System.out.print("0 ");
					a = true;
				} else {
					System.out.print("1 ");
					a = false;
				}
			}
			System.out.println(" ");
		}
	}

}
