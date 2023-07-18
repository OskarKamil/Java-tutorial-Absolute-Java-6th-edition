package chapter14;

public class Sub1b {
	private String name;
	private int age;

	Sub1b(String name, int age) {
		this.name = name;
		this.age = age;
	}

	String getName() {
		return name;
	}

	int getAge() {
		return age;
	}

	void setName(String name) {
		this.name = name;
	}

	void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return getName() + " " + getAge();
	}
	/*
	 * Example of why method toString() must be present in all classes. When you
	 * have objects in ArrayLists, very often you want to print them in syso, and
	 * objects are not primitive types, you need to define how you want them to be
	 * displayed as a text, that's the point of toString() method. An object
	 * represented as a text.
	 */

}
