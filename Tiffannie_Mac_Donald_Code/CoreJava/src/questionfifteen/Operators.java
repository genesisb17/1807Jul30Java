package questionfifteen;

/*
 * Write a program that defines an interface having the following methods:addition, 
 * subtraction,  multiplication,  and  division.   Create a  class  that  implements 
 * this  interface and  provides  appropriate  functionality  to  carry  out  the  
 * required  operations.  Hard  code two operands in a test class having a main method 
 * that calls the implementing class
 */

public interface Operators {
	float addition(float a, float b);
	float subtraction(float a, float b);
	float multiplication(float a, float b);
	float division(float a, float b);
}
