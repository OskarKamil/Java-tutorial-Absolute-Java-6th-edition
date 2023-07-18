package chapter19;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Sub1 extends JFrame implements ActionListener {
	static final int OVAL_SIZE = 10;
	JPanel drawingPanel = new JPanel();

	public Sub1() {
		super("Unresponsive GUI");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setLayout(new BorderLayout());
		JButton startDrawing = new JButton("Start");
		startDrawing.addActionListener(this);

		add(startDrawing, BorderLayout.SOUTH);

		// JPanel drawingPanel = new JPanel();
		add(drawingPanel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		Sub1 window = new Sub1();
		window.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Graphics g = drawingPanel.getGraphics();
		System.out.println(drawingPanel.getSize().height);
		System.out.println(drawingPanel.getSize().width);
		for (int i = 0; i < drawingPanel.getSize().height; i = i + OVAL_SIZE) {
			System.out.println("First loop started");
			for (int j = 0; j < drawingPanel.getSize().width; j = j + OVAL_SIZE) {
				System.out.println("Second loop started");
				g.fillOval(j, i, OVAL_SIZE, OVAL_SIZE);

				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
					System.exit(1);
				}
				/*
				 * When you run this program and press the "Start" button, a small black circles
				 * will start appearing on the window. You will see that you cannot do anything
				 * with your window. You cannot close it, you cannot press the button again, and
				 * resizing the window also glitches the program. That's why in our program we
				 * have only one thread. In all our previous programs that we ever wrote we had
				 * only one thread, even if we didn't create it explicitly. All programs are
				 * running on a thread even if we do not write that. And if we want we can add
				 * more threads. Let's analyse the code.
				 *
				 * First we used method getGraphics(). All components have this method and an
				 * object of type Graphics is inherited. We could have simply run
				 * this.getGraphics() but running ovals would start from the left of the window,
				 * which also accounts for the resize borders, in effect, it would seem like our
				 * circles are out of bounds, that's why we draw them from the JPanel and not
				 * from the JFrame. When you want to draw something, you do not need a paint()
				 * method. You can use getGraphics() method and draw from whichever component
				 * you like.
				 *
				 * New thing here is also keyword Thread and method sleep(int milliseconds). The
				 * class Thread is responsible for multithreading which will be briefly shown in
				 * next file. All the subjects mentioned in this chapter are only big
				 * generalisation because each of its topics deserve a book of its own. So
				 * whichever subject you want to read more on, you need to find more resources
				 * (books, tutorials etc.).
				 *
				 * A method sleep(int millisecond) simply freezes the program for given number
				 * of milliseconds. In other words 1000 is equal to 1 second. Note that the
				 * program is unresponsive when the circles are being drawn and when the sleep
				 * method is invoked. Even when you remove the sleep method, select circle size
				 * to 1, the program still is unresponsive. That is because only one action can
				 * be taken at a time. In this case, ActionEvent is taking place. Pressing the X
				 * button will trigger WindowEvent, and it cannot start happening until other
				 * event is finished first. This method sleep() can throw checked exception, so
				 * it must be caught. The exception is InterruptedException which means that the
				 * Thread can be interrupted, usually, by another thread. You will see more in
				 * next file.
				 */
			}
		}

	}

}
