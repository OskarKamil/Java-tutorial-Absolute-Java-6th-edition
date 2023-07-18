package chapter6;

public class Sub1 {
	public static void main(String[] args) {

		double[] score = new double[10];
		/* Creating an array of 10 elements. */

		int[] age;
		age = new int[10];
		/* Same but in separate lines. */

		int amount = 25;

		int[] points = new int[amount];
		/* Number of elements of an array can be a variable. */

		int elements = age.length;
		/* Each array has one static const lenght. It returns size of an array. */

		age[2] = 4;
		/*
		 * Initializing 3rd element of an age array. Listing of elements starts from 0.
		 */

		int[] tests = { 2, 5, 12, 22, 11, 49 };
		/*
		 * Initializing elements of an array and defining array at the same time. length
		 * is a constant, it is, static final, and it is initialized at the same time as
		 * array is defined.
		 */

		char[] letters = { 'H', 'e', 'l', 'l', 'o' };
		String word = new String(letters);
		/*
		 * Array of type char can sometimes behave like a string. For example string
		 * constructor can take array of char as a argument and return a string type
		 * like here. Now word string is equal to "Hello".
		 */

		System.out.println(letters);
		/* Println method also will automatically cast array of char into a string. */

		String word2 = new String(letters, 0, 4);
		/*
		 * String has also another constructor with array of char. This one returns
		 * array of char, with 4 characters starting from index 0. First parameter is
		 * char array, second parameter is starting point and third parameter is number
		 * of characters.
		 */
	}
}