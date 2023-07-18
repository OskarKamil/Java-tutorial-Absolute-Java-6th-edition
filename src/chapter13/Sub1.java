package chapter13;

public class Sub1 implements Sub1a {
	/*
	 * If you want your class to implement an interface, add keyword implements to
	 * the class name followed by name of the interface, and then you have it. When
	 * a class implements interface, it means that this class must define all
	 * methods listed in the interface. This class for example must define methods
	 * "precedes" and "follows".
	 * 
	 * Your class may implement more than one interface, you can separate them with
	 * commas: "Sub1 implements Sub1a, Sub2b"
	 */

	// private String name;
	private final int pay;

	public Sub1(String name, int pay) {
		// this.name = name;
		this.pay = pay;
	}

	public int getPay() {
		return this.pay;
	}

	public boolean precedes(Object other) {
		if (other == null)
			return false;
		if (other.getClass() != this.getClass())
			return false;
		/*
		 * We could have also used "instanceof" keyword here. But this would also
		 * account for children of other object. Which could be an error, or not
		 * necceserarily. Depending on how the code is build. In this case we used
		 * getClass() to get exactly the same class. If we used "instanceof" we would
		 * also include the derived classes.
		 */
		// other.getPay(); this will not work because you need to cast first
		Sub1 otherCasted = (Sub1) other;
		return this.getPay() < otherCasted.getPay();
		/*
		 * Remember. Before doing any actions on objects in method from parameters you
		 * need to check if they are null, otherwise calling their methods will result
		 * in an exception.
		 * 
		 * In here example we are checking if the pay precedes (is less) than other
		 * objects. So we need to access the getter method to get pay value and then
		 * compare them. For that we need to check if the parameter object is the same
		 * class as the one we are comparing. Here we are using getClass() method which
		 * will return the name of the class that the object is, both for parameter
		 * object and the calling object.
		 * 
		 * other.getClass() in the runtime returns Sub1. Why? Because in the runtime our
		 * argument is an object of type Sub1. And however Object is the type of
		 * parameter that we put as parameter. Need to cast this object (if possible,
		 * checking previous if statement get class) to our desired class type. It makes
		 * sense if you think what can be under that object. String, Person, Date, Car?
		 * Syntax and compiler doesn't know, it treats this object as object as long as
		 * we don't downcast it. And from that moment we can treat it as the object
		 * casted. From runtime point of view, and in this specific example, it will be
		 * a valid Sub1 object type.
		 * 
		 * Then we downcast to Sub1 and then we make operations on this object returning
		 * a boolean value from operation < with getPay() method.
		 * 
		 * Interfaces are similar to base classes. Instead of word object in the
		 * parameter, you could have used Sub1a. Each class can have only one immediate
		 * parent. However with interfaces. Each class can have multiple interfaces.
		 * This method definition could have looked like this: public boolean
		 * precedes(Sub1a other), however this is not normally preferably because you
		 * still have to account for null object, same type (or instance of) in case of
		 * getPay() method. So it is always better to use Object as default type of
		 * parameter.
		 */
	}

	public boolean follows(Object other) {
		if (other == null)
			return false;
		if (other.getClass() != this.getClass())
			return false;
		Sub1 otherCasted = (Sub1) other;
		return otherCasted.precedes(this);
		/*
		 * Here we did a fancy thing. We used previously defined method. Precedes checks
		 * if calling object is smaller than argument. To check if the calling object is
		 * actually larger, we can swap the order in the method and make it return
		 * boolean value with original calling object as argument to the first method
		 * and argument as calling objects.
		 */
	}

	public static void main(String[] args) {

		Sub1 obj1 = new Sub1("Mike", 14);
		Sub1 obj2 = new Sub1("Jack", 15);
		Sub1 obj3 = new Sub1("Mary", 14);

		Sub1 temp0 = obj1;
		Sub1 temp1 = obj2;
		/*
		 * Example of usage of references. You got 3 objects and you use reference to
		 * use alternative name to make operations on them. In future code you can make
		 * some if statements to check which object is bigger and then reference that
		 * object to temp0 and make operations to that temp0 which in effect will also
		 * effect the original object.
		 */
		System.out.println("Is " + temp0.getPay() + " less than " + temp1.getPay() + "?");
		System.out.println(temp0.precedes(temp1));
	}
}