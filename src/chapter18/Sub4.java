package chapter18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
/*
 * CTRL + SHIFT + F autoformats the code
 * 
 * CTRL + SHIFT + O autoformats the import statements
 */

@SuppressWarnings("serial")
public class Sub4 extends JFrame implements ActionListener {

	Color newColor = null;
	JPanel gridPanels = new JPanel();

	public Sub4() {
		super("JColorChooser is lit");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JButton addColorButton = new JButton("Add colour");
		addColorButton.addActionListener(this);
		JButton clearColorsButton = new JButton("Clear");
		clearColorsButton.addActionListener(this);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(Color.GRAY);
		buttonsPanel.setLayout(new FlowLayout());
		buttonsPanel.add(addColorButton);
		buttonsPanel.add(clearColorsButton);

		add(buttonsPanel, BorderLayout.SOUTH);

		// JPanel gridPanels = new JPanel();
		gridPanels.setLayout(new GridLayout(1, 0));

		add(gridPanels, BorderLayout.CENTER);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add colour")) {
			newColor = JColorChooser.showDialog(this, "Pick a new colour", null);
			if (newColor != null) {
				JPanel anotherPanel = new JPanel();
				anotherPanel.setBackground(newColor);
				gridPanels.add(anotherPanel);
				validate();
			}

		} else if (e.getActionCommand().equals("Clear")) {
			gridPanels.removeAll();
		}

		SwingUtilities.updateComponentTreeUI(this);
		/*
		 * JColorChooser.showDialog(from what frame, "Title of the window", initial
		 * colour) is a very useful tool. This method opens up a colour choose and
		 * returns object of type Color.
		 * 
		 * New thing here is validate(). It is similar to setVisible(true). Validate
		 * updates frame if new panels are added, but do not updates the frame if panels
		 * are removed. So it is always better to use
		 * SwingUtilities.updateComponentTreeUI(this).
		 * 
		 * New method is gridPanels.removeAll(). This method removes all cells, columns
		 * and rows from a panel of gridLayout.
		 */
	}

	public static void main(String[] args) {
		Sub4 window = new Sub4();
		window.setVisible(true);
	}
}
