package chapter19;

public class Sub1d { // counter
	private int number;

	public Sub1d() {
		number = 0;

	}

	public int getNumber() {
		return number;

	}

	public void increaseNumber() {
		int local;
		local = number;
		local++;
		number = local;
	}
}
