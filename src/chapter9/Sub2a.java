package chapter9;

public class Sub2a extends Sub2{

	static double fiveBy(double number) {
		return 0;
	}
	/* Let assume this method is not static, same as its parent, this method is not static. In derived classes, when you override a method that throws an exception. You cannot add more Exceptions to that overridden method, but, you can remove and change any of the Exception types into any of the derived exceptions to that exception. If you think about it, it makes sense because in a place of Sub2 object, any child of Sub2 can be snipped, for example Sub2a, giving extra limitations - this is, exceptions, will only limit the child, and child classes extend the parent with extra methods and variables. */
}
