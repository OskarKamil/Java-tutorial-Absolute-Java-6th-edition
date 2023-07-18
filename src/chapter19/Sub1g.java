package chapter19;

public class Sub1g extends Thread {
	@Override
	public void run() {
		System.out.println("The run method has been started");
		System.out.println(this.getName());
		/*
		 * Since this class extends class Thread class. We do not have to use
		 * Thread.getCurrent().getName() because we can use this. This is an object of
		 * this class, and this class extends Thread so it means that this object is
		 * already a thread, and getCurrent() is equal to this.
		 */
		for (int i = 0; i <= 10; i++) {
			try {
				System.out.print("#");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Finito");
	}

}
