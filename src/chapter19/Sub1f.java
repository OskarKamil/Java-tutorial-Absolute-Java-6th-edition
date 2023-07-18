package chapter19;

public class Sub1f {
	public static void main(String[] args) {
		System.out.println(Thread.activeCount()); // 1
		/*
		 * Displays number of active threads. Even thought we didn't create any new
		 * threads, all programs run on a main Thread.
		 */

		System.out.println(Thread.currentThread().getName()); // main
		/*
		 * First we use Thread class, then method currentThread(), it returns a Thread
		 * object, and then we use method getName(). In other words, we getName of our
		 * currentThread. The name is main.
		 */

		Thread.currentThread().setName("The Thread");
		System.out.println(Thread.currentThread().getName());
		/*
		 * Method setName(String) changes name of the thread, in this case, a current
		 * thread.
		 */

		System.out.println(Thread.currentThread().getPriority()); // 5
		Thread.currentThread().setPriority(10);
		/*
		 * By default, a created thread has priority level of 5. The scale is from 1 to
		 * 10. The threads with higher priority will be executed before those of lower
		 * priority.
		 */
		System.out.println(Thread.currentThread().getPriority()); // 10

		System.out.println(Thread.currentThread().isAlive()); // true
		/*
		 * Returns whether the thread is alive/running. You can create a thread, but not
		 * necessarily start it, if the thread is created but not doing anything, it is
		 * not alive.
		 */

		for (int i = 0; i <= 10; i++) {
			System.out.println((10 - i) + " seconds");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("The nuclear bomb has been launched from Russia to USA.\n");
		/*
		 * Example of Thread.sleep(long) method. It throws an exception so you can
		 * either try to catch it or add class throws to the main method.
		 */

		Sub1g thread2 = new Sub1g();

		System.out.println("Starting thread with run(). Waiting for the run() method to finish.");
		thread2.run();
		System.out.println("Is " + thread2.getName() + " alive?: " + thread2.isAlive());
		/*
		 * When you create a thread object and invoke method run() with that thread as
		 * calling object, you simply are running the method as any other method. This
		 * main method is waiting for the run() method to finish, it cannot execute
		 * lines here below because run() method is currently running and it has
		 * sleep(long) method in it so we have to wait. The method isAlive() returns
		 * false because this method is invoked after the run() method has ended, not
		 * only that, but thread2 was never active. This method main() was busy
		 * executing run() method.
		 */

		System.out.println();

		System.out.println("Starting thread with start().");
		thread2.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Is " + thread2.getName() + " alive?: " + thread2.isAlive());
		/*
		 * Here we invoked method start(). This starts thread2 and runs method run() in
		 * that new thread. Now our code is being invoked from this main() method and
		 * method run() simultaneously. And our method isAlive() returns true, because
		 * in fact thread2 is alive because it is executing code, and we can actually
		 * run this method while the code is executed.
		 */

		System.out.println(thread2.getPriority());
		/*
		 * We said that default priority value for a new created thread is 5, but that
		 * is because class Thread has default value of 5. thread2 was creating from
		 * this Main thread (The Thread), and it actually inherits the priority from the
		 * thread it was created from. So we manually set priority for The Thread to 10,
		 * and our thread2 inherited that and also has priority 10.
		 */

		try {
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("WHAT1");
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("The thread2 finished and joined our main thread.");
		/*
		 * Method join() with a Thread object as a calling object, forces the thread
		 * when the method was invoked, this method is invoked here in The Thread, so
		 * The Thread has to wait for the thread2 to finish and join The Thread. That's
		 * why the next println(String) is not executed until thread2 has finished.
		 * 
		 * If thread.join() is executed after the thread2 is done, it simply doesn't
		 * wait for thread2 to join, thread2 isAlive() returns false, so it means it is
		 * ready to join.
		 */

		thread2 = new Sub1g();
		/*
		 * You cannot start a thread again. If you start a thread again, it will throw
		 * an exception, there are ways to do that, one way is to create instance again
		 * with constructor.
		 */

		System.out.println("Now let's see what daemons are.");
		thread2.setDaemon(true);
		thread2.start();
		System.out.println("Daemon started.");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("WHAT2");
			e.printStackTrace();
		}
		System.out.println("Is daemon running?: " + thread2.isAlive());
		System.out.println("Daemon running but will the program end?");
		/*
		 * The daemon started running and was printing #s in the console, but our main
		 * method had ended, and with that, our main thread, which was The Thread. That
		 * thread was a user thread, before we used another user thread. But right now
		 * we set thread2 to daemon with method setDaemon(boolean) and that thread
		 * become a daemon. There are 2 types of threads, user threads and daemon
		 * threads. The program will not end if user thread is running, for example the
		 * main method may finish, but thread2 is still running and printing #s, but if
		 * the thread2 which is a daemon is still running and printing #s, the program
		 * will end because daemons are low priority threads and they are used as a
		 * helper for user threads. If no user threads are alive, this means that daemon
		 * threads are not used anymore because they do not help any user threads so
		 * they are not important so the program closes.
		 */

	}
	/*
	 * Another way that threads are useful is an example of one thread throwing an
	 * exception, and the main thread is still running. The thread that threw an
	 * exception may end because of that, but the main thread is still running and
	 * is not affected by the exception in the other thread. Let's assume that main
	 * thread created thread2 which divides by 0. The thread2 will throw an
	 * exception and close, but main thread will be continuing and doing its own
	 * work not minding that the exception has been thrown.
	 */

}
