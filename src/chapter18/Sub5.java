package chapter18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Sub5 extends JFrame implements ActionListener {

	String toDisplay = "Hello user";
	Font defaultFont = null;
	Color fontColor = Color.black;
	/*
	 * We need to declare them here because we will refer them in two methods and if
	 * we create them inside the constructor, the other methods will not see them.
	 */

	public Sub5() {
		super("drawString method");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JButton helloButton = new JButton("Hello");
		helloButton.addActionListener(this);
		add(helloButton, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Hello")) {
			toDisplay = "I can change";
			defaultFont = new Font("Arial_Black", Font.ITALIC | Font.BOLD, 33);
			fontColor = Color.GREEN;
			repaint();
		}
		/*
		 * toDisplay is a string.
		 * 
		 * defaultFont is changed with a constructor. A constructor for Font takes 3
		 * arguments. First is fontName like Arial or Times New Roman. Second argument
		 * is modification, like bold, italic or plain. And third argument is size of
		 * the font. Every time you wish to modify something that will be run inside
		 * paint() method, you need to invoke method repaint(). This way, the method
		 * paint() is invoked with new information like new font and new color.
		 * 
		 * There is no easy way to change font style or size or modifiers of a font
		 * object. To do add, you usually have to create new font object with new
		 * settings and then use method setFont.
		 */

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(defaultFont);
		g.setColor(fontColor);
		g.drawString(toDisplay, 25, 70);
		/*
		 * In paint method using g. you can draw oval, rectangle or drawString. Each
		 * time you should set g to preferred font style, font color etc.
		 */
	}

	public static void main(String[] args) {
		Sub5 window = new Sub5();
		window.setVisible(true);
	}

}
