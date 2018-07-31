package Exercises;

//Inheritence since FundamentalsOfOOP2 extends FundamentalsOdOOP1
public class FundamentalsOfOOP2 extends FundamentalsOfOOP1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runAway();
		FundamentalsOfOOP2 foop2 = new FundamentalsOfOOP2();
		foop2.getName("hello");
		//Encapsulation as it makes use of the private var within the FundamentalsOfOOP1 class
		int a = foop2.getAge();
		System.out.println("My age is " + a);
	}
	
	//Polymorphism as it overrides the old parent function of getName within the FundamentalsOfOOP1 class
	@Override
	public void getName(String b) {
		System.out.println("My name is now certainly " + b);
	}
	
	//Abstraction as it had to define the empty method within the FundamentalsOfOOP1 class
	public static void runAway() {
		System.out.println("Now's not the time to run.");
	}

}
