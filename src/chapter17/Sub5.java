package chapter17;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Sub5 extends JFrame {
	public Sub5() {

		super("Text fields and text areas");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		setLayout(new GridLayout(0, 1));

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(new JLabel("Your name"));
		JButton enterButton = new JButton("Enter");
		JTextField textField = new JTextField(10);
		enterButton.addActionListener(new enterButtonListener(textField));
		panel1.add(textField);
		panel1.add(enterButton);
		add(panel1);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(new JLabel("Your name again"));
		JButton enterButton2 = new JButton("Enter");
		JTextField textField2 = new JTextField("eg. Mike", 10);
		panel2.add(textField2);
		panel2.add(enterButton2);
		add(panel2);
		JLabel labelReply = new JLabel();
		enterButton2.addActionListener(new enterButton2Listener(textField2, labelReply));
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.add(labelReply);
		add(panel3);

		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());

		JTextArea textArea = new JTextArea("optional", 2, 10);
		/*
		 * Both textarea and textfield may have first argument of String as an initial
		 * optional String displayed in the text component when created. Text Field is
		 * only one line of text. It can store as many characters as it wants but the
		 * int in the constructor decided on the lenght of that field. If you enter more
		 * than the field, the text entered will go out of bonds and won't be visible.
		 * The measurement of lenght of text component is capital letter M. The number
		 * in the constructor for example 10, means that the field will be long enough
		 * to fit exactly 10 capital letters M. Usually the text we enter is not all Ms
		 * so on average the visible characters count is more that we specify.
		 * 
		 * TextArea is like TextField but can hold multiple lines. Constructor have
		 * optional String. Apart from that, first int argument is minimal number of
		 * lines, and second one is minimal lenght of letter in one line.
		 */

		textArea.setLineWrap(false);
		panel4.add(textArea);
		add(panel4);
		/*
		 * setLineWrap() is a useful method. Previously we said that the constructor to
		 * a TextField has 2 int arguments for minimum size of lines and characters per
		 * line. When you enable setLineWrap, the TextField will not stretch to
		 * accomodate for more characters in line. Instead the word will jump to another
		 * line so the lenght of the field is never changed. However if you run out of
		 * lines, no matter if you have wrapping on or off, the number of lines can
		 * increase and the TextField will also get bigger to accommodate for more
		 * lines.
		 */
	}

	public static void main(String[] args) {
		Sub5 window = new Sub5();
		window.setVisible(true);
	}

	private class enterButtonListener implements ActionListener {

		JTextField tempField = null;
		/*
		 * Temporary name for JTextField.
		 */

		public enterButtonListener(JTextField textField) {
			tempField = textField;
		}

		public void actionPerformed(ActionEvent e) {
			tempField.setText("Hello " + tempField.getText());
			/*
			 * JTextField has setText() method which sets a new text inside the field. And
			 * getText() which returns String of what is currently inside that field.
			 */
		}

	}

	private class enterButton2Listener implements ActionListener {

		JTextField tempField = null;
		JLabel tempLabel = null;

		public enterButton2Listener(JTextField field, JLabel label) {
			tempField = field;
			tempLabel = label;

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (tempField.getText().isEmpty())
				tempLabel.setText("Your name cannot be empty");
			else {
				tempLabel.setText(tempField.getText() + " is the best!");
				tempField.setEditable(false);
				((JButton) e.getSource()).setEnabled(false);
				/*
				 * Both JTextField and JTextArea have setEditable() method which sets whether an
				 * input can be edited. Both of them are derived classes of JTextComponent.
				 * 
				 * JButton also has a method setEnable() which changes state of a button. If set
				 * to false, it will be grayed out and not being able to click on.
				 */
			}

		}
	}

}
