package chapter17;
//setActionCommand method

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sub4a extends JFrame implements ActionListener {

	public Sub4a() {
		super("button play");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setLayout(new GridLayout(0, 1));
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());

		panel1.add(new JLabel("Do you want to open a new window?"));
		JButton button1 = new JButton("Yes");
		button1.addActionListener(this);
		panel1.add(button1);

		panel2.add(new JLabel("Do you want to close this program?"));
		JButton button2 = new JButton("Yes");
		button2.addActionListener(this);
		panel2.add(button2);

		add(panel1);
		add(panel2);

		/*
		 * Everything we have done here so far is nothing new. You create 2 buttons and
		 * both of them say Yes. There is nothing wrong with having two buttons saying
		 * the same thing. But, if they have the same listener, the listener will not
		 * distinguish them. The listener will invoke e.getActionCommand() and both of
		 * them have the same ActionCommand() because action command is the same as the
		 * string used with constructor.
		 * 
		 * Text that button displays is sometimes out of context, sometimes it's just
		 * yes, no, next, prev, delete etc. We know the context of the commant from the
		 * label or from the frame. Action command should give us more context to what
		 * should happen when the button is pressed. Read below to understand.
		 */

		button1.setActionCommand("new window");
		button2.setActionCommand("close program");
		/*
		 * Both our buttons are affirmitive. They both do some action, but the text they
		 * display is "Yes", in that case, it will be impossible for a listener to
		 * distinguish them. Also note that a JMenuItem can also be used with listener.
		 * In fact we didn't show that, but since JMenuItem is derived class of
		 * AbstractButton, they both have setActionCommand method and both can have
		 * ActionListener and both are e.getActionCommand. In other words, for a
		 * listener to distinguish them, simply change the Action command. It should be
		 * distinguishable so a listener can compare them to a literal String and decide
		 * what action take.
		 * 
		 * This happens when both buttons have the same class as action listener. This
		 * is one possible way to define an action listener, all buttons created in a
		 * frame have only one action listener in one file. Another extreme is to create
		 * each separate class ActionListener for each button. But you would have loads
		 * of classes which would be very short and repetative, also it's time consuming
		 * and difficult to modify jumping from file to file. Another way to do that is
		 * using innder classes as ActionListeners. More explained in Sub4b.
		 */
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("new window")) {
			Sub4a nestedWindow = new Sub4a();
			nestedWindow.setVisible(true);
			nestedWindow.setLocation(this.getLocation().x + 10, this.getLocation().y + 10);
		} else if (e.getActionCommand().equals("close program")) {
			System.exit(0);
		}

	}

	public static void main(String[] args) {

		Sub4a window = new Sub4a();
		window.setVisible(true);
	}
}
