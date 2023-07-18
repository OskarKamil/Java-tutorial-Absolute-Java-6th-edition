package chapter14;

public class Sub2g<T1 extends Sub1b, T2 extends Comparable> {
	/*
	 * T1 extends Sub1b - it means that under T1, we cannot put any type that we
	 * want. Under T1 we can put only an object which is of type Sub1b. Keep in mind
	 * that descendent classes are included too. In other words, under T1, we can
	 * put Sub1b or its children.
	 * 
	 * T2 extends Comparable - it means that under T2 we can put only a class type
	 * which implements Comparable. No object can be put under T2 which does not
	 * implement it. Further down you see that we use compareTo method. If a T2
	 * object would have not been comparable, it would not have had compareTo
	 * method, and it will result into an error. To remember it, think that this
	 * class definition (Sub2g) will use Comparable methods, and only object of
	 * Comparable interface will have that method.
	 * 
	 * A one generic type may extend a class type and an interface at the same time.
	 * We could rewrite Sub2g<T1 extend Sub1b & Comparable>, but, then, it would
	 * result in an error. Why? Because Sub1b and none of its children (it has no
	 * children btw) implement Comparable interface. If Sub1b would implement
	 * Comparable, then we would be able to do that. Note that each parameter type
	 * (T1, T2 etc) can have only one class bound and unlimited of interfaces. The
	 * rule is that the class bound must be first followed by interfaces. Example:
	 * <T1 extends Sub1b & Comparable & Cloneable & Readable &... & LastInterface,
	 * T2 Cloneable & Comparable>. Each T type can have max 1 class bound and
	 * unlimited interfaces.
	 */

	private final T1 first;
	private final T2 second;
	private final T2 third;

	public Sub2g(T1 first, T2 second, T2 third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

	@SuppressWarnings("unchecked")
	public T2 max() {
		if (second.compareTo(third) >= 0)
			return second;
		else
			return third;
	}

	public String toString() {
		return first.toString() + " " + second.toString() + " " + third.toString();
	}

}
