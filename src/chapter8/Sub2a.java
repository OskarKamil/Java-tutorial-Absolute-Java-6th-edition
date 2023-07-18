package chapter8;
// this is a class for UK born students

public class Sub2a extends Sub2 {

	private String placeOfBirth;
	
	protected int calculateResidency() {
		return age;
	}
	
	/* This is a concrete class. If super class declares an abstract method, a derived class of that class must define an abstract method. */
	
}
