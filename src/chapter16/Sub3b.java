package chapter16;

import java.util.ArrayList;
import java.util.ListIterator;
/*
 * ListIterator extends Iterator with more methods such as previous(), hasPrevious(), nextIndex(), previousIndex(), add(), set(). In API documentation you will see that ListIterator can change the collection and Iterator cannot. You see both of them has method remove() so they can change collection. When they say ListIterator can change collection, they refer to the method set(). They can replace on value of a collection.
 */

public class Sub3b {
	public static void main(String[] args) {
		ArrayList<Sub3c> dateList = new ArrayList<Sub3c>();
		dateList.add(new Sub3c(11, 9, 2001));
		dateList.add(new Sub3c(1, 1, 2004));
		dateList.add(new Sub3c(24, 1, 1997));
		dateList.add(new Sub3c(28, 11, 1979));
		System.out.println(dateList);

		Sub3c tempDate = null;
		ListIterator<Sub3c> i = dateList.listIterator();
		while (i.hasNext()) {
			tempDate = i.next();
			tempDate.setDate(420, 69, 8008135);
		}
		/*
		 * For LinkedList, you can use both Iterator and ListIterator. ListIterator has
		 * more methods which are useful and only usable with Lists. Since lists have
		 * indexes, ListIterator has methods to return number of an index and traverse
		 * forward and backward withing indexes, but for Sets, their order elements is
		 * random and they do not have indexes, they simply exist in random. When you
		 * use iterator, the next() method can return a copy of an object from the
		 * collection or can return a reference (deep copy and shallow copy). For the
		 * standard predefined collections, they return shallow copy (reference), so if
		 * they are mutable, and you decide to change their values using setter, it will
		 * change the original object too (they are in fact original object). This is
		 * actually a good feature for quick edits while traversing a list.
		 */

		System.out.println(dateList);

	}

}
