package chapter8;

public class Sub1e extends Sub1 {

	int d;
	int e;

	Sub1e() {
		super();
		d = 1;
		e = 1;
	}
	/* Using empty constructors. */

	Sub1e(Sub1e other) {
		super(other);
		this.d = other.d;
		this.e = other.e;
	}

	public Sub1e clone() {
		return new Sub1e(this);
	}
	/*
	 * Example of a clone method combined with copy construtor and usage of
	 * super(other) and (this).
	 */

}
