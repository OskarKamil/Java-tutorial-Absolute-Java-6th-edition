package chapter8;

public class Sub1 {

	String name = "shape";

	int a;
	int b;
	int c;

	public Sub1() {
		a = 0;
		b = 0;
		c = 0;
	}

	public Sub1(Sub1 other) {
		this.a = other.a;
		this.b = other.b;
		this.c = other.c;
	}

	public Sub1 clone() {
		return new Sub1(this);
	}
	/*
	 * Each object inherits clone() method from Object class. However, when
	 * inherited, it doesn't work as intended, so it is important to override it. In
	 * here, this method returns Sub1 object type. Returns new Sub1(this). Where new
	 * Sub1 allocates space in memory and also runs through copy constructor to
	 * create a new object.
	 */

	public void info() {
		System.out.println("This is a " + name);
	}

	public void meth1() {
		meth2();
		meth2static();
	}

	public void meth2() {
		System.out.println("Parent meth");
	}
	/*
	 * You can always mark a methods to be final. It means that it cannot be
	 * overridden (same as class can be final too and may not have any derived
	 * classes - children), in this case, compiler will always use early binding,
	 * this is, each invocation of a method will always invoke this version of the
	 * method. As it cannot be derived, it cannot be overridden and no polymorphism
	 * will happen. It may also increase performance.
	 */

	public static void meth2static() {
		System.out.println("Parent meth static\n");
	}

	protected void showClassNames() {
		System.out.println(getClass());
	}
	/*
	 * Returns class name of the calling object. If object type is Sub1 it returns
	 * Sub1.
	 */

	static Sub1[] badCopy(Sub1[] a) {
		Sub1[] b = new Sub1[a.length];
		for (int i = 0; i < a.length; i++)
			b[i] = new Sub1(a[i]);

		return b;
	}
	/*
	 * Here we create a bad copy of an array using copy constructors. More explained
	 * in main() method.
	 */

	static Sub1[] goodCopy(Sub1[] a) {
		Sub1[] b = new Sub1[a.length];
		for (int i = 0; i < a.length; i++)
			b[i] = a[i].clone();

		return b;
	}
	/*
	 * And here we create a good copy an array using clone() method. More explained
	 * in main() method.
	 */

