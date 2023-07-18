package chapter13;
//public static inner class

public class Sub3b {

	public static class Sub3bInner {
		public static int aStatic = 1;
		public int aNonStatic = 2;

		private String nonStaticMethod() {
			return aStatic + " " + aNonStatic;
		}
		/*
		 * Funny thing is, you can have a nonstatic method in a static class. Why?
		 * Static class is not bound to any object. More explained later.
		 */

		public static void someMethod() {
			System.out.println("Hello from inside of the static class and method.");
		}

	}

	public static void main(String[] args) {
		Sub3b.Sub3bInner obj1 = new Sub3b.Sub3bInner();
		/*
		 * When inner (nested) class is static. You can create an object of the nested
		 * class withouth calling an outer class object. You can use outer class name
		 * instead of object, because static objects/classes are not connected to
		 * factual object, only to the class name.
		 */

		Sub3b.Sub3bInner.someMethod();
		/*
		 * Remember that public static inner classes are not connected to any of the
		 * outer objects, this means, they don't need an outer object, and, if you want
		 * to invoke a static method, you don't even need an object because static
		 * methods/variables are not connected to any object, so you can simply invoke
		 * the static method by specifying outerClassName.innerClassName.methodName().
		 */

		Sub3b.Sub3bInner obj2 = new Sub3b.Sub3bInner();
		System.out.println(obj1.nonStaticMethod());
		System.out.println(obj2.nonStaticMethod());
		// obj1: 1 2
		// obj2: 1 2

		Sub3bInner.aStatic = 10;
		obj1.aNonStatic = 20;

		System.out.println(obj1.nonStaticMethod());
		System.out.println(obj2.nonStaticMethod());
		// obj1: 10 20
		// obj2: 10 2
		/*
		 * So, a static class can have non static variables, and they act like any other
		 * variable. Each object of inner static class will have their own copy of non
		 * static variable. But if the variable is static, for each object it will be
		 * the same. Note that the method nonStaticMethod is static. So it means it can
		 * access non static variables. If that method would be static, it would not be
		 * able to access non static variables.
		 */

	}
}
