package chapter14;

public class Sub2e<T1, T2> {
	/*
	 * Here generic class definition with two type parameters. One under T1 and
	 * another type under T2.
	 */

	private T1 first;
	private T2 second;
	/*
	 * Two variables of two different generic types.
	 */

	public Sub2e(T1 firstArg, T2 secondArg) {
		first = firstArg;
		second = secondArg;
	}

	void setFirst(T1 newFirst) {
		first = newFirst;
	}

	void setSecond(T2 newSecond) {
		second = newSecond;
	}

	T1 getFirst() {
		return first;
	}

	T2 getSecond() {
		return second;
	}

	public String toString() {
		return "First: " + first.toString() + "\nSecond: " + second.toString() + "\n";
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (getClass() != obj.getClass())
			return false;
		else {
			Sub2e<T1, T2> otherObj = (Sub2e<T1, T2>) obj;
			return (first.equals(otherObj.first) && second.equals(otherObj.second));
		}
		/*
		 * Intuitively looks similar to a method from Sub2c. When using equals method,
		 * you need to create new variable and cast Object obj into your own type, and
		 * angle parenthesis are part of the class type. Here you cast into Sub2e<T1,
		 * T2>, <- this is a type.
		 */
	}

}
