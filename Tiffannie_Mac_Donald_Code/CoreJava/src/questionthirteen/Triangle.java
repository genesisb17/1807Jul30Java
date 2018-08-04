package questionthirteen;

public class Triangle {

	public static void main(String[] args) {
		/*
		 * Display the triangle on the console as follows using any type of loop.  
		 * Do NOT use a simple group of print statements to accomplish this.
		 */
		int n = 4;

		int counter =1;
		
		for (int i = 0; i < n+1; i++) {
			
			for (int j = 0; j < i; j++) {
				if(counter % 2 ==0) {
					System.out.print("0");
				} else {
					System.out.print("1");
				}
				
				counter++;
			}
			System.out.println("");
		}
//			for (int k = 0; k < (2 * i + 1); k++)
//				System.out.print("1");
//			System.out.println();
		}

	}


