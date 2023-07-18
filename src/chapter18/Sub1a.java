package chapter18;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Sub1a extends JFrame {
	/*
	 * This program works exactly the same as previous one. This one is just written
	 * a bit different way using different method.
	 */

	public Sub1a() {
		super();
		setSize(300, 125);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		add(new JButton("nothing"));
		add(new JLabel("Hello. This is main JFrame. Try to close the window."));
		add(new JButton("nothing"));
		addWindowListener(new exitConfirmListener());
		/*
		 * Have a look at this class exitConfirmListener.
		 */
		pack();

	}

	private class exitConfirmListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			ConfirmWindow confWindow = new ConfirmWindow();
			confWindow.setVisible(true);
		}
	}
	/*
	 * This class is different from previous example this way that this one extends
	 * an abstract class, but the previous example implements an interface.
	 * Extending this class here we need to override only one method, namely
	 * windowClosing(). When implementing an interface we had to define 7 methods.
	 * Up to you which way you want to do. Note that this is extending and you can
	 * extends only one class at a time.
	 */

	private class ConfirmWindow extends JFrame implements ActionListener {
		public ConfirmWindow() {
			super("Save");
			setSize(250, 125);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLayout(new GridLayout(0, 1));
			JPanel panel1 = new JPanel();
			panel1.setLayout(new FlowLayout());
			panel1.add(new JLabel("Are you sure you want to exit?"));
			add(panel1);
			JButton closeProgram = new JButton("Yes");
			JButton closeWindow = new JButton("No");
			closeProgram.addActionListener(this);
			closeWindow.addActionListener(this);
			JPanel panel2 = new JPanel();
			panel2.setLayout(new FlowLayout());
			panel2.add(closeProgram);
			panel2.add(closeWindow);
			add(panel2);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String word = e.getActionCommand();
			if (word.equals("Yes"))
				System.exit(0);
			else if (word.equals("No"))
				dispose();
			else {
				System.out.println("Error. No such button.");
			}

		}
	}

	public static void main(String[] args) {
		Sub1a window = new Sub1a();
		window.setVisible(true);
	}
}
