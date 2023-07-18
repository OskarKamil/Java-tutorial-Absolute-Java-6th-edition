package chapter14;

public class Sub2i<T> {

	private final T data;

	public Sub2i(T data) {
		this.data = data;
	}

	public <ViewerType> void showTo(ViewerType viewer) {
		System.out.println("Hello " + viewer);
		System.out.println("Data is " + data);
	}
	/*
	 * This is a generic method. This class has one <T> parameter type, this method
	 * creates another parameter type named <ViewerType>.
	 */

	public static void main(String[] args) {
		Integer obj1 = new Integer(25);

		String word = Sub2h.tryToString(obj1);
		/*
		 * The syntax here may be new. First we create new String. Then on the right, we
		 * are trying to invoke a method from another class. To do that, we always
		 * specify the class name, so, first is Sub2h, then "." and then we enter method
		 * name. It is important to remember that <T> is part of class name, so is a
		 * part of method name, that's why after "." we have "<Integer>tryToString".
		 */
		System.out.println(word);

	}
}
