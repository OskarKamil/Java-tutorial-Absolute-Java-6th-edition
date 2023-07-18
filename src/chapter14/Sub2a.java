package chapter14;

public class Sub2a<T> {
	/*
	 * Definition of a generic class differs from standard class with <T> part. <T>
	 * is a parameter type and under T we can snip any allowed class type like
	 * String, Integer, Double or your own class too. When new object of this class
	 * is created, a type must be chosen, and that type will replace each T in the
	 * definition of this class.
	 */

	private T data;
	/*
	 * This variable of type T will be the same type as a parameter type while
	 * creating the object of this class. In previous file we used String as
	 * parameter type. String was put into T while creating this object, and String
	 * was also put in here instead of T. Now it is String data for this object, but
	 * for our next one was Double. So this data variable of T type is now Double
	 * for obj2 object, and type Integer for obj3.
	 */

	public Sub2a() {
		data = null;
	}
	/*
	 * Standard empty constructor, you can remove it if you want, not part of the
	 * lesson.
	 */

	public Sub2a(T arg) {
		data = arg;
	}
	/*
	 * Constructor with only one argument of type T. As you can guess, under T, will
	 * be pinned the same type as it was used during creating this object. In obj1
	 * it was String, so in here, T arg is in fact, String arg. And if you think
	 * about it, it makes perfect sense. Parameter type was String, and the
	 * constructor must use also type String, to save String into a T data which is
	 * also a String. That's the definition of Generics. In obj2, we chose Double
	 * parameter type, in this constructor T arg will be Double arg, and Double will
	 * be saved into T data which is Double data. Same with Integer.
	 */

	public void setData(T data) {
		this.data = data;
	}
	/*
	 * Similar to constructor.
	 */

	public T getData() {
		return data;
	}
	/*
	 * You are returning what type? String, Double, Integer? You are returning type
	 * T, whatever type is under T, that type you are returning.
	 */

}
/*
 * Easy way to remember when you use T. T is used in name of the class in the
 * heading. And in all variables that need to be the same type as the parameter
 * type. And every time you create a new variable and it needs a type. Even in
 * setData() and Sub2a() constructors the arguments must have T type, they
 * cannot be empty, they have to be T type as chosen.
 */