	public static void main(String[] args) {

		Sub1 obj1 = new Sub1();
		Sub1a obj2 = new Sub1a();
		Sub1b obj3 = new Sub1b();

		obj1.info(); // This is a shape
		obj2.info(); // This is a circle
		obj3.info(); // This is a shape
		/*
		 * We create 3 variables names of type Sub1, Sub1a, Sub1b and we create 3 object
		 * to their corresponding types. Sub1a and Sub1b are subclasses of Sub1. Let's
		 * analise line by line.
		 * 
		 * 1. obj1.info() returns shape, because it is a base class and it doesn't need
		 * to bind anything. obj1 is of type Sub1, so it uses all variables and method
		 * from Sub1
		 * 
		 * 2. obj2.info() returns circle. info() is an invocation of a nonstatic method
		 * so compiler uses late binding for that, so it looks for info() in the child
		 * class definition, info() is in derived class, so it uses derived class.
		 * (overridden)
		 * 
		 * 3. obj3.info() returns shape. It doesn't have overridden methods there. It
		 * only has a variable, but the method looks for variables where it is defined.
		 * It doesn't have overridden methods, so it runs method from base class, and
		 * from base class, it accesses variables where the method is defined (base
		 * class again).
		 * 
		 * This is called late binding. Java decides which invocation of info() to run.
		 * It is not overloading because their declaration is the same, this is
		 * overriding and choosing which one should be invoked based on the object
		 * type.
		 */

		Sub1 obj4 = new Sub1a();
		obj4.info(); // This is a circle
		/*
		 * Here we created Sub1 reference (variable type) and Sub1a object type.
		 * Reference is a variable name and object is an actual name that holds methods
		 * and values. Left side reference = right side object. It invokes nonstatic
		 * method, so compiler will try to find an overridden method in Sub1a class and
		 * run it.
		 */

		System.out.println("\n---------------------------------\n");

		System.out.println("obj");
		obj1.meth1(); // parent parent

		System.out.println("obj2");
		obj2.meth1(); // child parent

		System.out.println("obj3");
		obj3.meth1(); // parent parent

		System.out.println("obj4");
		obj4.meth1(); // child parent
		/*
		 * Examples of how static and nonstatic methods behave.
		 * 
		 * obj1: Base class: runs meth1(), then meth2(), then meth2static()
		 * 
		 * obj2: Object type Sub1a. Checks if meth1() is overridden in Sub1a, if it is,
		 * runs from Sub1a, if not (in this case, not) runs from Sub1. Runs meth1() from
		 * Sub1, then checks if meth2() is overridden in Sub1a. It is so runs meth2()
		 * from Sub1a. Then runs static method meth2static() from the class it has been
		 * invoked. The invocation of meth2static is in meth1() in Sub1 (because meth1()
		 * hasn't been overridden), then that's where it will run this method from.
		 * 
		 * obj3: Sub1b, doesn't override anything, everything is run from Sub1
		 * 
		 * obj4: Object type Sub1a, variable type Sub1. Same as obj2.
		 */

		meth2static(); // parent
		/*
		 * Howevewer obj4 is of Sub1a object type, obj4 is Sub1 reference type. And with
		 * static methods, they are run by reference, this is not late binding, this is
		 * static binding. With static methods it is run by early binding. So it means
		 * meth2static is run in Sub1 class definition because that's the variable type
		 * of obj4.
		 */

		Sub1c obj5 = new Sub1c();
		Sub1 obj6 = new Sub1c();
		obj5.info(); // triangle
		obj5.meth1(); // child child
		/*
		 * obj5: Object of type Sub1c and variable type Sub1c. Checks if meth1() is
		 * overridden in its class definition because it is nonstatic method it uses
		 * late binding which is invocation of a method in class type. Then meth2() it
		 * is nonstatic so once again, tries to find it in object type class definition
		 * and finds it. Then meth2static. It is not looking for any overrides because
		 * it is a static method. It simply runs the meth2static from where it was
		 * invoked, and it was invoked in Sub1c.meth1().
		 */
		Sub1c.meth2static(); // child meth static
		meth2static(); // parent meth static
		/*
		 * obj5 tries to invoke static method. Obj5 is type of Sub1c, but this is a
		 * static method so it is early binding so it invokes the method in the variable
		 * type definition. Variable type of obj5 is also Sub1c so obj5 invokes it's own
		 * defined static method.
		 * 
		 * obj6 tries to invoke static method too. Object type of obj6 is also Sub1c.
		 * However it invokes parent method. It is because as all static methods, they
		 * are invoked by type of the variable, not by the type of the object. Similar
		 * case in obj4.meth1(). Static method was run from Sub1 class body because
		 * that's when it was invoked, it didn't check for the variable type of obj4.
		 * Obj4 variable type is Sub1a however it run from Sub1 because that's where the
		 * method was invoked. Whem saying obj5.meth2static(), you give compiler exact
		 * location where that static method is.
		 */

		Sub1 obj7 = obj4.clone();
		/*
		 * Here is shown how to use clone method. On left side you create new name
		 * variable and on the right you invoke clone() method with the calling object
		 * you want to be cloned. You don't need to include "new" word here because
		 * return type is already new. In Java 5 and older, overridding this method was
		 * possible only with returning type Object. So sometimes you may find Sub1 obj7
		 * = (Sub1)obj4.clone(). This is casting from Object type to Sub1 type. You can
		 * also put it in here, it doesn't change anything. If return type is already
		 * Sub1, it will not cause an error.
		 */

		Sub1[] list = new Sub1[3];
		list[0] = new Sub1();
		list[1] = new Sub1e();
		list[2] = new Sub1();
		/*
		 * Creating a list of type Sub1 this means that this list indexed variables will
		 * be Sub1 and its derived classes. Index 1 is Sub1, index 2 is Sub1e and index
		 * 3 is Sub1. We create 3 variables and run with empty constructors.
		 */

		for (Sub1 a : list) {
			a.showClassNames();
		}
		/*
		 * This for each loop invokes showClassNames() method which displays type of the
		 * element. Used here is method getClass() that returns class name of an object.
		 */

		Sub1[] list2 = goodCopy(list);
		Sub1[] list3 = badCopy(list);
		/*
		 * Invoking 2 methods. Each method copies an array and return type is also an
		 * array. List2 used goodCopy method. It used clone() method because thanks to
		 * polymorphism, java knows which method to use, it is, from which class
		 * definition, given method clone is overridden in derived classes. clone()
		 * method is invoked for cloning Sub1 object and clone from Sub1e is invoked to
		 * copy Sub1e object.
		 * 
		 * badCopy() method uses copy constructor instead. Copy constructor doesn't use
		 * polymorphism. Why? Because the name is different. In the definition of the
		 * badCopy we used copy constructor to copy an element of an array. It simply
		 * says Sub1(a[i]) Which forces compiler into using Sub1 copy constructor, not
		 * taking into consideration that an element may be of type Sub1e. There is no
		 * way to check what type it is and run the correct constructor since your
		 * derived classes can be many and may have different name. That's why using
		 * clone() is best option to copying arrays. Array uses the right clone method
		 * to the right object type.
		 */

		System.out.println("Good copy");
		for (Sub1 a : list2) {
			a.showClassNames();
		}

		System.out.println("Bad copy");
		for (Sub1 a : list3) {
			a.showClassNames();
		}
	}
}

/*
 * Why we can simply put: System.out.println(objectname). Because System.out is
 * a calling object. println() is a method, and it is overloaded. It looks like
 * that:
 * 
 * public void println(Object theObject){
 * 
 * System.out.println(theObject.toString(); }
 * 
 * It simply takes theObject as argument and automatically uses toString()
 * method.
 */

/*
 * EASY WAY TO REMEMBER: - non-static methods (normal methods) are invoked by
 * type of the object (late binding) - static methods are invoked by the type of
 * the variable (early binding), it is equal with invoking them by name of the
 * class like Sub1c.meth2static instead obj5.meth2static. No need to use object
 * name, use class name. - if nonstatic method invokes static method, compiler
 * will invoke the definition of the method in the same file where it's
 * invocation took place. Example: method in Sub1 class invokes static method,
 * it will invoke it from Sub1, or closest ancestor, it will never look in
 * derived class. Example2: method in Sub1c invokes static method, it will
 * invoke it from Sub1c, or closest ancestor (if not available), in this case,
 * Sub1.
 */