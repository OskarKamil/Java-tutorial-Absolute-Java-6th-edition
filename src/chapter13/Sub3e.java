package chapter13;
//anonymous classes

public class Sub3e {
	public static void main(String[] args) {

		Sub3f number1 = new Sub3f() {
			private int num;

			public void setNumber(int value) {
				num = value;
			}

			public int getNumber() {
				return num;
			}
		};
		/*
		 * This may look a bit messy, but let's analyze it.
		 * 
		 * First line. You create an object of type Sub3f. What is Sub3f? It is actually
		 * an interface. Interface has only method headings. Here you need to define
		 * your one time class only.
		 * 
		 * Rest of the lines. You declare an instance variable, and define 2 methods
		 * which are declared in an interface.
		 */

		Sub3f number2 = new Sub3f() {
			private int num;

			public void setNumber(int value) {
				num = value * 2;
			}

			public int getNumber() {
				return num;
			}
		};
		/*
		 * Here doing exactly the same with one difference, setNumber() method is
		 * different. It os only to show something later.
		 */

		number1.setNumber(4);
		number2.setNumber(24);
		showNumber(number1);
		showNumber(number2);
		/*
		 * In this file we created 2 variables of no type. Those variables implement an
		 * interface, but their class is anonymous. This way is usually used when you
		 * need only one object of certain class, and the class definition is short, so
		 * instead of creating new file with all constructors etc, you simply create
		 * only one object of one class, and that class is anonymous, since it is used
		 * only once, no need to use or know their name. Anonymous classes are mostly
		 * used in linked lists and graphical user interfaces (GUIs), so those examples
		 * of inner classes in this chapter are a bit unhelpful.
		 */

	}

	public static void showNumber(Sub3f o) {
		System.out.println(o.getNumber());
	}
	/*
	 * Just to recap. Standard static void method that is not connected to object,
	 * so it can be invoked by itself.
	 */
}
