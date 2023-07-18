package chapter14;

public class Sub2d {
	public static void main(String[] args) {
		/*
		 * Read Sub2e.java for generic class definition
		 */

		Sub2e<String, Integer> firstPair = new Sub2e<String, Integer>("Sisi", 9);
		System.out.println(firstPair);
		/*
		 * Similar to one type class, here we have 2 types.
		 */

		Sub2e<Integer, Integer> secondPair = new Sub2e<Integer, Integer>(5, 25);
		System.out.println(secondPair);
		/*
		 * In definition we have used 2 different T1 and T2, but nothing is stopping us
		 * from using two same types.
		 */
	}
}
