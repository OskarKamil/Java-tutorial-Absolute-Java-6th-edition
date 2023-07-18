package chapter14;

import java.util.ArrayList;

public class Sub1a {
	public static void main(String[] args) {
		ArrayList<Sub1b> listNames = new ArrayList<>();
		/*
		 * ArrayList of Sub1b objects.
		 */

		Sub1b dog1 = new Sub1b("Sisi", 9);
		listNames.add(dog1);
		Sub1b dog2 = new Sub1b("Kaja", 6);
		listNames.add(dog2);
		/*
		 * Since this ArrayList stores non primitive data types, to add an object of
		 * Sub1b, you need to create object first, and then add that reference to the
		 * arraylist.
		 */

		dog1.setName("Sisunia");
		dog2.setName("Kajunia");
		System.out.println(listNames);
		/*
		 * ArrayList holds dog1 and dog2 inside. Changing the object via its reference
		 * name like dog1 or dog2, will also change the object in the ArrayList since
		 * it's the same object and they hold the same memory address.
		 */

		listNames.get(0).setAge(99);
		/*
		 * Method get(index) returns the element, in this case, it returns Sub1b object,
		 * and this object is dog1, and dog1 has setAge() method, here you can make
		 * changes to the object accessing it through ArrayList.
		 */

		System.out.println(listNames.add(new Sub1b("Robodog", 24)));
		/*
		 * A method add() actually returns boolean value. Returns true if added
		 * successfully and false otherwise. Only add(object) is boolean. add(index,
		 * object) is void method. Both methods are used as void, no one usually checks
		 * if it is added successfully.
		 * 
		 * Here we added new object throught anonymous variable. We didn't create new
		 * dog3. This object exists only inside the ArrayList, and is not associated
		 * with any reference, variable name. Not the best way to do it, but it is
		 * possible.
		 */
		System.out.println(listNames);

		System.out.println(listNames.set(2, new Sub1b("Robocat", 24)));
		/*
		 * Method set(index, new object) sets to new object. It also returns old object
		 * at this index, in this case, Robodog, 24. But this method is usually used as
		 * void method to simply change object at an index.
		 * 
		 * Instead we could create dog3 and set to it.
		 */

		System.out.println(listNames); // [Sisunia 99, Kajunia 6, Robocat 24]
		dog1.setAge(9);
		listNames.remove(listNames.size() - 1);
		/*
		 * Easy way to remove last element. Invoke method remove(), then method size(),
		 * substract 1, and you will get an index of last element, and that last element
		 * will be removed.
		 */

		System.out.println(listNames); // [Sisunia 9, Kajunia 6]

		/*
		 * List of other most common methods. For more, check documentation or online.
		 * 
		 * public Base_Type remove(int index
		 * 
		 * protected void removeRange(int fromIndex, int toIndex)
		 * 
		 * public boolean remove(Object theElement)
		 * 
		 * public void clear()
		 * 
		 * public boolean contains(Object target)
		 * 
		 * public int indexOf(Object target)
		 * 
		 * public int lastIndexOf(Object target)
		 * 
		 * public boolean isEmpty()
		 * 
		 * public int size()
		 * 
		 * public void ensureCapacity(int newCapacity)
		 * 
		 * public void trimToSize()
		 * 
		 * public Object[] toArray()
		 * 
		 * public Type[] toArray( Type[] a)
		 * 
		 * public <Type> Type[] toArray( Type[] a)
		 * 
		 * public Object clone()
		 * 
		 * public boolean equals(Object other)
		 */
	}
}
