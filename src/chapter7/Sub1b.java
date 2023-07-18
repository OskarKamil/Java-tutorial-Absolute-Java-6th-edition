package chapter7;

public class Sub1b extends Sub1 {	
	private final String continentOfOrigin;
	private final int yearOfArrival;
	
	/* This is a class of students from abroad of Europe. */
	
	public Sub1b() {
		super();
		continentOfOrigin = "[unknown]";
		yearOfArrival = 0;
	}
	
	public Sub1b(String name, int yob) {
		this(name, yob, "[unknown]", 0);
		/* Example of using [this] keyword. this() indicates usage of constructor in this class, super() indicates usage of constructor of parent class. */
	}
	
	public Sub1b(String name, int yob, String origin, int arrival) {
		super(name, yob);
		continentOfOrigin = origin;
		yearOfArrival = arrival;
	}
	
	public Sub1b(Sub1b original) {
		super(original);
		continentOfOrigin = original.continentOfOrigin;
		yearOfArrival = original.yearOfArrival;
	}
	
	public String showInfo() {
		return (super.showInfo() + "\nFrom: " + continentOfOrigin + "\nYear of arrival to country: " + yearOfArrival);
	}
	
}