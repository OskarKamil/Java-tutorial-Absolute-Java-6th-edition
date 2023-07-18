package chapter8;

public class Sub1c extends Sub1 {

	String name = "triangle";

	public void info() {
		System.out.println("This is aa " + name);
	}

	public void meth1() {
		meth2();
		meth2static();
	}
	/* Here we overriden the meth1 non-static method. */

	public void meth2() {
		System.out.println("Child meth");
	}

	public static void meth2static() {
		System.out.println("Child meth static\n");
	}

}
