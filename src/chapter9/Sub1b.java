package chapter9;

public class Sub1b extends Exception {

	int number;
	
	public Sub1b() {
		super("wrong number");
		number = -1;
	}
	
	public Sub1b(String msg) {
		super(msg);
		number = -1;
	}
	
	public Sub1b(int number) {
		super("wrong number: " + number);
		this.number = number;
	}
	
	protected int getNumber() {
		return number;
	}
	
	/* An example of exception method having more than just 2 constructors. */
}
