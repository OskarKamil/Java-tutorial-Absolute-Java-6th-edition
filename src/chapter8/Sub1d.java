package chapter8;

public class Sub1d {

	public static void upcasting(Sub1 otherObject) {
		/* It can take any object of type Sub1 (and its child clases). */
		if (otherObject == null)
			System.exit(0);

		Sub1 thisObject = otherObject;
		// thisObject.eat();
		/*
		 * This is upcasting. From child class into a parent class. Here otherObject may
		 * be a type of any derived classes. For example, it may be Sub1c. So here we
		 * cast it into Sub1. Upcasting is casting to a parent level. To remember
		 * easily: UP casting to parent level, because is UP is like BIG, and parents
		 * are big.
		 */
		/*
		 * Upcasting is helpful if a method can take as a parameter an argument of any
		 * type of Animal object or any derived classes. For example a method can take
		 * an Animal object, or Dog, or Cat. In general, it takes an Animal object, but
		 * if it is a derived class, it needs to upcast like from Dog to Animal.
		 */
	}

	public static void downcasting(Object otherObject) {
		/*
		 * It can take any object of type Object and its child classes. (so basically any
		 * Object)
		 */
		if (otherObject == null)
			System.exit(0);

		if (otherObject instanceof Sub1a) {
			Sub1a thisObject = (Sub1a) otherObject;
			/*
			 * Here this method takes as a parameter any object. Then we check if null. And
			 * then we check if that object is an instance of Sub1. This means, if this
			 * object is Sub1a or any of its children. If it was Sub1, it would return
			 * false, but if it was Sub1, it would return true. Same if Sub1a had any
			 * derived classes it would also return true for them. Remember, instance of
			 * checks if object1 is type of object2 or their derived classes. It is
			 * important to check this, because it may cause an error if you try to
			 * downcast. Upcasting is easy and doesn't cause errors. However, downcasting
			 * sometimes may cause errors. You cannot for example cast Sub1a into Sub1c. You
			 * can cost downwards from parent to a child, but only if it makes sense.
			 */
		}
	}

}
