
public class LoopStatements {
	public static void main(String[] args) {
		
		int num = 5;
		//initialize counter; set condition; change/update counter
		for(int i = 0; i < num; i++) {
			System.out.print(i);
		}
		
		//enhanced for loop aka foreach
		int[] b = {1, 2, 3, 4}; 
		for(int a : b) {
			System.out.println(a);
		}
		
		//do while will occur at least once before making it to 
		//to the condition
		//while(condition){
		//	do this;
		
		//do {
		//	this
		//}
		//while(condition);
		int stop = 0;
		do {
			System.out.println("This will only print once");
		} while(stop > 1);
		
		//demonstrating a while loop
		int count = 0;
		while(count != 11) {
			//if statement is like a road block
			//if this is the case, go here/turn here
			if(count % 2 == 0) {
				System.out.println("Even");
			}
			else if(count % 2 != 0) {
				System.out.println("Odd");
			}
			//else is a backup. in case the initial
			//if condition is false
			//but i do not think this will run because each number can only
			//be even or odd.... hehe whoops
			else {
				System.out.println(count);
			}
			count++;
		}
		
		//switch statements are not really looking for
		//matching conditions, but just matching
		//values
		//if no case is met use the default keyword (similar to else)
		//break is to exit a path of execution
		//as soon as one case is met it will execute the remaining cases
		//unless there is a break statement.
		//use a break or return statement. you need either or
		
		//this is a poor example. had I the opportunity, better to use
		//enums probably.
		int primaryColor = 3;
		int color = 0;
		switch(primaryColor) {
			case 1: color = 1; //red
				return;
			case 2: color = 2; //yellow
				break;
			case 3: color = 3; //blue
		}
		System.out.println(color);
		
	}
}
