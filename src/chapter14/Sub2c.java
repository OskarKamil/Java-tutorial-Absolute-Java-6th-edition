package chapter14;

public class Sub2c<T> {
	private T first;
	private T second;
	/*
	 * Generics with 2 private variables of both generic T type.
	 */

	public Sub2c() {
		first = null;
		second = null;
	}

	public Sub2c(T firstItem, T secondItem) {
		first = firstItem;
		second = secondItem;
	}
	/*
	 * T must be before each variable.
	 */

	public void setFirst(T firstItem) {
		first = firstItem;
	}

	public void setSecond(T secondItem) {
		second = secondItem;
	}

	public T getFirst() {
		return first;
	}

	public T getSecond() {
		return second;
	}

	public String toString() {
		return "first: " + first.toString() + "\nsecond: " + second.toString();
		/*
		 * Remember that under T may be any type. If it was String, we could have simply
		 * used first instead of first.toString(), but, remember that it may not always
		 * be String, it may be Date, Person etc, and if you want to print that object,
		 * you should use toString() method which will return object as a text.
		 */
	}

	public boolean equals(Object otherObject) {
		if (otherObject == null)
			return false;
		else if (getClass() != otherObject.getClass())
			return false;
		else {
			Sub2c<T> otherPair = (Sub2c<T>) otherObject;
			return (first.equals(otherPair.first) && second.equals(otherPair.second));
		}
	}
	/*
	 * In previous chapters we said that a proper class should have constructors,
	 * getters, setters, toString method and equals method. Now you understand why.
	 * equals() method have the same strategy every time. First we use Object
	 * parameter. Then we check if it is null, then if the class is the same, and
	 * then create new object and we cast it. (Sub2c<T>) otherObject is casting from
	 * Object type into Sub2c<T> type. You always cast to the type of the class,
	 * Sub2<T> is the full type, not Sub2c, proper type of this class is Sub2c<T>,
	 * parameter T is also part of the type. And you create new object of type
	 * Sub2<T> otherPair and on right said Object casted. Then you return boolean
	 * value checking if all instance variables of one object are equal to the other
	 * object. First you check if first.equals(otherPaid.first). Why used equals()
	 * here instead of ==? Because you are never sure if first is int or double. In
	 * fact, they will never be because under T you cannot put primitive types.
	 * Under T must be always class type, and class type variables are object, and
	 * you do not compare objects with ==, you compare objects with equals() method.
	 * That's why here you compare first to otherPair.first with equals method. They
	 * are both objects and need to be compared with equals. Similar to toString,
	 * they are objects and they must invoke toString() method so they can return
	 * String value.
	 */

}
