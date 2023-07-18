package chapter7;

public class Sub3 {

	protected String name;
	protected int age;
	
	public String toString() {
		return name + "\n" + age;
	}
	/* The green triangle sign means that this method is overridden. Here we have overridden a method Object.toString() which we inherited because all classes are derived classes of an Object. */
	
	public boolean equals(Object otherObject) {
		/* To override a method, method must have same name and same parameters. Object.equals() methods takes Object type object as a parameter so proper way is to use Object type parameter. */
		
		if (otherObject == null)
			return false;
		/* First we check if an object parameter is null. If we didn't check it would cause some errors in latter code. */
		
		if (getClass() != otherObject.getClass())
			return false;
		/* getClass() returns a "name" of the class type of the object. Here getClass() returns Sub3. otherObject.getClass() returns type of otherObject. If they are exactly the same it returns true. It is not a "name" but the only thing we need to know is that we need to use == and != operators to compare. */
		
		Sub3 other = (Sub3)otherObject;
		/* Here we cast otherObject object of type Object into Sub3 type. I don't know why or how it works but here it is. It looks like you create a new object of type Sub3 named other but instead of creating new object using keyword "new" you create a reference and cast at the same time. I don't know, just remember it. */
		return (name.equals(other.name) && age == other.age);
		/* After you cast and created maybe reference you can access name and age variables of that object. */
	}
	
}
/* You cannot access any overridden variables or methods from your ancestors other than immediate parent using super. You cannot use super.super.getName(). You cannot use super.super when you access overridden methods/variables.
 * Static final variables are also inherited with the rules of access private, public, default protected keywords.
 * Each class you create is actually a child class or an Object class. Each class you create inherits some methods and variables. One method is toString() and equals() and this is why they need to be overridden.
 *  */