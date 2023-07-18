package chapter6;

public class Sub2 {

	public static void doubleArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			a[i] = a[i] * 2;
	}

	public static boolean equals(int[] a, int[] b) {
		if (a.length != b.length)
			return false;
		else
			for (int i = 0; i < a.length; i++)
				if (a[i] != b[i])
					return false;

		return false;
	}
	/* Best way to check if two int arrays are equal. */

	public static int[] negate(int[] a) {
		int[] temp = new int[a.length];
		for (int i = 0; i < a.length; i++)
			temp[i] = a[i] * (-1);
		return temp;
	}
	/*
	 * You can return a whole array. Also, you can create temp array inside if you do
	 * not wish to make changed to the parameter array.
	 */

	public static void main(String[] args) {

		Sub2a[] name = new Sub2a[10];
		/*
		 * You can also make an array of class types. Here you created indexed
		 * variables, not objects. It means that this array holds 10 variable names that
		 * could refer to objects however all of them return null, because they do not
		 * have memory addresses because no constructor had been invoked.
		 */

		for (int i = 0; i < name.length; i++)
			name[i] = new Sub2a("Sisi" + i);
		/*
		 * Here we are creating object for each index of an array. Also, here we used
		 * method of Integer wrapper class that casts int into a string.
		 */

		for (int i = 0; i < name.length; i++)
			System.out.println(name[i]);

		int[] number = { 1, 2, 3, 4, 5, 10, 20, 30, 40, 50 };

		doubleArray(number);
		for (int i = 0; i < number.length; i++)
			System.out.println(number[i]);
		/*
		 * Similar to objects. If whole array is an argument to a method invocation.
		 * Changed made to that argument also affect the array out of method bounds.
		 * Same as objects, call by reference.
		 */
	}
}