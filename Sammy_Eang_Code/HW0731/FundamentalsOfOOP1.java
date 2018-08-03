package Exercises;

public abstract class FundamentalsOfOOP1 {

	private int age = 22;

	public int getAge() {
		return this.age;
	}
	public int setAge(int value) {
		this.age = value;
		return value;
	}
	
	public void getName(String b) {
		System.out.println("My name is definitely not " + b);
	}
	
	abstract public static void runAway();
}
