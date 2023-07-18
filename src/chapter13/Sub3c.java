package chapter13;

public class Sub3c {
	private class Sub3cInner {
		private final long pounds;
		private final int pences;

		Sub3cInner(long pounds, int pences) {
			this.pounds = pounds;
			this.pences = pences;
		}

		public String getBalance() {
			if (obj1.pences > 9)
				return ("inner method\n" + obj1.pounds + "." + obj1.pences);
			else
				return ("inner method\n" + obj1.pounds + ".0" + obj1.pences);
		}
	}

	Sub3cInner obj1;

	Sub3c(long pounds, int pences) {
		obj1 = new Sub3cInner(pounds, pences);
	}

	public void showBalance() {
		System.out.println(obj1.getBalance());
		System.out.println();
		System.out.println(Sub3c.this.getBalance());
	}
	/*
	 * You are trying to invoke a method getBalance(). Usually it is invoked from
	 * the inner class, but if you need it to be invoked from the outer class, you
	 * need to add the class name, like here, Sub3c.this.betBalance() to say from
	 * where you need this to be invoked.
	 * 
	 * When you invoke a method in an inner class, and that inner class doesn't have
	 * that method, then it will look for that method in an outer class.
	 */

	public String getBalance() {
		if (obj1.pences > 9)
			return ("outer method\n" + obj1.pounds + "." + obj1.pences);
		else
			return ("outer method\n" + obj1.pounds + ".0" + obj1.pences);
	}

	public static void main(String[] args) {
		Sub3c obj1 = new Sub3c(12, 99);
		obj1.showBalance();

	}
}
/*
 * Within the definition of a method of an inner class, it is legal to reference
 * a private instance variable of the outer class and to invoke a private method
 * of the outer class. To facilitate this, Java follows this convention: If a
 * method is invoked in an inner class and the inner class has no such method,
 * then it is assumed to be an invocation of the method by that name in the
 * outer class. (If the outer class also has no method by that name, that is, of
 * course, an error.) Similarly, an inner class can use the name of an instance
 * variable of the outer class. The reverse situation, invoking a method of the
 * inner class from the outer class, is not so simple. To invoke a (nonstatic)
 * method of the inner class from within a method of the outer class, you need
 * an object of the inner class to use as a calling object, as we do in Display
 * 13.9.
 * 
 * In other words. You can easily access methods and variables of outer class
 * from withing inner class definityion. But other way around is more complex.
 * To access inner class variables and methods, obviously, you need an object of
 * an inner class. You cannot access inner class variables if the object of that
 * class doesn't exist.
 */