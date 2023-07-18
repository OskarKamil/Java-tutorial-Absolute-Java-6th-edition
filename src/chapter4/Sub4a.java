package chapter4;

public class Sub4a {
	
	private final String name;
	private final int age;
	private final double weight;
	
	//private int age = 0;
	//private int double weight = 0;
	/* You can opt out of initializing values in a constructor but simply defining instance varables like this. */
	
	public Sub4a() {
		name = "no name";
		age = 0;
		weight = 0.0;
	}
	
	public Sub4a(String name) {
		this.name = name;
		age = 0;
		weight = 0;
	}
	/* Constructor. Basically those are kinda methods of the type of the class. When you create your own constructor, it is a good practise to create also one empty constructor to avoid errors in the future. Constructors should initialize all instance variables even if their value is no known yet. Constructors can have other instructions inside them as well. Methods, println and other things too. You can always just define no-argument constructor that does nothing. Sub4a()
	 * {/do nothing
	 * }
	 * */
	
}
