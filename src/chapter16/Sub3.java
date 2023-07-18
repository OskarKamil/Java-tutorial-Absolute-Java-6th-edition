package chapter16;

import java.util.HashSet;
import java.util.Iterator;
/* New class name is imported. It is needed in order to use Iterator. */

public class Sub3 {
	public static void main(String[] args) {
		HashSet<String> itemNames = new HashSet<String>(); // default capacity 16
		itemNames.add("Life Potion");
		itemNames.add("Mana Potion");
		itemNames.add("Wooden Sword");
		itemNames.add("Rope");
		itemNames.add("Apple");
		itemNames.add("Small Shield");
		itemNames.add("Bread");

		System.out.println(itemNames);
		/*
		 * HashSet can be printed easily by putting instance of HashSet in syso method.
		 * This method doesn't use Iterator class.
		 */

		Iterator<String> i = itemNames.iterator();
		/*
		 * Creation of an Iterator. Iterator uses generics feature and can be of any
		 * type. It must be the same type as a collection parameter type in order to
		 * work properly. Our HashSet uses String objects and in here we have Iterator
		 * with String parameter type. Iterator is like list[i].
		 */

		while (i.hasNext())
			System.out.println(i.next());
		/*
		 * Example of iterating through a whole collection using Iterator. Variable i is
		 * our Iterator and it has few methods to use. One of them is hasNext(), it
		 * simply returns true/false depending if the instance of collection has more
		 * objects to iterate throught. Another method is next() which simply returns
		 * <T> type, in here String, object. Another method is remove().
		 */

		i.remove();
		// i.remove(); error
		i = itemNames.iterator();
		while (i.hasNext())
			System.out.println(i.next());
		/*
		 * First we removed last object that has been returned. Method remove() returns
		 * last object that has been returned by the iterator, in next lines we will
		 * iterate through the HashSet again and you will see the last element gone.
		 * Thing to note, you can invoke remove() only once in a row. Invoking it again
		 * would cause an error (exception).
		 * 
		 * Second. In our previous while loop, our iterator reached the end of the
		 * HashSet, so it returned false from hasNext() method. To "reset" iterator to
		 * the beginning, we simply invoke the method iterator() again and it will
		 * create a new iterator that will iterate our HashSet from the beginning.
		 */

	}
}
