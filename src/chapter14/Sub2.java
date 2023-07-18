package chapter14;
// generics

public class Sub2 {
	public static void main(String[] args) {

		Sub2a<String> obj1 = new Sub2a<String>("Test");
		/*
		 * Creating an obj1 with parameter type String and with parameter to a
		 * constructor "Test". This is generics. Will explain later.
		 */

		System.out.println(obj1.getData()); // Test
		/*
		 * To access data of an object, as usual you use a getter method. Sub2a has only
		 * one getter method, it is getData(). obj1 is an object of type Sub2a of
		 * parameter type String. So getData() returns data under that object which is a
		 * String, that's why you can use it with syso.
		 */

		obj1.setData("Changed string");
		System.out.println(obj1.getData()); // Changed string
		/*
		 * Sub2a class also have a setter to change a value of an object inside of it.
		 */

		Sub2a<Double> obj2 = new Sub2a<>(7.50);
		/*
		 * Here we created an obj2 of type Sub2a of parameter type Double and
		 * initialised it with value 7.50. Also we used type inference. A reminder: type
		 * inference is when reference type is the same and can be ommited in ArrayLists
		 * and generics.
		 */

		System.out.println(obj2.getData()); // 7.5
		/*
		 * Same with String, nothing changed.
		 */

		Sub2a<Integer> obj3 = new Sub2a<>(5);
		System.out.println(obj3.getData()); // 5
		/*
		 * Exactly the same as previous examples. What does it mean? That is the point
		 * of generics. Generics mean that you can use any allowed type (explained in
		 * latter lessons) to store in this class. Sub2a can store any type of class,
		 * setData() allows us to change the data and getData() lets us access that data
		 * and also print it in syso. Generics mean that type is not important because
		 * it is generic.
		 */
	}
	/*
	 * Have a look at definition of generic class in Sub2a.java.
	 */
}
