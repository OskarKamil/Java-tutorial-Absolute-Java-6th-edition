package chapter9;

public class Sub1a extends Exception {
	/*
	 * Names of the classes should have meaningful names. This one should be called
	 * "DivByZeroException" for example.
	 */

	public Sub1a() {
		super("Divided by zero");
	}

	public Sub1a(String msg) {
		super(msg);
	}

	/*
	 * An exception class should have two constructors. One empty and one with String
	 * parameter. However, they can have some instance variables too. It will be
	 * shown in next class.
	 */
}
