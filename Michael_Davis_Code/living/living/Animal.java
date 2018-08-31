package living;

public abstract class Animal implements livable {
/*
 * acess mod/non acess mods/class/classname
 * 
 * abstract classes have the ability to have abstract methods
 * 
 * They do not need to have an abstract method to be abstract. 
 * they just have the ability
 */
	
public void consume() {
	System.out.println("things to consume "+helperMethod());
}

private static int helperMethod() {
	return 0;
}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
