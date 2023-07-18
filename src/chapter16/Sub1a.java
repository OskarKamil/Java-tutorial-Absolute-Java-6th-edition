package chapter16;
// HashSet<T>, hashCode(),  Vector<T> vs ArrayList<T>

public class Sub1a { // Customer
	/*
	 * Let's assume that you have a class that you want its object being able to be
	 * added to the hasMap or hashSet. In order to do that, you need to override a
	 * method hashCode. HashMap/Set stores values of objects as integers in order to
	 * store them efficiently. More explained below.
	 */

	private final String name;
	private final String address;

	public Sub1a(String newName, String newAddress) {
		name = newName;
		address = newAddress;
	}

	public String toString() {
		return name + " : " + address;
	}
	/*
	 * In order to use hashSet, your class must override toString method to produce
	 * unique name of an object. One more reason why each class should define
	 * toString() method.
	 */

	public int hashCode() {
		return this.toString().hashCode();
	}
	/*
	 * hashCode() override. hashSet/Map stores objects as int values. One of the
	 * implementations of hashCode() is to use toString() method. String class has
	 * hashCode() overridden with algorithm that translates String into hash int.
	 * One easy way is to invoke toString() with this object, and then the String
	 * returned, as as a calling object to invoke hashCode(). In this case,
	 * hashCode() is invoked with calling object of type String, so the hashCode()
	 * invocation here is not the same as this definition. This is not a recursive
	 * method, return this.toString().hashCode(); <- this hashCode() is from
	 * String.hashCode().
	 */

	public boolean equals(Object obj) {
		Sub1a other = (Sub1a) obj;
		return (other.toString().equals(this.toString()));
	}
	/*
	 * You always should override equals() method, but in this case, you MUST. When
	 * indexing an object into the hashSet, Java uses the hashCode to index the
	 * object, and then uses equals() method to check an object exists in a set. If
	 * the hashCode for two different objects is the same (which may happen, ideally
	 * it should not happen, but if it happens, performance may drop, but very
	 * slightly only), the objects will be indexed properly even if the equals
	 * method indicate that these two objects are different.
	 * 
	 * This is an example implementation of the method equals taken from the book.
	 * This is probably a bad way to implement this method and you should stick to
	 * the old way to checking if 2 objects are equals. Simply checking if they are
	 * null first, if they are the same getClass and then comparing their fields
	 * (instance variables).
	 */
}

/*
 * Vector<T>. Vector<T> is same as ArrayList<T> with few subtle differences.
 * Vector<T> is an older data structure that in newer Java versions has be
 * refitted to be part of Collection framework. It has more methods than
 * ArrayList<T> but ArrayList<T> can do exactly the same with fewer number of
 * methods. ArrayList<T> is newer and more efficient and better way to store
 * objects. You should be using ArrayList<T> only, but if you see a Vector<T>,
 * this means it's an old Java code which haven't been updated. The usage is
 * exactly the same.
 */
