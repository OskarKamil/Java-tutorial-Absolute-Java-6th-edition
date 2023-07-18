package chapter16;

import java.util.HashSet;

public class Sub3a {
	public static void main(String[] args) {
		HashSet<String> words = new HashSet<>();
		words.add("health");
		words.add("mana");
		words.add("level");
		words.add("experience");

		String last = null;
		for (String e : words) {
			last = e;
			System.out.println(e);
		}
		/*
		 * Iterating through a collection using foreach loop. There are two ways to
		 * iterate through a collection, using iterator or using foreach loop. Each
		 * option has its own advantages. In this case we had to create new String
		 * variable to keep track of the last object in order to remove it from the
		 * HashSet. With iterator, we didn't need to do that.
		 */

		System.out.println("\n");

		words.remove(last);

		for (String e : words)
			System.out.println(e);

	}

}
