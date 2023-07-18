package chapter13;
//public non-static inner class

public class Sub3a {
	public class Sub3aInner {

//		private static int staticAmount() {
//			return 0;
//		}
		/*
		 * A static method cannot be inside non static classs. It has to be inside a
		 * static class or top level class. This means that Sub3a can have a static
		 * method but Sub3aInner cannot. To make it logical to remember, think that
		 * static method is not connected to any object, they are static and they can be
		 * invoked by class name not by class object. So you can invoke static method
		 * from outer class Sub3a, if they do not need to be connected to any object,
		 * there is no point to have them in inner class, just keep them in outer class.
		 */
		private int getAmount() {
			return 100;
		}
	}

	public int getOuterAmount() {
		return 1000;
	}

	public static void main(String[] args) {
		// Sub3a.Sub3aInner obj1 = new Sub3a.Sub3aInner();
		/*
		 * This would work with static class because static inner class is not connected
		 * to outer class, and they do not need an out class object. Static objects hold
		 * value not dependent on the calling object. Here, each object of outer class
		 * will also have an object of the inner class, so each object of inner class
		 * must have an object of outer class. In other words, you need an object of
		 * outer class if you want to create an inner class.
		 */

		Sub3a outerObject = new Sub3a();
		Sub3a.Sub3aInner innerObject = outerObject.new Sub3aInner();
		System.out.println(innerObject.getAmount() + " pounds");
		// System.out.println(innerObject.getOuterAmount);

		/*
		 * Let's explain this code:
		 * 
		 * 1. First line. To create an inner object, you need an outer object first.
		 * Once again, this is not static class, so each inner object must have an outer
		 * object. Here we just create new object and using constructor.
		 * 
		 * 2. Seconds line. You need to create an inner object now. On the left you need
		 * to specify a type for the object, type of the object is the inner class, that
		 * is why you have Sub3a.Sub3aInner, this is a type of the inner class and a
		 * type of an object you are trying to create. On the right side you have a new
		 * type of syntax. On the right side you need to invoke a constructor of the
		 * inner class, the proper syntax in nonstatic class is [outerObject.new
		 * InnerClass()]. This is a new syntax, just remmeber to invoke constructor you
		 * need an objectName.new InnerClassName.
		 * 
		 * 3. Third line. You are actively using inner class object. Here you want to
		 * invoke getAmount() method of an inner class, nothing too surprising here.
		 * 
		 * 4. Forth line. Why this code would not work? In previous example (Sub2.java),
		 * we learned that inner classes can see method of outer classes and vice versa,
		 * so, what's the problem here? The thing is, the inner class can invoke outer
		 * class method, but only in the definition of the inner class. What does it
		 * mean? We are now inside main() method, we cannot simply invoke any outer
		 * class method we want by using inner class. Why? For security reasons, the
		 * inner class may be public, and the outer class may be public, but that does
		 * not mean we can invoke any method we desire. If we want to invoke an inner
		 * class method, we need inner object, and for outer class methods, outer
		 * object. There is a workaround. Since, inside inner class definition, inner
		 * class can invoke outer class method (unlikely from main method here), an
		 * inner class method, may simply, invoke, outer class method. getBalance would
		 * simply invoke getAmount, and vice versa. In other words to remember. Inner
		 * and outer classes can see each other's method, but only in the definition of
		 * those classes. Outside of those definitions, like here, in main method, we
		 * are not allowed to invoke any outer method by inner object. /*
		 */
	}
}
