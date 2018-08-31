import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MethodsTest {
	
	/*
	 * 
	 * j UNIT IS A JAVA TESTING FRAMEWORK
	 * 
	 * annotations associated with j unit
	 * 
	 * before class
	 * after class
	 * before
	 * after
	 * test
	 * 
	 * test driven development means that you understand your end goal and that
	 * if successful your program will pass x test or a series of test.
	 */

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}
	
	/*
	 * the annotations decides whether things are ched before and after respectivly
	 */

	@Before
	public void setUp() throws Exception {
		//m=new Method();
		System.out.println("before class..");
	}

	@After
	public void tearDown() throws Exception {
		//m=null;
		System.out.println("after class..");
	}

	@Test
	public void testBubbleSort() {
		int[] nums= {100,2,89,51,2,5,6,0,};
		int[] expected={0,2,2,5,6,51,89,100};
		//here i would put x.bubblesort(nums) where is to assure that 
		//it returns the right answer for whats to be expected to assure
	//it meats the test expectations
		/*
		 * this allows us to check that a program works regardless of individual implementation
		 */
		assertArrayEquals(nums,expected);
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
