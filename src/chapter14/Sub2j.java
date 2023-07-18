package chapter14;

public class Sub2j<T> extends Sub2c<T> {
	// unordered pair

	public Sub2j(T arg, T arg2) {
		super(arg, arg2);
		/*
		 * Sub2c has parameter type <T>. And Sub2j is a derived class of Sub2e, so it
		 * means that Sub2j also has inherited T from Sub2c. And so <T> must be in Sub2j
		 * name as well. When we say Sub2j and Sub2c, we actually mean Sub2j<T> and
		 * Sub2c<T>, paramater types are also part of the name of the class.
		 * 
		 * Here we used super constructor. Before we created him we got an error
		 * informing us that the default constructor is not present in Sub2c<T1, T2>.
		 * What does it mean? Here we have no constructors so our default constructor
		 * invokes parent default constructor, but we created a constructor in parent
		 * class, thus the default constructor is not present there.
		 * 
		 * Anyway, as inheritance works. We inherited all variables and all methods from
		 * our parent, in this constructor we could have used setFirst(firstArg) and
		 * setSecond(secondArg), but super constructor can do this for us and the result
		 * will be the same.
		 */
	}

	public boolean equals(Object otherObject) {
		/*
		 * Our Sub2c<T> class is a pair of two objects of the same parameter type.
		 * equals in Sub2c checks if two objects are the same and in the same order,
		 * this is an unordered pair class and here we check if two objects are the
		 * same, even if they are not in the same order.
		 */
		if (otherObject == null)
			return false;
		else if (otherObject.getClass() != getClass())
			return false;
		else {
			Sub2j<T> otherPair = (Sub2j<T>) otherObject;
			return (getFirst().equals(otherPair.getFirst()) && getSecond().equals(otherPair.getSecond())
					|| getFirst().equals(otherPair.getSecond()) && getSecond().equals(otherPair.getFirst()));
		}
	}

}
