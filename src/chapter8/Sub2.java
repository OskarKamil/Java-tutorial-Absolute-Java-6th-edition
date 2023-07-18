package chapter8;
// this is a general abstract class for any student

public abstract class Sub2 {
/* Abstract class needs an abstract keyword before class name. */
	
	protected int age;
	private String name;
	private int startDate;
	private int endDate;
	protected int yearsResidency;
	
	protected abstract int calculateResidency();
	/* Abstract method needs abstract keyword. Abstract methods are usually public, but they can be protected and default. They however cannot be private. If you declare an abstract method, you must define that method in all your concrete derived classes. If those classes have other derived classes, they can simply be inherited. */
	
	protected void setInfo() {
		//setAge();
		//setName();
		//setStartDate();
		//setEndDate();
		calculateResidency();
		// if statement if requirements are met
	}
	/* If any of your non-abstract methods (this is, concrete methods) invokes an abstract method, you need to declare in first to let compiler know that this method exists somewhere in the derived classes. */
	
	public static void main(String[] args) {
	
		//Sub2 obj1 = new Sub2(); // ERROR
		/* An abstract class cannot be instantiated. This means that Sub2 obj1 = new Sub2(); will produce an error. Abstract classes force us to use child classes while creating an object. */
		
		Sub2 obj1 = new Sub2a();
		/* You can however create an object of the derived class type and use variable name of an abstract class. It is called upcasting. */
	}
}


/* An abstract class doesn't need to have abstract methods. It can be abstract by itself, but it will still mean that no object type of abstract class can be created. */