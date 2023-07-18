package chapter7;

public class Sub2{
	
	public int age;
	private int weight;
	protected int height;
	int length;
	
	/* public - can be accessed by name anywhere
	 * private - can be accessed by name only in this class
	 * protected - can be accessed by name in this class, child classes, same package classes
	 * default access (package access) - can be accessed by name only in this package
	 */
}

/*

package chapter7
Sub2
can access by name all those variables

package chapter7
Sub2a
can access by name public, protected, default

package chapter7
Sub2b extends Sub2
can access by name public, protected, default

package chapter10
import chapter7.Sub2;
Sub1
can access by name public

package chapter10
import chapter7.Sub2;
Sub1a extends Sub2
can access by name public, protected

*/