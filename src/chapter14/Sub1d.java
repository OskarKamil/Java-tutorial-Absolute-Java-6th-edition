package chapter14;

public class Sub1d implements Cloneable {
	private String name;
	private final int age;

	Sub1d(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void setName(String newName) {
		name = newName;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	/*
	 * Since this class is an immediate descendant of Object class, this clone()
	 * method must catch an exception. Or, you could simply state that this method
	 * throws an exception and then you wouldn't have to catch it. But then, you
	 * would have to catch it where this method is invoked, or simply, state that
	 * main method throws an exception again and never actually catch it.
	 */

	public String toString() {
		return name + " " + age;
	}

}
