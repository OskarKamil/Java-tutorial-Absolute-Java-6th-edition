package chapter13;

public class Sub1g implements Cloneable {
	/*
	 * Implementing Cloneable interface so our clone() method makes a proper copy of
	 * an object.
	 */

	private final String name;
	private final String nickname;
	private final int age;

	Sub1g() {
		name = "undefined";
		nickname = "undefined";
		age = -1;
	}

	Sub1g(String name, String nickname, int age) {
		this.name = name;
		this.nickname = nickname;
		this.age = age;
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	/*
	 * Method clone(). Simple case
	 * 
	 * First. This method returns Object because cloneable interface has this method
	 * heading and we need to define that method. The return type is Object so it's
	 * universal to implement, and then you just need to downcast to the type you
	 * want.
	 * 
	 * Second. If all instance variables of a class are immutable objects (of
	 * primitive types) or String, then you can use this method. Simply invoke
	 * super.clone() method. This invokes clone() method from your immediate
	 * ancestor, in this case, it is Object type. Object clone() method copies
	 * values of all primitive types and pastes them to the new returned copy.
	 * 
	 * Third. You need to catch an exception. But only if your immediate ancestor is
	 * Object class. Otherwise, your ancestor would be another class that you
	 * defined, and if your derived class implements cloneable, it means it will
	 * invoke clone() from its ancestor, so it means, that all ancestors must
	 * implement that interface. So basically every class must implement it and
	 * define that method. And your ancestor will be responsible for catching the
	 * exception.
	 */

	public static void main(String[] args) {
		Sub1g object1 = new Sub1g();
		Sub1g object2 = (Sub1g) object1.clone();
		/*
		 * Since the clone() method returns Object type, you need to downcast to the
		 * correct type.
		 */
	}

}

/*
 * As explained above. You do not need to catch an exception if your immediate
 * ancestor is not of an Object class. You catch an exception only if your
 * immediate ancestor is an Object class.
 */