package chapter17;
// BorderLayout, FlowLayout, GridLayout

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Sub3 extends JFrame {

	public Sub3(int i) {
		super("Window with BorderLayout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		if (i == 1) { // BorderLayout
			setSize(200, 200);
			setLayout(new BorderLayout());

			JLabel label1 = new JLabel("first label on top");
			add(label1, BorderLayout.NORTH);

			JLabel label2 = new JLabel("second label in the center");
			add(label2, BorderLayout.CENTER);

			add(new JLabel("third label, anonymous one at the bottom"), BorderLayout.SOUTH);
			/*
			 * The components (buttons or labels for example) you add to the container (a
			 * frame for example) must be arranged in some way. To choose what layout our
			 * window (JFrame) will have, we need to use setLayout() method. And in here
			 * comes handy anonymous object. We simply added an anonymous object of type
			 * BorderLayout to the setLayout method. This type of layout arranges components
			 * (buttons, labels etc) in different sections of the container. Namely top,
			 * bottom, left, right, center using constants with names NORTH, SOUTH, WEST,
			 * EAST, CENTER. To add a component (you should know what component is by now)
			 * at one of these sections use add() method, like in example code above:
			 * add(new JLabel("label here"), BorderLayout.South); <- this will display a
			 * text on bottom of the window.
			 */

			setLocation(5, 5);
			/*
			 * A fancy method specifying the location of the frame to be created on the
			 * screen. This method creates this frame at cords 5x5 from upper left corner of
			 * the screen. You already know similar method, setLocationRelativeTo(null)
			 * which moved the frame to the center of the screen.
			 */
		}

		if (i == 2) { // FlowLayout
			setSize(700, 200);
			setLayout(new FlowLayout());

			add(new JButton("This button does nothing"));

			JLabel label1 = new JLabel("first label");
			add(label1);

			label1 = new JLabel("second label");
			add(label1);
			/*
			 * Look what we did here. We didn't use anonymous object. Neither we created
			 * label2. We reused old variable names and run it with new constructor. When
			 * you use method add(), it safely copies to data from that label, so it's safe
			 * to reassign new value to the variable name because the data it held was
			 * deeply copied. However, it looks messy so better avoid this way.
			 */

			add(new JLabel("third label"));

			add(new JButton("Neither does this one"));
			/*
			 * A different type of layout. Instead of choosing a location for where to
			 * display the components (come on, stop it), this type of layout simply dislays
			 * them next to each other starting from top of the screen in a centered line.
			 * If you add multiple components (-_-), they will be placed next to each other
			 * and all centered in a line, and if they do not fit in line, they will be put
			 * in another line. Try resizing this window to see how it works in practise.
			 */

			setLocation(205, 5);

		}

		if (i == 3) { // GridLayout
			setSize(500, 500);
			setLayout(new GridLayout(6, 6));
			// setLayout(new GridLayout(6, 0)); same as previous, read below to learn more

			// setLayout(new GridLayout(0, 6));
			/*
			 * This is a GridLayout. In other words, it's basically a table. Like a table
			 * 2x3 or a table 3x3 like for tic tac toe. However, it's not that easy here,
			 * the GridLayout is quite tricky. A GridLayout works on an ArrayList principle.
			 * You cannot fill any cell in the grid you want. You must start from most upper
			 * left cell, goind right and then starting from second row again. Also, this
			 * grid layout will never run out of space because it is flexible, if you fill
			 * in all 6x6 cells or any other n1 x n2 grid size, the grid will automatically
			 * expand. But what does it mean? Will it expand vertically or horizontally?
			 * Let's explain.
			 * 
			 * ***USE CONSOLE AND PRESS ENTER TO ADD NEW COMPONENTS TO THE GRIDLAYOUT. SWAP
			 * COMMENTS ABOVE TO TRY OUT DIFFERENT GRID LAYOUT OPTIONS.***
			 * 
			 * First example (6, 6). Our grid will look like we expect if we fill in all
			 * spaces. The grid will have 6 rows and 6 columns of buttons. But what would
			 * happen if we add one more? Let's start from beginning. When you first start
			 * creating buttons, you have only one columns and 6 rows. Then extra row is
			 * added to accommodate new buttons. Note that they have been arranged so they
			 * are in reading order, left to right. When we reach 6x6 grid, another column
			 * is added, in effect making 6x7 grid. So what's the point of saying (6, 6) if
			 * we don't start with 6x6 nor we end up with (6, 6) grid? The GridLayout is
			 * flexible, so if the first argument (first, second) is nonzero, for example,
			 * 6, then the second argument is simply ignored. First argument says what's the
			 * minimum and at the same time, maximum number of rows. We start up with 6 rows
			 * and they will never be changed. However second argument is totally ignored,
			 * we said we wanted 6 columns, but we started with only one and we will end up
			 * with as many as needed to accommodate all the components. In short, if first
			 * argument is >0, then first argument is exact number of rows and columns are
			 * flexible.
			 * 
			 * Second example (6, 0). As you already read, this is exactly same as above. If
			 * first argument is >0, then second one is ignored, it means, it can be 0, -5,
			 * -500, 10000, it is simply ignored because columns are flexible and will be
			 * added automatically when needed.
			 * 
			 * Third example (0, 6). To make it easy, let's start short. If first argument
			 * is zero, then second argument decides the exact number of columns. If number
			 * of columns is fixed, and the GridLayout needs to expand to accommodate more
			 * components, the only way to expand is to add more rows (instead of columns
			 * like in the previous example).
			 * 
			 * In first example second argument was ignored, so it could be zero. And in
			 * second example the first argument was 0 because it had to be ignored. To make
			 * it logical and easy to remember, you can set a rule that ONLY ONE ARGUMENT
			 * MUST BE 0. GridLayout must expand so either columns or rows will be added, so
			 * number 0 would mean which one would be added.
			 */

			setLocation(5, 210);
		}
	}

	public static void main(String[] args) {
		/*
		 * Usually when writing GUI applications, one class is for window which does not
		 * have main() method, and another separate class file with probably only main()
		 * method to execute the window class. In this case, we put main() method in the
		 * same file as JFrame class to save space on files. Normally, there would be no
		 * main() method here.
		 */

		Sub3 window1 = new Sub3(1);
		window1.setVisible(true);
		Sub3 window2 = new Sub3(2);
		window2.setVisible(true);
		Sub3 window3 = new Sub3(3);
		window3.setVisible(true);
		// just choosing different layouts

		int n = 1;
		String word = "empty";
		while (!(word.equalsIgnoreCase("stop"))) {
			Scanner keyboard = new Scanner(System.in);
			keyboard.nextLine();
			window3.add(new JButton("" + n++));

			// window3.setVisible(true);
			SwingUtilities.updateComponentTreeUI(window3);
			/*
			 * You are setting for a window (frame) to be visible after all components
			 * (buttons, labels etc -_-) have been added. This method refreshes the frame
			 * and displays the updated version of the window. In this loop we added a new
			 * button for each iteration. But nothing has been displayed in the frame.
			 * That's because the frame has been rendered and hasn't been refreshed. To
			 * refresh a frame you can resize it. But it is inconvenient to ask a user to
			 * keep on resizing the frame. So other way is to setVisible(true) again each
			 * time the update takes place. However for each setVisible, it makes the window
			 * appear on top of rest of the windows and that window is in focus. Which is
			 * not always desirable, at least not in this case where we need focus on the
			 * console to add buttons, but for each added button, out focus moves to that
			 * new windows. Instead we used this smart method
			 * updateComponentTreeUI(window3). Is is very similar to setVisible(), but with
			 * one difference. It updates the frame without focusing on it. So, in other
			 * words, you have 2 options to update a frame. Using setVisible(true) which
			 * updates the frame but also focuses it on top of other windows, and
			 * updateComponentTreeUI(component) which updates the frame but does not focuses
			 * on it.
			 */

			if ((word.equalsIgnoreCase("stop")))
				keyboard.close();
		}
	}

}
