package com.iantimothyjohnson.homework.question15;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoubleCalculatorTest {
	private static final double ARG1 = 5.0;
	private static final double ARG2 = 2.0;
	/**
	 * The acceptable inaccuracy for double comparisons.
	 */
	private static final double DELTA = 1e-6;

	DoubleCalculator calc;

	@Before
	public void setUp() throws Exception {
		calc = new DoubleCalculator();
	}

	@After
	public void tearDown() throws Exception {
		calc = null;
	}

	@Test
	public void testAdd() {
		assertEquals(ARG1 + ARG2, calc.add(ARG1, ARG2), DELTA);
	}

	@Test
	public void testSubtract() {
		assertEquals(ARG1 - ARG2, calc.subtract(ARG1, ARG2), DELTA);
	}

	@Test
	public void testMultiply() {
		assertEquals(ARG1 * ARG2, calc.multiply(ARG1, ARG2), DELTA);
	}

	@Test
	public void testDivide() {
		assertEquals(ARG1 / ARG2, calc.divide(ARG1, ARG2), DELTA);
	}

}
