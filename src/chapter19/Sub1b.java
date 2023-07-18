package chapter19;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Sub1b extends JFrame implements ActionListener, Runnable {
	/*
	 * Instead of creating an inside private class that extends Thread, you can
	 * implement an interface Runnable which works in the the same way as Threat.
	 * This interface has only one method heading - run(). Inside run() method you
	 * specify what happens when the Thread starts.
	 */

	static final int OVAL_SIZE = 10;
	JPanel drawingPanel = new JPanel();

	public Sub1b() {
		super("Responsive GUI with Runnable");
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
		Sub1b window = new Sub1b();
		window.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Thread theThread = new Thread(this);
		theThread.start();
	}
	/*
	 * Every time a button is pressed, a new thread is created, and a method start()
	 * does some things behind the scenes and eventually invokes method run(). It is
	 * important that you never invoke method run() yourself, if you do that, the
	 * action will be happening in the current thread. You always need to invoke the
	 * start() method if you want run() to happen.
	 * 
	 * This way is different from the previous example in a way that you add "this"
	 * as an argument to the Thread constructor.
	 */

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
