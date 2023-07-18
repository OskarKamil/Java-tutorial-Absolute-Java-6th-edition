package chapter17;
//listeners as Inner Classes

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Sub4b extends JFrame {
	private class newWindowListener implements ActionListener {
		JFrame originalFrame = null;

		public newWindowListener(Sub4b sub4b) {
			originalFrame = sub4b;
		}

		public void actionPerformed(ActionEvent e) {
			Sub4b nestedWindow = new Sub4b();
			nestedWindow.setVisible(true);
			JButton sourceButton = (JButton) (e.getSource());
			JFrame sourceFrame = (Sub4b) SwingUtilities.windowForComponent(sourceButton);

			nestedWindow.setLocation(originalFrame.getLocation().x + 10, originalFrame.getLocation().y + 10);
			/*
			 * nestedWindow.setLocation(sourceFrame.getLocation().x + 10,
			 * sourceFrame.getLocation().y + 10);
			 */
		}
	}
	/*
	 * As in previous lesson we learned there are few ways to implement
	 * ActionListener. One way is that one class has one actionPerformed method and
	 * it has if else statements checking which button was pressed. Another way is
	 * that each button has ist own listener separate class. And here is another
	 * way. Each button can have its own listener, but instead having each different
	 * class file, we could use inner classes for that. In this case we have created
	 * 2 inner classes and both those classes must implement ActionListener
	 * interface.
	 * 
	 * There is not much new than we did before. In previous class we created new
	 * JFrame which was 10px right and down from the window it was created from,
	 * meaning, the new JFrame was created next to the old JFrame. We set location
	 * of that new window using this keyword. Since "this" refer to the object that
	 * is created with, "this" refered to an object window of type Sub4a (which
	 * extended JFrame). And this object had getLocation.x and y method and
	 * variables so it all was possible. But with inner classes it was not possible
	 * so easily. If you simply copied the code, you would receive an error saying
	 * that inner class doesn't have getLocation() method. This is because inner
	 * class doesn't have that method because that inner class is just a random
	 * class and its immediate parent is Object so it doesn't inherited any methods.
	 * You could try to extend that inner classes from JFrame, you would have that
	 * method then, but, you would not be able to get location of "this" because
	 * this refers to an object of inner class which you are setting now. In effect,
	 * you are getting location of an object that you are creating right now,
	 * instead what you want to do is to get location of an object of that outer
	 * class. There are 2 ways to do that.
	 * 
	 * 1. You can create a constructor with Sub4b argument that will take (this)
	 * argument. This way you can use all methods that "this" (object of Sub4b) has
	 * to offer, namely getLocation.y and x. If you look belowe when adding a
	 * listener to button1, in the anonymous object in the constructor that is
	 * exactly what we have done. This constructor has (this) argument in it. So the
	 * inner class can reference that outer frame and get its location needed to set
	 * a new location of the new frame.
	 * 
	 * 2. You can use methods available to you. e is a variable event. You can use
	 * method e.getSource() that will return a component that fired that event. In
	 * this case, a button1 fired that event. Do not forget to cast it to JButton.
	 * You need to get a location of the frame, but you do not have the frame yet.
	 * You can use method SwingUtilities.windowForComponent(sourceButton) that will
	 * return a window/JFrame where the button is location. Do not forget to cast it
	 * to JFrame. Then you can save that JFrame into a new variable name, and then
	 * using that variable name, access its location y and z and then use that to
	 * set a location for that new window.
	 * 
	 * You already know SwingUtilities class, you used one method before:
	 * SwingUtilities.updateComponentTreeUI(window3); This method updates the frame
	 * without focusing it. And windowForComponent is another method that returns a
	 * window where the component is located it.
	 */

	private class closeProgramListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	/*
	 * Another inner class that implements ActionListener. This inner class doesn't
	 * need to access the mother window so it has a normal constructor. This action
	 * is simply closing the program.
	 */

	public Sub4b() {
		super("Inner classes as Action Listener");
		setSize(450, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setLayout(new GridLayout(0, 1));
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());

		panel1.add(new JLabel("Do you want to open a new window?"));
		JButton button1 = new JButton("Yes");
		button1.addActionListener(new newWindowListener(this));
		panel1.add(button1);
		/*
		 * In here the argument is "this". So THIS JFrame object is passed to the inner
		 * class object. This way the inner class can access the out class object.
		 */

		panel2.add(new JLabel("Do you want to close this program?"));
		JButton button2 = new JButton("Yes");
		button2.addActionListener(new closeProgramListener());
		panel2.add(button2);

		add(panel1);
		add(panel2);
	}

	public static void main(String[] args) {
		Sub4b window = new Sub4b();
		window.setVisible(true);

	}
}
