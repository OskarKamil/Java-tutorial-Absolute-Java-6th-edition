package chapter11;

public class Sub3 {
	public static void main(String[] args) {
		int[] a = { -2, 0, 2, 4, 6, 8, 10, 12, 14, 16 };
		int finalIndex = 9;
		/* finalIndex is just a size of an array minus 1. */
		/*
		 * If you copy and paste code from the web or other source, or your code is a mess
		 * about indentations, you find option [Format] in [Source] option or use keyboard
		 * shortcut: [Ctrl]+[Shift]+[F] Eclipse or [Alt]+[Ctrl]+[L] IntelliJ.
		 */

		System.out.println("Array contains:");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		System.out.println();

		int result;
		int target;

		target = 0;
		result = Sub3a.searchBin(a, 0, finalIndex, target);
		System.out.println("The " + target + " is at index " + result);

		target = 8;
		result = Sub3a.searchBin(a, 0, finalIndex, target);
		System.out.println("The " + target + " is at index " + result);

		target = 55;
		result = Sub3a.searchBin(a, 0, finalIndex, target);
		System.out.println("The " + target + " is at index " + result);
		/* If the target/key is not found, the method returns -1. */

		for (int key = -3; key < 5; key++) {
			result = Sub3a.searchBin(a, 0, finalIndex, key);
			if (result >= 0)
				System.out.println(key + " is at index " + result);
			else
				System.out.println(key + " is not in the array.");
		}
		/*
		 * Here a little algorithm. It runs the binary search through all the numbers
		 * from -3 to 5 excl. If the result, this is, the index returned, is more or
		 * equal 0, it shows the real index thus the number was found, if the returned
		 * index is less than 0, namely -1 is the only option, it means the number has
		 * not been found in the array by this method.
		 */
	}
}
