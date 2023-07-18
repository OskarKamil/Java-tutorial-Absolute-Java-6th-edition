package chapter11;

public class Sub2 {
	static int power(int a, int b) {
		if (b < 0) {
			System.err.println("Illegal argument to power");
			/*
			 * You can press [Shift] + [Enter] to go to next line without breaking current
			 * line. Just a tip for faster typing using IDE and [Ctrl] + [Space].
			 */
			System.exit(0);
		}
		if (b > 0)
			return (power(a, b - 1) * b);
		else
			return (1);
	}
	/* Recursive method can also return a value. Not all recursion must be void. */

	public static void main(String[] args) {
		for (int i = 0; i < 9; i++) {
			System.out.println("3 to the power " + i + " is " + power(3, i));
		}
	}
}
