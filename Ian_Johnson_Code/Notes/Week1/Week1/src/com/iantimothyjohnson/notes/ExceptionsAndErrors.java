package com.iantimothyjohnson.notes;

import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("unused")
public class ExceptionsAndErrors {
	// We can make our own exceptions:
	private static class MyException extends Exception {
		private static final long serialVersionUID = 1L;

		public MyException(String message) {
			super(message);
		}
	}

	public static void main(String[] args) {
		// Exceptions and Errors are both things that go wrong at runtime (as
		// opposed to syntax errors, which occur at compile time). The
		// difference between them is that we can work with Exceptions, while
		// Errors are not recoverable (although theoretically we can catch
		// them).

		// Error and Exception are classes derived from the abstract class
		// Throwable.
		// Examples of Error: StackOverflowError, OutOfMemoryError
		// Examples of Exception: IOException, SQLException

		// RuntimeException is a subclass of Exception; unlike Exception,
		// RuntimeExceptions are "unchecked", meaning we don't have to handle
		// them (although in many cases we should). Exceptions derived directly
		// from Exception are "checked", meaning we must handle them explicitly
		// (this is enforced at compile time).
		// Examples of RuntimeException: NullPointerException, ArithmeticException

		// Only exceptions derived from Error and RuntimeException are
		// unchecked. Everything else is checked!

		// How to handle exceptions:
		try {
			int x = 1 / 0;
		} catch (ArithmeticException e) {
			// We can print the stack trace of an Exception:
			e.printStackTrace();
		}
		// You can even have multiple catch blocks for one try, to handle
		// different types of exception. Just make sure that you handle the most
		// specific exceptions first, or you will get unreachable code, which
		// cannot be compiled.

		// Checked exceptions can't be caught unless the try block actually
		// contains a statement that could throw one. For example, you can't
		// catch a SQLException in the above code, since there are no SQL
		// operations in the try block.

		// Here's another example where we can see an interesting stack trace:
		try {
			exploreStack(args);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		// In order to use a try block, you must also use a catch, finally or
		// both.

		// An alternative to handling a checked exception using a try/catch in
		// your method is to add a throws declaration to the method, indicating
		// that the method simply passes that exception along to the caller.
		try {
			openFile();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// The stuff in the finally block is executed whether or not an
			// exception was thrown. This is useful for cleaning up resources,
			// like closing a file.
			System.out.println("Finally!");
		}

		// Instead of using finally, you can also use "try with resources":

		// try (Connection c = new Connection()) {
		//     c.doStuff();
		// }

		// The connection would be auto-closed after the try block has finished
		// executing.

		// Here's where we can use our own Exception:
		try {
			throwingCustom("a wild problem appeared!");
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	private static void doThings(String[] args) {
		System.out.println(args[100].toLowerCase());
	}

	private static void exploreStack(String[] args) {
		doThings(args);
	}

	private static void openFile() throws IOException {
		try {
			FileReader reader = new FileReader("doesntExist.txt");
			reader.close();
		} catch (IOException e) {
			throw new IOException("Could not work with file", e);
		}
	}

	private static void throwingCustom(String issue) throws MyException {
		String message = "This is our problem: " + issue;
		throw new MyException(message);
	}
}
