package chapter14;

import java.util.ArrayList;

public class Sub1 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("First position");
		list.add("Second position");
		list.add("Another one");
		System.out.println(list);
		/*
		 * We created an ArrayList of type String and named it list. Syntax
		 * ArrayList<BaseType> name = new ArrayList<BaseType>(). ArrayList is a class
		 * and must be imported in order to use it. When you create an ArrayList object,
		 * your object (the list), has certain methods, one of them is add(). Depending
		 * on what base type is your list, you add only those objects. Here you can add
		 * only String. println() method can print whole list as argument without using
		 * for loop. Just put your ArrayList object into println(list) method. Method
		 * add() adds an object to the end of the list.
		 */

		ArrayList<String> list2 = new ArrayList<>();
		/*
		 * Slightly different definition of ArrayList. On the right side there is no
		 * base type. This definition is equal to the previous one, but it's just
		 * shorter. Java guesses that base type on right side will be the same as on
		 * left side. It is called type inference. Just shorter way to define
		 * ArrayLists.
		 */

		ArrayList<String> list3 = new ArrayList<>(40);
		/*
		 * Yet another definition. In here, in the argument in the constructor we have
		 * number 40. It is initial size of the list. When using arrays in java, their
		 * size is defined and cannot be changed. If you have array of size 10 and want
		 * to store 11 elements, you cannot do that. You need to create another array
		 * and copy all the data. ArrayList in flexible. Their size can change. You can
		 * add as many objects to the array list, and it will automatically expand
		 * without your interference. When you create an array list you can specify
		 * initial size. If initial size is small and you want to add many objects into
		 * your array list. It will automatically expand many times taking time and
		 * space for copying itself to a new array. If you know in advance that you will
		 * store tons of data, simply create large initial size like 1000 so the array
		 * will not have to expand too often. The default capacity of an ArrayList is
		 * 10.
		 */

		ArrayList<Integer> intArr = new ArrayList<Integer>(15);

		for (int i = 0; i < 10; i++)
			intArr.add(i + 1);
		System.out.println(intArr); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

		intArr.set(4, -5);
		System.out.println(intArr);
		// intArr.set(13, 22);
		/*
		 * Here we created an array list of type Integer and initial size of 15. Then we
		 * used for loop to fill first 10 indexes. Then we printed the array in
		 * println() method. Then we used new method, set(). Method set syntax is:
		 * set(index, newValue), where newValue is the same type as array list. However
		 * array list type is Integer and new set type is -5 which is int. Java does
		 * automatic unboxing. It takes int and puts it into Integer. Also the last line
		 * wouldn't work. You cannot use set() method with index which hasn't been
		 * assigned yet. The initial capacity is 15, however 13th index is empty and you
		 * can use set() method only with non empty indexes.
		 */

		System.out.println(intArr.get(9));
		/*
		 * Another method, get(). As an argument you give which element of list you want
		 * to access.
		 */

		list.clear();
		/*
		 * A method to empty the list.
		 */

		System.out.println(list); // []

		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add(0, "Zeroth");
		System.out.println(list); // [Zeroth, First, Second, Third]
		System.out.println(list.size()); // 4
		/*
		 * Method add() adds an element at the first empty index. If the list is empty,
		 * it will add element at 0th index. Then the same method will add to first
		 * empty index, 0th is taken so next empty is 1st, then 2nd and then 3rd etc.
		 * Method add() is overloaded. As first argument you can put index where you
		 * want to add an element, and second argument is the given element. Opposite to
		 * set() method, add() method adds element at the index, and shifts following
		 * elements one index further. In this example we added "Zeroth" element at 0th
		 * index and all other indexes went up. Note that array list cannot have empty
		 * spaces between elements. In array you can set 10th index to be something, but
		 * in array list you cannot. All elements in array list must be contiguous. Add
		 * method works only on indexes which are not null or first not null.
		 * 
		 * Another method, size(). It returns number of elements in array list.
		 */

	}
}
