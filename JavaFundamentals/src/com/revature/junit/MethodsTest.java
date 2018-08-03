package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MethodsTest {
	
	Methods m;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("after class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("before class");
	}

	@Before
	public void setUp() throws Exception {
		m = new Methods();
		System.out.println("before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
