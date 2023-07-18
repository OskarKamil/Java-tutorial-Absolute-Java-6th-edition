package chapter19;

public class Sub1e { // good counter
	private int number;

	public Sub1e() {
		number = 0;

	}

	public int getNumber() {
		return number;

	}

	public synchronized void increaseNumber() {
		int local;
		local = number;
		local++;
		number = local;
	}
	/*
	 * New keyword here "synchronised". It means that only one thread can run this
	 * method at a time. This way no other thread will try to change value of number
	 * while other thread is reading it. Also, no update will be lost because only
	 * one thread at a time can invoke this method.
	 */

	public void increaseNumber2() {
		int local;
		synchronized (this) {
			local = number;
			local++;
			number = local;
		}
		/*
		 * Another way of achieving the same result is wrapping lines that can be
		 * executed by one thread only at a time. This means that no other thread can
		 * copy value of number and paste it into local.
		 * 
		 * So there are 2 ways of doing it. You can use keyword synchronised before
		 * return type of method, or wrap lines of code which follow synchronised
		 * (this).
		 */

	}
}
