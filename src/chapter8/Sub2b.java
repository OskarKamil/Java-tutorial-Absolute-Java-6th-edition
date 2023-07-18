package chapter8;
// this is a general abstract class for EU students

public abstract class Sub2b extends Sub2 {

	private String countryCode;
}

/* This is an abstract class because it doesn't define any abstract methods from its super class. If this class defined abstract class from its super class this could be a non-abstract class - concrete class. However, this class still can be abstract class if needed, and it also may declare more abstract methods that will need to be defined in its derived classes. */