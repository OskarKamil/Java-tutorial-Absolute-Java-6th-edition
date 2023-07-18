package chapter19;

public class Sub1c extends Thread {
	private Sub1d counter;

	public Sub1c(Sub1d ctr) {
		counter = ctr;
	}

	public static void main(String[] args) {
		int i;
		Sub1d masterCounter = new Sub1d();
		Sub1c[] threads = new Sub1c[100000];

		System.out.println("The bad counter is: " + masterCounter.getNumber());
		for (i = 0; i < threads.length; i++) {
			threads[i] = new Sub1c(masterCounter);
			threads[i].start();
		}

		for (i = 0; i < threads.length; i++) {
			try {
				threads[i].join();

			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("The bad counter is: " + masterCounter.getNumber());
		/*
		 * An example of what race condition is. By the way, this code is complicated
		 * and not too readable so do not worry if you have problems with understanding
		 * this code.
		 * 
		 * In this code first we created 100 000 objects using an array. And when an
		 * object is created, we invoked the method start() with that new object as a
		 * calling object. The method start is part of Thread class that this class
		 * extended. In other words. Each of this 100 000 objects is a Thread and is run
		 * just after it is being created. The method run() invoked a method
		 * increaseNumber(). And that method takes the value of the counter, creates
		 * local value, copies value of counter to local, increases local, gives back
		 * that value to the counter. That's where race condition occurs. Number of
		 * threads are trying to access the same value, and update it. If many threads
		 * do that at the same time, an update can be lost because the thread can access
		 * the counter value, the processor switches to another thread and gets value of
		 * counter, and then both of them increase local value and return that value to
		 * the counter, one of the updates is lost.
		 * 
		 * The method increaseNumber increases counter value by 1. So if 100 000 threads
		 * increase the value, the final value should be 100 000. But as you can see, it
		 * will not always be the case. Most likely the update will be lost in one or
		 * more cases. That's why it is important to use synchronisation explained in
		 * Sub1e.
		 * 
		 * New method here is join(). We used that method in threads[i].join(). This
		 * method waits till threads[i] is done with their work. This method is in a
		 * loop, so it means it checks for 100 000 threads if they are done, so they can
		 * join the main thread. This method is invoked in this thread, note that this
		 * main program has its own main thread. And if 100 000 threads are done and
		 * joined the main thread, then the code can continue.
		 */

	}

	@Override
	public void run() {
		counter.increaseNumber();

	}
}
