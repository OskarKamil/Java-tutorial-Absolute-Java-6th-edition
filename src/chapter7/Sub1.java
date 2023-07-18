package chapter7;

public class Sub1 {

	private String name;
	private final int yob;
	
	public Sub1() {
		name = "[unknown]";
		yob = 0;
	}
	
	public Sub1(String name, int yob) {
		this.name = name;
		this.yob = yob;
	}
	
	public Sub1(Sub1 original) {
		if(original == null)
			System.exit(0);
		
		name = original.name;
		yob = original.yob;
	}
	
	public String getName() {
		return name;
	}
	
	public String showInfo() {
		return ("Name: " + name + "\nYear of birth: " + yob);
	}
	
	public final void setName(String name) {
		this.name = name;
	}
}
	/* This is a final method. It means that it cannot be overridden in child class. In Sub1a you could not create another setName method with one String parameter.
	 * You can also add final to the class name, it will mean that the class cannot have any subclasses. 
	 * You can also create a subclass of one of predefined classes in java, for example:
	 *	import java.util.StringTokenizer;
		public class EnhancedStringTokenizer extends StringTokenizer
		
		This creates a subclass for StringTokenizer. You can for example add extra methods that will be saving the string into an array so you could process the String from an array instead invoking the method to read the file again. */
