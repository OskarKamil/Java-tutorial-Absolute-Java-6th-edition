package chapter17;
// COLOR and JLabel

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Sub2d extends JFrame {

	// width and height

	public Sub2d(Color theColor) {
		super("Nice coloured window");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(theColor);

		// JLabel aLabel = new JLabel("And this is a label");
		// add(aLabel);
		add(new JLabel("A label")); // a label as anonymous object
		setLocationRelativeTo(null);

	}

	public Sub2d() {
		this(Color.white);
	}

	/*
	 * Another example of an extended JFrame class. First we created a constructor
	 * that takes an argument of type Color. The color is simply a name of a color.
	 * There are few ready to use colors.
	 * 
	 * What is new here is getContentPane().setBackground(Color aColor); A method
	 * getContentPane() simply returns a background as an object, and throught that
	 * object we use another method setBackground(Color aColor) that will change the
	 * background colour of our frame.
	 * 
	 * Then we created a JLabel. Similar like button, String constructor is a text
	 * displayed. Or you could use an anonymous object of JLabel.
	 * 
	 * Note that we created default constructor. This is in case we wanted to create
	 * a windows without a custom colour background, just plain white. We had to
	 * create defualt empty constructor because by defining our previous construtor,
	 * we removed automatic default constructor.
	 */

	public static void main(String[] args) {
		Sub2d window1 = new Sub2d(Color.orange);
		window1.setVisible(true);

		Sub2d window2 = new Sub2d();
		window2.setVisible(true);
		window2.setSize(250, 250);
		window2.setLocationRelativeTo(null);
	}

}
