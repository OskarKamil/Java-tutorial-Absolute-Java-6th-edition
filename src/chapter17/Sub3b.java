package chapter17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Sub3b extends JFrame implements ActionListener {
	/*
	 * In some of the previous examples we used separate class EndListener that
	 * implemented ActionListener class. In this example our class not only extends
	 * JFrame (is a window), but also a listener itself. This is an alternative way
	 * to implement this interface. This way we have only one file which is JFrame
	 * itself, listener, and a main() method.
	 */

	JPanel stripe1 = new JPanel();
	JPanel stripe2 = new JPanel();
	JPanel stripe3 = new JPanel();
	/*
	 * Created here so they are visible in the method.
	 */

	public Sub3b() {
		super("Action listeners and more panels");
		setSize(600, 425);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JButton button1 = new JButton("Green");
		JButton button2 = new JButton("White");
		JButton button3 = new JButton("Red");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		/*
		 * If you remember in previous examples. Argument to this method specifies which
		 * class is the listener. As we mentioned a while ago, this class also
		 * implements ActionListener, so, THIS class is its own listener. That's why we
		 * used the keyword this to specify which class the listener is.
		 */

		button1.setBackground(new Color(80, 255, 80));
		button2.setBackground(Color.WHITE);
		button3.setBackground(new Color(255, 80, 80));
		/*
		 * Alternative to set a colour. Note that if you want to set a colour for the
		 * whole frame, you need to getContentPane(), but for any other component, you
		 * simply use setBackground(). You can set a colour of few ready to use colour
		 * variable names, or use RGB scale with new Color(int R, int G, int B)
		 * constructor.
		 */

		setLayout(new BorderLayout());
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
		buttonsPanel.add(button1);
		buttonsPanel.add(button2);
		buttonsPanel.add(button3);
		add(buttonsPanel, BorderLayout.SOUTH);
		buttonsPanel.setBackground(Color.black);

		JPanel stripesPanel = new JPanel();
		stripesPanel.setLayout(new GridLayout(0, 3));

		stripe1.setBackground(Color.LIGHT_GRAY);
		stripe2.setBackground(Color.LIGHT_GRAY);
		stripe3.setBackground(Color.LIGHT_GRAY);

		stripesPanel.add(stripe1);
		stripesPanel.add(stripe2);
		stripesPanel.add(stripe3);

		add(stripesPanel, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		String colourString = e.getActionCommand();
		if (colourString.equals("Green"))
			stripe1.setBackground(Color.green);
		else if (colourString.equals("White"))
			stripe2.setBackground(Color.white);
		else if (colourString.equals("Red"))
			stripe3.setBackground(Color.red);
		/*
		 * This whole class doesn't bring too much new information. Basically this part
		 * of listeners is a bit modifioed and a bit new. Here we have a method
		 * e.getActionCommand() which takes a String that was used in the constructor
		 * while creating the object of the calling object. button1 is the calling
		 * object of the firing event.
		 */
	}

	public static void main(String[] args) {
		Sub3b window1 = new Sub3b();
		window1.setVisible(true);
	}
}
