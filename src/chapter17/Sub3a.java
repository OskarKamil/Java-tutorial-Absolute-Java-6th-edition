package chapter17;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sub3a extends JFrame {

	public Sub3a() {
		super("Playing with panels");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 300);
		setResizable(false);
		/*
		 * New method we haven't used before. Simply states the frame cannot be resized.
		 */
		setLocationRelativeTo(null);

		setLayout(new GridLayout(0, 1));

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(new JLabel("Do you enjoy this program?"));
		/*
		 * New class, JPanel. JPanel is like a frame. It can have buttons and other
		 * components, or, other panels. In effect, you can put a panel in a panel, in a
		 * panel. This gives you the option to do almost anything. Each panel can have
		 * its own LayoutManager.
		 */

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(new JButton("Yes"));
		panel2.add(new JButton("No"));

		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.add(new JLabel("Would you like to leave a review?"));

		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		panel4.add(new JButton("Review"));
		panel4.add(new JButton("No, thanks"));

		add(new JPanel());
		add(panel1);
		add(panel2);
		add(new JPanel());
		add(panel3);
		add(panel4);
		add(new JPanel());
		/*
		 * Adding panels to the frame. The frame in general is in grid layout, so adding
		 * new components (including panels) will put new ones under old ones. But first
		 * cell in the grid is a panel, but this panel's layout is FlowLayout, so
		 * components inside this cell follow FlowLayout.
		 */

	}

	public static void main(String[] args) {
		Sub3a window1 = new Sub3a();
		window1.setVisible(true);

	}

}
