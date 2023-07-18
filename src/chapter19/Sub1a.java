package chapter19;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Sub1a extends JFrame implements ActionListener {
	JPanel drawingPanel = new JPanel();
	static final int OVAL_SIZE = 10;

	public Sub1a() {
		super("Responsive GUI");
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

	public void actionPerformed(ActionEvent e) {
		SecondThread threadDrawing = new SecondThread();
		threadDrawing.start();
	}
	/*
	 * We created new object of type SecondThread which extends Thread class. And
	 * then invoked method start() with that new thread. Each time you want to start
	 * a thread, use method start(), never run(). Read more for SecondThread
	 * definition.
	 */

	private class SecondThread extends Thread {

		public void run() {
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
				}
			}
		}
	}
	/*
	 * We created an inner class SecondThread that extends Thread class. This way
	 * you can see that the second thread is running and drawing circles, and you
	 * can resize the window, maximise, or just close it pressing X or press to draw
	 * circles again. That is because before nothing could happen because only one
	 * method could be running at a time of GUI, and it was action listener method.
	 * And it was running and running and no one method can be run, like closing
	 * window. Here we run an ActionListener method, and it created new Thread and
	 * the new Thread was responsible for drawing. We could do all the rest that we
	 * wanted meantime because our main primary thread was free and was not doing
	 * anything.
	 */

	public static void main(String[] args) {
		Sub1b window = new Sub1b();
		window.setVisible(true);
	}

}
