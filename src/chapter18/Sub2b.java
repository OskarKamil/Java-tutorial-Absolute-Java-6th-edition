package chapter18; //scroll bars

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Sub2b extends JFrame {
	public Sub2b(int i) {
		super("scroll bars are rea...");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300, 200));
		/*
		 * Sets limitation to how small the window can be.
		 */

		setLayout(new BorderLayout());
		add(new JLabel("Enter a large piece of text"), BorderLayout.NORTH);
		JTextArea largeText = new JTextArea(5, 5);
		largeText.setLineWrap(true);
		JScrollPane scrollText = new JScrollPane(largeText);
		if (i == 0) {
			add(scrollText, BorderLayout.CENTER);
			/*
			 * When you add raw JScrollPane to the BorderLayour (or JButton or any other
			 * component), its size will be stretched to fit all the area is available in
			 * the layout. In BorderLayour a component takes whole area available if it is
			 * in the center.
			 * 
			 * When you just create a JTextArea, the lines can be wrapped, but if you put
			 * extra lines, the area for text will automatically expand vertically making
			 * the area go over other components. That's why scroll bars were created. If
			 * your text input doesn't fit in one view, you can add it to the JScrollPane.
			 * You would think that you add scroll bars to the text field, but it's other
			 * way around. You add text field to the scroll pane. In this example the scroll
			 * bar appears only when the text reaches end of the text area bounds. There are
			 * methods that can change visibility of scroll bars.
			 */

		} else if (i == 1) {
			largeText.setLineWrap(false);
			JPanel panelWithScroll = new JPanel();
			// panelWithScroll.setLayout(new FlowLayout());
			panelWithScroll.add(scrollText);
			add(panelWithScroll);
			add(panelWithScroll, BorderLayout.CENTER);
			/*
			 * In this case, we still added the scroll panel to the center, however, first
			 * we added it to the JPanel, and then added that panel to the center of
			 * BorderLayout. In effect, when we add a JButton or JTextField/Area to the
			 * panel, it will not get stretched to fit the space. See next example for
			 * simple solution.
			 * 
			 * Also, in this example the size of the text space is small because the initial
			 * size of lines/characters per line/field is small. If the size was larger, the
			 * text area would be larger too.
			 * 
			 * In this case, both vertical and horizontal scroll bars are visible because
			 * lines are not wrapped in here.
			 */

		} else if (i == 2) {
			largeText.setLineWrap(false);
			JPanel panelWithScroll = new JPanel();
			panelWithScroll.add(scrollText);
			panelWithScroll.setLayout(new GridLayout(1, 1));
			add(panelWithScroll);
			scrollText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			// scrollText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			// scrollText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

			/*
			 * In here we added the JScrollPane to the JPanel which has GridLayout. Grid
			 * Layout stretches text field and buttons to the max to fit the size of the
			 * cell, which in effect is the only grid we have, and that grid is stretched to
			 * the whole size of CENTER part of the BorderLayout. I know it's much. Read
			 * next comment for simple explanation.
			 * 
			 * A method to set visibility of scroll bars. You can set whether
			 * horizontal/vertical scroll bars are visibly and when. Always are always
			 * displayed, never are never, and as needed are only displayed when the text
			 * goes out visible space, so you can say they are automatic.
			 */
		}
		/*
		 * EXPLANATION how some JTextArea and JTextField and JButton are stretched or
		 * small in size. When you add a JButton or JTextArea to the GridLayout, the
		 * button and area will get stretched so it fill up the cell completely. When
		 * you add them in the BorderLayout to the Center, they will also stretch to the
		 * free space, ensured there is free space when NORTH and other parts are not
		 * taking the space.
		 * 
		 * When you add a button or text area to the panel which has FlowLayout
		 * (FlowLayout is also the default layout of the panel/frame), the component
		 * such as button or text area will have size as specified. If field area
		 * initial size are 4 line and 30 character, size of this area WILL ALWAYS BE
		 * THE SAME in FlowLayout. Resizing the window will not change the size of that
		 * text area.
		 * 
		 * But if you add the text area (when we say text area, we mean scroll panel
		 * equally) to the Grid/Border.Center layout, the size of the area will fit to
		 * the space, and when we resize the window, the text area also get resized. If
		 * you want to add a resizable text area somewhere, first put this in the grid
		 * layout and set it 1 by 1 (or 0, 1 is equal) so the text area fills up
		 * completely the grid which is in fact, only one cell, which is in fact, only
		 * one panel.
		 */
	}
	/*
	 * The scroll panel is not limited to the the text areas only. In the
	 * JScrollPane constructor you can give any type of component to as the
	 * argument. It can be a text field, can be a panel with text field and few
	 * buttons in it. JLabels also has setVisible() method. If you make a label
	 * invisible, it will disappear and if it is in flow layout, the rest components
	 * will get its place. You can use in combination with buttons and one button
	 * can make one JLabel disappear and appear another JLabel, and the other button
	 * can make other thing around. If you add only ImageIcon to the JLabel, it will
	 * be like replacing images.
	 */

	public static void main(String[] args) {
		int i = 2;
		Sub2b window = new Sub2b(i);
		window.setVisible(true);

	}

}
