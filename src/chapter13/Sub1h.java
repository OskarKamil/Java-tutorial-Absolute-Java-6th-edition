package chapter13;

import java.util.ArrayList;

public class Sub1h implements Cloneable {

	private String name;
	private int age;
	private ArrayList<String> friends;
	/*
	 * ArrayLists are not covered yet, but treat this friends variable as some kind
	 * of object of type Data or Person who is mutable.
	 */

	// constructors

	public Object clone() {

		try {
			Sub1h copy = (Sub1h) super.clone();
			copy.friends = (ArrayList<String>) friends.clone();
			return copy;
		} catch (CloneNotSupportedException e) {
			return null;
		}
		/*
		 * Here is an example of clone method with mutable objects.
		 * 
		 * First. You create a variable of the same type as your class. Then it looks
		 * like first method combined here. You need to invoke super.clone() of the
		 * ancestor, which will eventually lead to Object.clone() which will copy all
		 * data of primitive types. And you store that data in copy variable (you also
		 * need to downcast).
		 * 
		 * Second. One of your variables, is a mutable object, it is, friends variable
		 * (here it is ArrayList, but it could also be, Data dob or Address homeadd. It
		 * could be any other mutable object. Here you need to use copy.friends which is
		 * a mutable object of the new created variable, and on the right side, you need
		 * to invoke clone() method of friend.clone(). When you think about it,
		 * friends.clone() doesn't have a calling object, so it means that you are
		 * invoking it from itself (from an object that called the clone method in the
		 * first place to make a copy of itself), to help it understand, think of
		 * friends.clone() as this.friends.clone(), it suggests that you invoke clone of
		 * friends of this object. Then you need to downcast it, and save those details
		 * of the method caller, to the new variable copy. And it was for friends
		 * variable. If you have more variables which are not primitive types, you need
		 * to repeat this for each non primitive variable. And in the end, you need yo
		 * return that copy variable, which will be a deep copy.
		 * 
		 * If you look at documentantion of ArrayList<String> you will see that this
		 * class implements cloneable, so while invoking clone() here, you don'y have to
		 * worry about implementing it there. It is already implemented there following
		 * the cloneable interface semantincs.
		 */
	}

	public static void main(String[] args) {
		Sub1h object1 = new Sub1h();
		Sub1h object2 = (Sub1h) object1.clone();
		/*
		 * In here, it works exactly as in previous simple example. Only what happens
		 * behind the scenes is different.
		 * 
		 * Just to recap.
		 * 
		 * In simple case, you only return super.clone(). method. Clone method will
		 * invoke in super class, which will invoke in super class, which will invoke in
		 * super class, all the way leading to Object.clone() which will copy all
		 * primitive variables.
		 * 
		 * In harder case, you first need to create a new variable, and then invoke
		 * clone method. It looks like in simple case. You will create a copy variable
		 * that will hold a shallow copy. Then for each mutable object variable, you
		 * need to invoke clone() method for each of your variables, downcast, and put
		 * into that new copy variable variables. This way mutable object variables will
		 * invoke its own clone methods. In reality, you will invoke clone method in all
		 * mutable objects.
		 */
	}
}