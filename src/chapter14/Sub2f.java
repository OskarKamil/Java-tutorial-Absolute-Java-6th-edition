package chapter14;

public class Sub2f {
	public static void main(String[] args) {

		Sub1b obj1 = new Sub1b("Sisi", 9);
		Sub2g<Sub1b, Comparable> objGen1 = new Sub2g<Sub1b, Comparable>(obj1, 25, 50);
		/*
		 * When you look at Sub2g definition, you will see the constructor (public
		 * Sub2g(T1 first, T2 second, T2 third)), check Sub2g file. It takes T1, T2 and
		 * T2. T1 extends Sub1b, it means that the only allowed types under T1 can be
		 * Sub1b and its descendants (children classes). T2 extends Comparable, it means
		 * that unter T2 the only allowed types are those which implements Comparable.
		 * In here as T2, we used 25 and 50. They are int types and thanks to automatic
		 * boxing, java translated them into Integers, which, in fact, are Comparable.
		 */

		System.out.println(objGen1);
		System.out.println(objGen1.max());
		/*
		 * We used max() method which takes two T2 types and used comparable on them.
		 */

		Sub2g<Sub1b, Comparable> objGen2 = new Sub2g<Sub1b, Comparable>(new Sub1b("Sisi", 9), 25, 50);
		/*
		 * Here we did something similar like at the beginning, but here we used
		 * anonumous constructor. We created anonymous object and we cannot access it by
		 * reference.
		 */
	}
}
