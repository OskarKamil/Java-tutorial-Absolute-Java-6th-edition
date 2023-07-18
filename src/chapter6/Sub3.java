package chapter6;

public class Sub3 {

	enum Level {
		EASY, MEDIUM, HARD
	}
	/*
	 * Enums are like arrays and classes combined. THey got methods like classes,
	 * and they got indexed variables but the values are fixed and can be chosen
	 * from the list only.
	 */

	private final Sub3a[] numVisits;
	/* An array that stores objects instead of primitive types. */

	public Sub3(Sub3 copee) {
		this.numVisits = new Sub3a[copee.numVisits.length];
		for (int i = 0; i < this.numVisits.length; i++)
			this.numVisits[i] = new Sub3a(copee.numVisits[i]);
	}
	/*
	 * Copy constructor.
	 * 
	 * First. Parameter is object of the same type, usual.
	 * 
	 * Second. You need to copy all values of one object to another. If you got a
	 * primitive type, it is easy. If you got other classes as variables. You need
	 * to return value using constructors, you cannot return as primitive types
	 * because objects are passed by reference. Instead you need to create copy
	 * constructor and copy values. Same here. But here you have an array. First
	 * part of creating an array is to set a size of an array. this.numVisits is
	 * this array. new Sub3a[copee.numVisits.lenght]. it creates indexed variables
	 * for an array, in other words, it sets the size of the array. Takes size of
	 * copee.numVisits.lenght.
	 * 
	 * Third. You need to copy each indexed variable from one to another. If it was
	 * primitie type, like an array of int or doubles. You could simply put for
	 * loop, and this.visits[i] = that.visits[i]; However. This is class type. And
	 * each indexed variable is actually each object. Array is group of variables,
	 * if it is class variables, it is basically a group of objects. And each
	 * objects created must be invoked with constructor. So this is why code looks
	 * like this. this.numVisits[i] - because each indexed variable. new Sub3a
	 * because this is a constructor. And here we create new object, so we MUST use
	 * constructor. It depends on the constructor of Sub3a. But in here, Sub3a copy
	 * constructor takes object of self. So (copee.numVisits[i]) is an argument to
	 * the constructor saying which object to copy. index [i] of an array numVisits
	 * from copee parameter from method name. If it wasn't an array but single
	 * object, the code would look like that: this.numVisit = new
	 * Sub3a(copee.numVisit) - first we put name of our private Sub3a variable named
	 * numVisit, then constructor new Sub3a and parameter inside of which copied.
	 * copee is Sub3 type and it's got it's own numVisit variable of type Sub3a
	 * which can be copied with copy constructor.
	 */

	public static void doubleValues(double[] array) {
		for (double element : array) {
			System.out.println("Doubling " + element + " will return " + (element * 2));
		}
		/*
		 * For each loop or enhanced for loop. Syntax: for(typeofarray arrayelement:
		 * nameofarray). This for loop iterates each variable of an array and passes the
		 * reference into arrayelement variable. With each iteration this variable
		 * changes value to another variable of an array. Easier to use than standard
		 * for loop. Useful when you don't need number of iterations.
		 */
	}

	public static void sumNum(int... arg) {
		if (arg.length == 0)
			System.out.println("No values.");
		else {
			int sum = 0;
			for (int ele : arg) {
				sum = sum + ele;
			}
			System.out.println("Sum of the numbers is: " + sum);
		}
	}
	/*
	 * (int... arg) Means that the number of int arguments will vary. All argument
	 * passed by int... are passed by value into an array. This method created an
	 * array name arg and elements are all the parameters. In body of this method
	 * we check if any arguments have been passed. int... name - means that even
	 * zero number of parameters could be passed. If we need our method to pass at
	 * least one value, we need to define method (int num1, int... arg). This way at
	 * least one argument must be passed. Name of this is vararg specification
	 * (vararg for various arguments - various number of arguments). The rule is,
	 * only one vararg per method definition and the vararg must be the last in
	 * order. There cannot be two varargs in one method, even if they have 2
	 * different types, String and int, only one vararg per method.
	 */

	public static void main(String[] args) {

		double[] weight = { 50.0, 75.0, 25.0, 25.25, 75.25 };

		doubleValues(weight);
		/* Passing whole array to a method. A method parameter can be an array. */

		sumNum(1, 9, 11, 9, 20);
		sumNum(1, 2, 7);
		sumNum();

		Level level01 = Level.HARD;
		Level level03 = Level.EASY;
		Level level10 = Level.HARD;
		if (level01 == level10)
			System.out.println("Same difficulty");
		/* Creating new enum variables. They can be also used in switch statement. */

	}
}

/*
 * For partially filled arrays, you can use constant or any number that will be
 * large enough to store as much data as needed. To indicate end of data, make a
 * distinguishable value like a negative number.
 */