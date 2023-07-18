package chapter18; //icons and how to use paths, directories etc

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Sub2a extends JFrame {

	public Sub2a() {
		super("now with icons 2");
		setSize(300, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 1));

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(new JLabel("Do you want to save?"));

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JButton yes = new JButton("Yes");

		ImageIcon yesIcon = new ImageIcon("yes1.png");
		yes.setIcon(yesIcon);
		JButton no = new JButton("No", new ImageIcon("no1.png"));
		yes.setMargin(new Insets(25, 25, 25, 25));
		// yes.setMargin(new Insets(2, 11, 2, 11));
		no.setMargin(new Insets(0, 0, 0, 0));
		/*
		 * method setMargin(new Insets(5, 5, 5, 5)) sets how many pixels of space must
		 * be from the icon and text to the border of the button. Going in order of
		 * arguments: top, left, bottom, right. Default argument are 2, 11, 2, 11. So if
		 * you want minimal margins, use 0, 0, 0, 0.
		 */

		panel2.add(yes);
		panel2.add(no);

		JPanel panel1Grid = new JPanel();
		panel1Grid.setLayout(new BorderLayout());
		panel1Grid.add(panel1, BorderLayout.NORTH);
		panel1Grid.add(panel2, BorderLayout.CENTER);
		add(panel1Grid);

		JLabel label1 = new JLabel("First JLabel", new ImageIcon("wolf.png"), SwingConstants.RIGHT);
		JLabel label2 = new JLabel("Second JLabel", new ImageIcon("../wolf2.png"), SwingConstants.LEFT);
		// label1.setHorizontalAlignment(SwingConstants.CENTER);
		/*
		 * JButton and JMenuItem has constructor of String only, ImageIcon only, or
		 * both. Same with JLabels, but JLabel has also constructor with 3rd argument.
		 * The third argument is of type int, but the number doesn't give us any clue so
		 * it's good to use constant names of SwingConstants class. Third argument is an
		 * alignment of the JLabel in the line. It is named horizontal alignment. In our
		 * example we used RIGHT and LEFT. When you run the program and resize the
		 * window, you will see that the JLabels stick to right and left edge of the
		 * window (actually it's a cell because we are inside the GridLayout. If we had
		 * more columns, the JLabel would be aligned to the left/right side of the cell,
		 * or panel if we have multiple panels. The default alignment for JLabel is left
		 * alignment. You can always change the alignment later with
		 * setHorizontalAlignment() method which takes int as argument, but you should
		 * use SwingConstants constant names.
		 * 
		 * There is also SwingConstants.LEADING and TRAILING constant names. English
		 * language is read from left to right. But some languages are read from right
		 * to left. So you may want to set alignment of the label depending on the
		 * language it is written in. But it does not matter usually as it is only
		 * cosmetic change. Just stick to the LEFT, CENTER, RIGHT names.
		 */

		label2.setVerticalAlignment(SwingConstants.BOTTOM);
		label2.setVerticalTextPosition(SwingConstants.TOP);
		label2.setHorizontalTextPosition(SwingConstants.LEFT);
		/*
		 * Just as setHorizontalAlignment, Vertical does same thing. When you have a
		 * cell, or panel, the JLabel is by default aligned to top left corner. You can
		 * change that by using those two method to align a JLabel to different place.
		 * 
		 * Another two methods are set VerticalTextPosition and Horizontal. Those
		 * methods refer to position of the text relative to the icon. By default the
		 * text is on the right side of the icon in the middle. You can change that and
		 * move text to be on the right side of the icon, and in the upper or lower part
		 * of the label relative to the icon. Note that it does not make text to be
		 * above/under the icon, it moves the text to be in the upper edge and lower
		 * edge to the icon.
		 */

		// label2.setEnabled(false);
		/*
		 * Just as textField or textArea is grayed out, same JButton and JLabel can be
		 * grayed out by using method setEnabled().
		 */

		add(label1);
		add(label2);

		// pack();
	}

	public static void main(String[] args) {
		Sub2a window = new Sub2a();
		window.setVisible(true);
	}
}
