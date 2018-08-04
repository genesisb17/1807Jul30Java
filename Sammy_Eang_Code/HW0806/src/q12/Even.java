package q12;

public class Even {

	public static void main(String[] args) {
		
		//Array to store ints
		int[] store = new int[101];
		
		//Numbers from 0 to 100
		for(int i = 0; i < 101; i ++) {
			//Put them in the array yo
			store[i] = i;
		}
		
		//For each int in store, referred to by 'a'
		for(int a: store) {
			//check if modulus is 0
			if(a%2 == 0) {
				//print out if so
				System.out.println(a);
			}
		}
	}
	
	//Done!
}
