package chapter16;
//maps, hashmap

import java.util.HashMap;
/* This needs to be imported in order to use HashMap. */

import java.util.Scanner;

public class Sub2 {
	public static void main(String[] args) {

		HashMap<String, Sub2a> employees = new HashMap<>(10);
		/*
		 * Creating a HashMap with initial capacity of 10. HashMap is like a Collection
		 * with generic type, for example an ArrayList<T> but in here it more like a
		 * HashSet with 2 generic types, one key and one value, namely HashMap<K,V>.
		 * Read further to understand from the example.
		 * 
		 * Each object that will be in the HashMap as a key should have method
		 * hashCode() overridden. But it's good to override anyway just to be safe.
		 */

		employees.put("Jake", new Sub2a("Jake", new Sub2b(4, 1990), new Sub2b(6, 2021)));
		employees.put("Adam", new Sub2a("Adam", new Sub2b(8, 1985), new Sub2b(1, 2021)));
		employees.put("Beth", new Sub2a("Beth", new Sub2b(2, 1999), new Sub2b(3, 2021)));
		employees.put("Jane", new Sub2a("Jane", new Sub2b(7, 1965), new Sub2b(6, 2021)));
		employees.put("Jane", new Sub2a("Jane", new Sub2b(0, 0000), new Sub2b(0, 0000)));
		/*
		 * We added to this HashMap 5 entries using calling object employees and method
		 * put() to add an element to the map. First argument is a String: "Jake",
		 * "Adam" or any other Key <K> that will identify a Value <V>. Another argument
		 * is that value. In the definition of employees our second argument was Sub2a
		 * type. And in here we created Sub2a object as an argument using its
		 * constructor, and 2 other constructors of type Sub2b which are part of the
		 * Sub2a constructor.
		 * 
		 * Notice that last entry has the same Key <K> ("Jane") as one entry before it.
		 * In HashMaps, keys cannot be the same with different values. If duplicate
		 * occurs, the old entry will be overwritten with the new entry and the first
		 * will be lost. In this case, key "Jane" maps to values 0, 0000, 0, 0000.
		 */

		employees.put(null, new Sub2a("Default", new Sub2b(1, 2000), new Sub2b(1, 2000)));
		/*
		 * HashMaps allow for a key to be null.
		 */

		Sub2a emp1 = new Sub2a("James Bond", new Sub2b(0, 0), new Sub2b(0, 7));
		employees.put("007", emp1);

		System.out.println(employees.get("007")); // James Bond 0 0 0 7
		employees.get("007").name = "change1";
		System.out.println(employees.get("007")); // change1 0 0 0 7
		emp1.name = "change2";
		System.out.println(employees.get("007")); // change2 0 0 0 7
		/*
		 * We created new object and then added it to the HashMap with the key "007" and
		 * the object as the value. First print shows initial state, second print shows
		 * change of the name through accessing it from the employees HashMap and thing
		 * print shows another change when it took place by changing the name via object
		 * name reference. Changes to the object also changes value to that one in the
		 * HashMap.
		 */

		System.out.println("*Added entries to the map.*\n");

		{
			Scanner keyboard = new Scanner(System.in);
			String name = "";
			do {
				System.out.println("Enter an employee name. Leave empty to exit.");
				name = keyboard.nextLine();

				if (employees.containsKey(name))
					System.out.println(employees.get(name).toString() + "\n");
				else if (!name.equals(""))
					System.out.println("NOT FOUND.\n");

			} while (!name.equals(""));
			keyboard.close();
		}
		/*
		 * Just a standard example of how it would work. Nothing new in here.
		 */

		HashMap<Sub2a, String> employees2 = new HashMap<Sub2a, String>(16, 0.75f);
		/*
		 * A little bit different initialisation of HashMap. As you know Java has type
		 * inference. This means that during constructor you can omit parameter types
		 * given on the left side of equal sign. Different here is also parameters.
		 * First one is initial capacity, just like in ArrayLists. In ArrayList initial
		 * capacity is 10, here by default initial capacity is 16. Another parameter
		 * here is 0.75f. This argument is a load factor and by default it is 0.75
		 * (75%). What it means, it means that if a HashMap is filled to 75% (in this
		 * case, 12 indexes), the size of this HashMap will double (to 36 indexes). When
		 * it happens all indexes are moved to the new created doubled HashMap and all
		 * instances are rehashed. Like with ArrayList, it is good to choose initial
		 * capacity well so the HashMap doesn't have to double too often which will
		 * result in a performance drop.
		 * 
		 * What you noted here, one thing is that parameter types here are inverted
		 * compared to the first HashMap. In here, as a key we used the Sub2a type, and
		 * a value as a String. This is valid and quiet common. But do not worry, the
		 * way it works is pretty the same.
		 */

	}

}
