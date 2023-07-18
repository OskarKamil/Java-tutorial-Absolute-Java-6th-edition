package chapter16;

import java.util.Collection;
/*
 * For the following method to work, we need to import Collection. But don't worry, the IDE will do that for you or at least inform you about the error.
 */
import java.util.List;
import java.util.Set;
/*
 * These must be imported if you want to use Set<?> and List<?> interfaces. We have a method down below using Set<?> interface, also explaining the meaning of <?>.
 */

public class Sub1 {
	protected static <T> Boolean inSome(Collection<T> c1, Collection<T> c2, T target) {
		return (c1.contains(target) || c2.contains(target));
	}
	/*
	 * A method checking if T target is in either collection. Collection is an
	 * interface that is implemented by ArrayList, HashSet, HashTree, Vector,
	 * LinkedList and others. Let's analyse this method. As we learned before,
	 * interfaces can be treated as a type. So our first parameter is an object of
	 * type Collection. So it means that under this parameter we can put any object
	 * that implements Collection interface. We could put an ArrayList, LinkedList,
	 * HashSet etc. Easy to remember, collection is a group of elements, ArrayList
	 * is a group of elements. Also this collection is generic and has parameter
	 * type. Next parameter is also another collection with T parameter type and a T
	 * target. Note that target has the same type as a collections parameter type.
	 * That's because this method checks if the target is in at least one of those
	 * collections.
	 */

	protected static <T> T getFirst(List<T> sourceList) {
		if (sourceList.isEmpty())
			return null;
		else
			return sourceList.get(0);
	}
	/*
	 * This is a method using List <T> interface as a data type. As in previous
	 * example, under an interface we could put any object that implements that
	 * interface. Search for "Java collection" and get images to see that all of
	 * those lists, sets, etc are all collections. This method is actually nothing
	 * new, just a practise on how to use generics combined with Collection
	 * interfaces.
	 */

	protected static Boolean noNull(Set<?> sourceSet) {
		return (sourceSet.remove(null));
	}
	/*
	 * Here we used Set<?> interface. Exactly the same as before but with one
	 * difference. The <?> part. The "?" is a wildcard. Under <?> we can put any
	 * type that we want. It can be String, can be Date, can be Sub2 or something.
	 * In most cases <?> and <T> works exactly the same. But not always, have a look
	 * at next example.
	 */

	protected static void copy1(List<?> destination, List<?> source) {
		// instructions copying from source to destination
	}
	/*
	 * As you can see here. Destination can be any type under <?>, for example Date,
	 * and source can be also any type under <?>, for example Person. This will
	 * result in an error, you cannot copy a list of two different types. You cannot
	 * copy Persons and paste them into Dates. These are two completely different
	 * data types. One <?> can be one type and another variable with <?> can be of
	 * any other type. They are not connected any way. Have a look at next example.
	 */

	protected static <T> void copy2(List<T> destination, List<T> source) {
		// instructions copying from source to destination
	}
	/*
	 * In this example you can see that this generic method has only one parameter
	 * type. This way we enforce that both Lists (destination and source) are the
	 * same base types. Here we can safely copy data from source to destination
	 * because we know that both of those Lists has the same base type, they are
	 * bound to have the same base type.
	 */

	/*
	 * ##REMINDER##
	 * 
	 * Remember to use proper clone method override when cloning objects. Import
	 * cloneable interface. If the object doesn't have mutable objects, you can
	 * simply use super.clone() method. But if it does, you need to follow semantics
	 * for cloning method. Create clone object of the class type you want to clone.
	 * And of that new object's mutable object must have new instance of the mutable
	 * object so changing the source doesn't change the clone. Check Chapter13 Sub1g
	 * and Sub1g for more info of check the Internet.
	 */

	protected static void exampleFoo1(Collection<? extends Sub2> c1) {

	}

	protected static void exampleFoo2(Collection<? super Sub2> c1) {

	}

	protected static <T extends Sub2> void exampleFoo3(Collection<T> c1) {

	}

	// protected static <T super Sub2> void exampleFoo4(Collection<T> c1){
	//
	// }

	/*
	 * First method accepts any collection that has type Sub2 or its child classes.
	 * It is like saying that under ? can be Sub2 (Sub2 and its derived classes).
	 * You may wonder, how to let only Sub2 data types, but there is no way, because
	 * in some way child classes are equal to its parents. So in this case under ?
	 * can be Sub2 or its descendants.
	 * 
	 * Second method accepts any collection that base is a parent of Sub2.
	 * 
	 * (It is only an example, Sub2 doesn't have any parents nor children.)
	 * 
	 * Third method decides bounds on the T type at the beginning.
	 * 
	 * Forth method would not work. In Java parameter types support only upper
	 * bounds, you can use T with extends only. It would not work with super
	 * keyword.
	 * 
	 * Thing to note. Here we are talking about the base type of a collection.
	 * ArrayList<Animal> can have Animal types of object, but can also have Pets,
	 * OceanCreature etc. It this case, we mean the base type of an ArrayClass.
	 */
}