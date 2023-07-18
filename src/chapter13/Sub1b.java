package chapter13;

public abstract class Sub1b implements Sub1a {
	/*
	 * This is an abstract class that implements interface Sub1a. Remember than in
	 * order for a class to implement an interface, a class must define all method
	 * headings from an interface. This class defines only one method. This class is
	 * abstract which means this class is allowed not to define all methods. This
	 * class may contain headings of methods and derived classes will be responsible
	 * for their definition.
	 */

	public abstract boolean precedes(Object other);

	public boolean follows(Object other) {
		if (other == null)
			return false;
		if (other.getClass() != this.getClass())
			return false;
		Sub1 otherCasted = (Sub1) other;
		return otherCasted.precedes(this);
	}
	/*
	 * Note that this method invokes method precedes() which is not defined. It
	 * doesn't matter. This is an abstract class and you cannot create an object of
	 * this type anyway, you must create an object of its child, and its child must
	 * define the method. No matter what, this method will be defined at some point
	 * which makes it safe to invoke it here.
	 */
}
