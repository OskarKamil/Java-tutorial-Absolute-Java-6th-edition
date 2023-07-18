package chapter18; //icons and how to use paths, directories etc

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Sub2 extends JFrame {

	public Sub2() {
		super("now with icons");
		setSize(300, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 1));

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(new JLabel("Do you want to exit?"));

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JButton yes = new JButton("Yes");

		ImageIcon yesIcon = new ImageIcon("yes1.png");
		yes.setIcon(yesIcon);
		/*
		 * First we created JButton with text only. In next line we created an object of
		 * type ImageIcon. This class is part of Swing library. ImageIcons can be used
		 * as icons for JButtons, JLabels and JMenuItems. The constructor of ImageIcon
		 * class is a String argument that represents the path and the name of the file.
		 * Here is "yes1.png" which is in the main folder of our project. The source
		 * code is in src folder, but the image file is one directory up, which is main
		 * folder for our project. To add an icon to the component, simply use method
		 * setIcon(imageIconObject).
		 */

		JButton no = new JButton("No", new ImageIcon("no1.png"));
		/*
		 * Here we created an object of JButton. As you see JButton, as other components
		 * can have constructor with 2 arguments. One is String which is displayed in
		 * the body of the button. And another argument is of type ImageIcon. As you can
		 * see here, we used anonymous constructor for the ImageIcon object. We will not
		 * need to refer to that icon anymore else in the code, so anonymous constructor
		 * came in handy.
		 */

		panel2.add(yes);
		panel2.add(no);

		JPanel panel1Grid = new JPanel();
		panel1Grid.setLayout(new BorderLayout());
		panel1Grid.add(panel1, BorderLayout.NORTH);
		panel1Grid.add(panel2, BorderLayout.CENTER);
		add(panel1Grid);
		/*
		 * Border layout is best option for windows with a question and 2 buttons. At
		 * north you display a text for example asking if you want to exit, or save file
		 * etc. And in the center, you display the buttons. Note that at north we have
		 * flow layout panel and at center we have another flow layout panel.
		 */

		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		JLabel label1 = new JLabel();
		label1.setIcon(new ImageIcon("wolf.png"));
		/*
		 * ImageIcon is not only for JButtons, but can also be JMenuItems and JLabels.
		 * It is possible for a button to be only an icon, without any text. In that
		 * case you can create JButton and in the constructor add ImageIcon object or
		 * use setIcon method after creating object with empty constructor of JButton.
		 * If you decide to add text after that, you can use method setText(). And
		 * similar is with JLabels. JLabels can have only text, only icon, both, or
		 * neither. Since they are part of component abstract class, the inherit method
		 * setIcon and setText. Here path of the wolf.png is the same as main folder of
		 * the project. If you do it that way, you should also use method
		 * setActionCommand, since there is no text in the constructor, the action
		 * command is empty and listener for that will not be working.
		 */

		panel3.add(label1);

		JLabel label2 = new JLabel();
		label2.setIcon(new ImageIcon("../wolf2.png"));
		/*
		 * The file wolf2.png is not in the main folder of the project. This file is in
		 * outer folder of the main folder. If you want to give a path and want to
		 * access out folder, simply put "../" <- this command says the path starts at
		 * one folder up. Up means outer folder.
		 */

		panel3.add(label2);
		add(panel3);

		pack();
	}

	public static void main(String[] args) {
		Sub2 window = new Sub2();
		window.setVisible(true);
	}
}
