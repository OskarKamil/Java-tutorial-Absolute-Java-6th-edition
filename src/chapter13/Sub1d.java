package chapter13;

public class Sub1d {
	/*
	 * Example of usage of Comparable interface as a data type. Here showed the
	 * selection sort algorithm for all data types which implement Comparable
	 * interface.
	 */

	static void sort(Comparable[] a) {
		/*
		 * This method "sort", takes a Comparable array as an argument. What does it
		 * mean? That for Comparable parameter - any data type that implements
		 * Comparable interface may be be snipped here. For example if you look up
		 * String data type in Java documentation. You will see that String implements
		 * Comparable interface. Thus you can use String[] as an argument. int, double
		 * are primitive types and they do not implement that interface. However,
		 * wrapper classes Integer and Dobule do. They are data types of which variables
		 * are objects, and they do, however, implement Comparable interface. Thus under
		 * Comparable[] parameter you can also use Integer[] or Double[] array.
		 */

		for (int i = 0; i < a.length - 1; i++) {
			int indexMin = i;
			for (int ii = i + 1; ii < a.length; ii++) {
				if (a[ii].compareTo(a[indexMin]) < 0) {
					indexMin = ii;
				}
			}
			/*
			 * compareTo() method. This method is a part of Comparable interface. All data
			 * types, this is, classes, that implement this interface, must define this
			 * method. Thus here a[] parameter is of comparable interface type here, and it
			 * must contain compareTo method. Here we are using it to compare with another
			 * index of a[] parameter which can be Double, String, or any other class which
			 * implements Comparable interface.
			 * 
			 * a.compareTo(b) < 0. value < 0 means that first value is smaller than second
			 * one. method == 0 means that both values are equal. method > 0 means that
			 * first value is larger than second one. Easy way to remember: replace in your
			 * mind compareTo with the comparison symbol <, >, or ==. For example
			 * a.compareTo(b) < 0. Replace compareTo with < and then you will have a < b.
			 * Simply put the comparison symbol between two values and you will see what
			 * result will be of that if statement.
			 */

			Comparable tempValue = a[i];
			a[i] = a[indexMin];
			a[indexMin] = tempValue;
			/*
			 * Comparable can be a data type. Here we don't know what data type is under
			 * a[i]. It can be a String, Double, or our own defined class which implements
			 * Comparable. And we cannot save a[i] to a Double because what if it is not
			 * Double, same with String, we cannot predict if it is String, it could be some
			 * random class that implements Comparable. That way we use Comparable as a data
			 * type. We save the a[i] which is of Comparable type because "a" is of
			 * comparable type (look the method arguments, a is type of Comparable) and save
			 * that Comparable type into another Comparable.
			 */
		}

	}

	public static void main(String[] args) {
		Integer[] a = { 12, 15, 0, -23, 99, 75, 100, 50, 25, 1, 420, 69 };
		String[] b = { "Oskar", "Kasper", "Ela", "Darek", "Sisi", "Kaja" };
		sort(a);
		sort(b);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		for (int i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");
		/*
		 * The advantage of interfaces is that the data types that implement it, and
		 * follow the semantics, can be used generally and universally. It gives us
		 * universality of the code for different data types. Your method may take any
		 * Comparable data type and call methods on them. Doesn't matter what type they
		 * are, those types must implement that interface and those types have all
		 * neccessary methods that you will need to use.
		 */
	}
}