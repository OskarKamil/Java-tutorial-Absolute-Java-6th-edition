package chapter11;
/* A method that is recursive and does nothing after the recursive call but returns a value is called a tail recursion. Since recursions are slower than loops, compiler can optimize then code it runs by automatically transforming a recrusion into a loop if it is a tail recursion.
 * For example. return search(args) is tail, answer = search(args); return answer; is tail, but, return search(args)*2 is not, because this method call doesn't return the clean reutned value of a method call, it returns altered value, altered because doubled with *2. */

public class Sub3a {
	protected static int searchBin(int[] a, int first, int last, int key) {
		/* Recursive Method for Binary Search */

		int result = 0;

		if (first > last)
			result = -1;
		else {
			int mid = (first + last) / 2;

			if (key == a[mid])
				result = mid;
			else if (key < a[mid])
				result = searchBin(a, first, mid - 1, key);
			else if (key > a[mid])
				result = searchBin(a, mid + 1, last, key);
		}
		return result;
	}
	/*
	 * Explained algorithm: This method takes an array as input, starting index and
	 * last index to include in the search, and the key that is being seek. It sets
	 * result to 0 to keep compiler happy. This method cannot return an unsigned
	 * value. Then checks if first index (for example 0), is larger than last index
	 * (size of array - 1). If it is, the method ends with reurn result which is set
	 * to -1. Otherwise, it adds first and last and then divides by 2, to find the
	 * middle. Then sets mid variable to middle of the array. Then checks if the key
	 * is exactly in the middle. If so, continue with the code, which is, return
	 * statement. Otherwise check if key is smaller than the middle, if so. Recurse
	 * the search. If the key is smaller than the midde, it means that the key is
	 * not in the second half, so second half is not to be searched.
	 * 
	 * Only first half is to be searched. So invoke the method, with same and same
	 * array, but with different start and end poi nts. In fact, first point will be
	 * the same, however the last point will be different. Intuitively we would want
	 * to search from first till mid, however in previous if statement, we checked
	 * if mid is the key, and it was not. So we invoke the method with first the
	 * same and last as mid - 1.
	 * 
	 * Otherwise. Here is similar. If key is not the in the first half, it must be
	 * in the second half. Invoke method with same array and same key but with
	 * starting point mid + 1 and end point as last. Then you start from the
	 * beginning. Result is 0 again. You check if first is more than last. You run
	 * the if statements again. At some point 2 things may happen: -first will be
	 * larger than last. When you will be looking for a number in 4 indexes left. At
	 * some point you will end up with 3, then 2 indexes. Then one index. And then
	 * your method will run again with first point and last point equal. Then
	 * another invocation will either make first++ or last-- which will cause in
	 * crossing two number and will return -1. Which will indicate that the number
	 * has not been found by this method. -the number is found. This method returns
	 * int value which us assigned to result value. Which will be assigned and
	 * assigned and all stacks of the method will get closed and passed to the most
	 * outer method and will eventually return the index searched.
	 */

	protected static int searchIte(int[] a, int lowEnd, int highEnd, int key) {
		/* Iterative Method for Binary Search */

		int first = lowEnd;
		int last = highEnd;
		int mid;

		boolean found = false;
		int result = 0;

		while ((first <= last) && !(found)) {
			mid = (first + last) / 2;

			if (key == a[mid]) {
				found = true;
				result = mid;
			} else if (key < a[mid]) {
				last = mid - 1;
			} else if (key > a[mid]) {
				first = mid + 1;
			}
		}

		if (first > last)
			result = -1;
		return result;
	}
	/* Same here but with iteration not recursion. */
}
