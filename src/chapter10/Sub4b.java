package chapter10;

import java.io.Serializable;

public class Sub4b implements Serializable {
	/*
	 * You may also need to save an object into a binary file. It is possible.
	 * Simply add clause "implements Serializable". No other part of the class have
	 * to be changed. This clause simply informs compiler that it is OK for an
	 * object of this class to be extracted and saved. For security and safety, only
	 * classes with serializable clause can be saved onto a binary file.
	 */

	private final String name;
	private final int age;
	// private Date bday; private Date dday;
	/*
	 * If this class has instance variables of other data types. Those data types
	 * also must be serializable. This means that Date class must be serializable.
	 * And if Date class also has other class type variables, they also must be
	 * serializable. This means, the class serializable only if all instance
	 * variables of this class are also serializable (and instance variables of that
	 * class, and so on).
	 */

	public Sub4b(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Sub4b() {
		name = "[empty]";
		age = -1;
	}

	public String toString() {
		return "Name: " + name + " Age: " + age;
	}
}