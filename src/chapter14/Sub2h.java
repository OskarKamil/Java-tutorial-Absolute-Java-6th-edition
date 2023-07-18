package chapter14;

public class Sub2h {

	public static void saySomething() {
		System.out.println("something");
	}

	public static <T> T returnObject(T source) {
		return source;
	}
	/*
	 * This is a non generic class definition, but this class still can contain
	 * generic method definitions. The rule is exactly the same. Before return type
	 * you include <T> part and the rest is the same. A parameter can be T type,
	 * return type can be T etc. But in next method you will see the return type not
	 * neccesserarilly must be T, it can be different, there is <T> only because the
	 * argument to this method is of T type.
	 * 
	 * If the class is generic, put <T> after class name, but if the method is
	 * generic, put <T> before return type.
	 * 
	 * Class example: public class Pair <T1, T2>
	 * 
	 * Method example: public static <T> T returnObject(T source)
	 */

	public static <T> String tryToString(T source) {
		return source.toString();
	}
}
