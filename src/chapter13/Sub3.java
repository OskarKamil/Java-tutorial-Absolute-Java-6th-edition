package chapter13;
//private static inner class (private nested static class)

public class Sub3 {

	private static class Sub3Inner {
		int age;
		String name;

		public Sub3Inner(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}

	private static void createExample(int age, String name) {
		Sub3Inner obj1 = new Sub3Inner(age, name);
	}

	public static void main(String[] args) {
		Sub3.createExample(10, "Sisi");
		/*
		 * Accessing inner static class method by the name of the outer class, not by
		 * the object. Sometimes you may need it.
		 */
	}
}
/*
 * Example of using static inner classes. Normal (nonstatic) inner classes have
 * a connection to the outer classes. Namely, each object of the outer class
 * will probably have an object of an inner class. With static inner classes.
 * You can create a static object of the inner class and access it by using
 * outer class name instead of the object.
 */
