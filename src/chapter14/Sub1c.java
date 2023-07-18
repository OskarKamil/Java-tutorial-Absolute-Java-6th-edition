package chapter14;

import java.util.ArrayList;

public class Sub1c {
	public static void main(String[] args) throws CloneNotSupportedException {

		ArrayList<Sub1d> listNames = new ArrayList<Sub1d>();
		Sub1d dog1 = new Sub1d("Sisi", 9);
		Sub1d dog2 = new Sub1d("Kaia", 6);
		Sub1d dog3 = new Sub1d("Robodog", 3);
		listNames.add(dog1);
		listNames.add(dog2);
		listNames.add(dog3);
		System.out.println(listNames); // [Sisi 9, Kaia 6, Robodog 3]

		ArrayList<Sub1d> newList = new ArrayList<>();
		for (Sub1d el : listNames) {
			newList.add((Sub1d) el.clone());
		}

		System.out.println(listNames); // [Sisi 9, Kaia 6, Robodog 3]
		System.out.println(newList); // [Sisi 9, Kaia 6, Robodog 3]

		listNames.get(0).setName("First ArrayList");
		newList.get(1).setName("Second ArrayList");

		System.out.println(listNames); // [First ArrayList 9, Kaia 6, Robodog 3]
		System.out.println(newList); // [Sisi 9, Second ArrayList 6, Robodog 3]

		/*
		 * As you can see, here we created two ArrayLists. One filled with data, and
		 * second one filled with copies of elements from first ArrayList. We used
		 * clone() method that has been overridden in Sub1d. These are deep copies and
		 * changing one doesn't affect other one.
		 */

	}
}
