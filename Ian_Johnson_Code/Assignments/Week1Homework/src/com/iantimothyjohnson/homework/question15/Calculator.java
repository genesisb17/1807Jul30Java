package com.iantimothyjohnson.homework.question15;

/**
 * An interface which provides basic arithmetic operations for objects of a
 * given (generic) type.
 * 
 * @author Ian Johnson
 */
public interface Calculator<T> {
	T add(T a, T b);
	T subtract(T a, T b);
	T multiply(T a, T b);
	T divide(T a, T b);
}
