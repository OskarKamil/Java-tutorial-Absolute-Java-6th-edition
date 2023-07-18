package chapter17;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Sub2b extends JFrame {
	/*
	 * This is a proper way to define a JFrame class, what we mean by that is that
	 * the class is descendant of JFrame class. Previous example was only to show
	 * methods and simple idea how the code works and the explanation. An actual way
	 * that you have to using JFrame is to extend it.
	 */

	public static final int WIDTH = 600;
	public static final int HEIGHT = 300;

	public Sub2b() {
		super();
		setSize(WIDTH, HEIGHT);
		setTitle("Same window, simpler code");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton endButton = new JButton("Exit");
		endButton.addActionListener(new Sub2a());
		add(endButton);
		setLocationRelativeTo(null);
		/*
		 * This is the proper way to define a JFrame class. As with all derived classes,
		 * we need to call a super constructor of its immediate ancestor, in this case
		 * JFrame. JFrame as we learned has 2 constructors, one default and one with one
		 * String argument. We could have skipped this line because if default
		 * constructor is present in the immediate parent, we needn't to invoke it in
		 * the derived class. But here we did for the clarity. Then we set size, default
		 * close operation, create JButton. And in here we did something new. We created
		 * a listener, but this is a anonymous object. REMINDER: an anonymous object is
		 * an object without a name, only with class type. Here it's pointless to create
		 * a variable name for this object because it will only be used once and never
		 * referenced again, it is used solely to create a bound between a button and an
		 * event. A benefit of doing that is simpler code, and using JFrame class as a
		 * extended class, is easier to write and more versatile code. This one class is
		 * only for creating this one window. Have a look at Sub2c.
		 */
	}

}
