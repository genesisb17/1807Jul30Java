package q13;

public class RightTriangle {

	public static void main(String[] args) {
		
		//Starts a at false, aka print 0 first
		Boolean a = false;
		
		//goes through loop of 4 lines
		for(int i = 1;i < 5; i ++) {
			//prints number of 0's or 1's depending on line it's on
			for(int j = 0; j < i; j++) {
				//print 0, then switch to printing 1
				if (a == false) {
					System.out.print("0 ");
					a = true;
				//print 1, then switch to printing 0	
				} else {
					System.out.print("1 ");
					a = false;
				}
			}
			//print new line
			System.out.println(" ");
		}
	}

}
