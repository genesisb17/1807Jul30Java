package com.iantimothyjohnson.homework.question15;

/**
 * A calculator that operates specifically on Doubles.
 * 
 * @author Ian Johnson
 */
public class DoubleCalculator implements Calculator<Double> {
	@Override
	public Double add(Double a, Double b) {
		return a + b;
	}

	@Override
	public Double subtract(Double a, Double b) {
		return a - b;
	}

	@Override
	public Double multiply(Double a, Double b) {
		return a * b;
	}

	@Override
	public Double divide(Double a, Double b) {
		return a / b;
	}
}
