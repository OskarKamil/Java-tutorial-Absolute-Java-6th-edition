package chapter8;

public class Sub1a extends Sub1 {

	String name = "circle";

	public void info() {
		System.out.println("This is aa " + name);
	}

	public void meth2() {
		System.out.println("Child meth");
	}

	public static void meth2static() {
		System.out.println("Child meth static \n");
	}
	/*
	 * Overridden static method of derived class. If used with calling object, it
	 * works as any other normal method, for example obj1.meth2static would invoke
	 * this method if obj1 reference and object type are both Sub1a. However java
	 * uses static binding for static methods, in short: if it is an invokation of a
	 * static method, compiler will invoke the version of the method of the type of
	 * the variable of the naming object. For example you can create naming object
	 * Sub1a = new Sub1a(). and it will invoke meth2static from here, but if the
	 * variable name is Sub1, then it will invoke from base class.
	 */

}
