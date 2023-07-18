package chapter17;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Sub4 extends JFrame {

	public Sub4() {
		super("MENU as meh-nyoo, not meh-nooo");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JMenu mFile = new JMenu("File");
		JMenuItem a1 = new JMenuItem("Open");
		JMenuItem a2 = new JMenuItem("Save");
		JMenuItem a3 = new JMenuItem("Print");
		JMenuItem a4 = new JMenuItem("Close");
		JMenu mMore = new JMenu("More...");
		JMenuItem b1 = new JMenuItem("extra action");
		JMenu mAbout = new JMenu("Help");
		JMenuItem c1 = new JMenuItem("About");
		/*
		 * Here we are creating menus. JMenu is a general menu like File, Edit, Source,
		 * Window, Help etc. JMenu holds other JMenus inside or JMenu items. As you can
		 * see in the example, you can nest menus. Next is JMenuItem, it is like an
		 * option that does some action like Open File, Print document, Close, About,
		 * Select all.
		 */

		mFile.setFont(new Font("Arial", Font.PLAIN, 14));
		/*
		 * Changing a font of a component. You can use the same method for a label,
		 * button etc.
		 */
		mFile.add(a1);
		mFile.add(a2);
		mFile.add(a3);

		mMore.add(b1);
		mMore.add(b1);
		mMore.add(b1);
		mMore.add(b1);
		mMore.add(new JMenuItem("extra action"));
		mMore.add(new JMenuItem("extra action"));
		mMore.add(new JMenuItem("extra action"));
		mFile.add(mMore);

		mFile.add(a4);

		mAbout.add(c1);
		/*
		 * Adding menu items to the menu titles. Everything seems pretty straight
		 * forward.
		 */

		JMenuBar bar = new JMenuBar();
		bar.add(mFile);
		bar.add(mAbout);

		setJMenuBar(bar);

		/*
		 * After you decide what menu titles you want to have, they have to be displayed
		 * somewhere. You can't just create the menu titles, you need to add them
		 * somewhere. A place where menu titles are stores is a bar, namely, JMenuBar.
		 * You need to create a new object of type JMenuBar and add all menu titles you
		 * want. But that is not done yet. To add that bar to your frame, you need to
		 * invoke a method setJMenuBar(bar) that will add a JMenuBar object to the
		 * frame.
		 */

		setLayout(new GridLayout(0, 3));
		add(new JButton("Just a button"));
		add(new JButton("Just a button"));
		add(new JButton("Just a button"));
		add(new JButton("Just a button"));
		add(new JButton("Just a button"));
		add(new JButton("Just a button"));

		pack();
		/*
		 * New method pack(). This method resizes the frame to the minimum that will fit
		 * all the components. You can call it, rezise to fit.
		 * 
		 * AbstractButton is an abstract class that is a parent to JButton, JMenuItem
		 * and JMenu. So in other words, all those classes are buttons and they fire
		 * ActionListener type of event. Some of the methods of AbstractButton
		 * setBackground, addActionListener, removeActionListener, getActionComman,
		 * setText, getText, setPreferredSize, setMaximumSize, setMinimumSize.
		 */
	}

	public static void main(String[] args) {
		Sub4 window = new Sub4();
		window.setVisible(true);
	}
}
