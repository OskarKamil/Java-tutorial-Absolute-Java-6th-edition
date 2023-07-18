package chapter17;
// SWING, GUI

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * In this chapter we create windowed applications. We need to import JButton and JFrame, one is for creating clickable buttons and other is for creating windows for our programs.
 * 
 * Note that this is not an example how to create windows program in Swing, in next lesson we will see easier way to define a window program.
 */

public class Sub2 {
	public static final int WIDTH = 600;
	public static final int HEIGHT = 800;

	public static void main(String[] args) {
		JFrame firstWindow = new JFrame("Hello World windows program");
		/*
		 * To create a window we need to create JFrame object. Treat Frame as a window,
		 * so for each window we need a frame. JFrame has 2 constructors. First one is
		 * an empty constructor which will create a frame (windows) without a title and
		 * another one is with String parameter which will name the Frame.
		 */
		firstWindow.setSize(WIDTH, HEIGHT);
		/*
		 * Next thing to do after creating a frame is to set its size. Those values
		 * doesn't have to be constants, but if they are, they will be easy to change
		 * and debug.
		 */

		firstWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// firstWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		// firstWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// firstWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * After our frame (window) is created, we need to decide what happens when red
		 * X button is pressed (in Windows, other buttons in other OSs). JFrame has few
		 * static final fields (constants) of type int, but they are named in a way it's
		 * easy to understand what they mean. As you noticed pressing X button on
		 * windows not always closes the program. Sometimes it hides them in the taskbar
		 * (Skype).
		 * 
		 * DO_NOTHING_ON_CLOSE - pressing the button does nothing
		 * 
		 * HIDE_ON_CLOSE - the visibility for the frame goes to 0. The frame still
		 * exists but it's invisible
		 * 
		 * DISPOSE_ON_CLOSE - it closes the frame, it means that the frame will be
		 * removed, its components are also removed and all the memory this frame held
		 * will be released. Unlike HIDE_ON_CLOSE it will not be able to reappear, or
		 * change visibility to TRUE after you dispose it
		 * 
		 * EXIT_ON_CLOSE - closes the whole process using System Exit (0) method
		 * 
		 * When no setDefaultCloseOperation is selected, the default operation will be
		 * HIDE_ON_CLOSE. Those constant are all int types and you could replace them
		 * with 0, 1, 2, 3 numbers, but it's better to use them by the names so it's
		 * easier to read and understand.
		 */

		JButton endButton = new JButton("Click to end program.");
		/*
		 * Creating new button. A button or table or any part of GUI is called a
		 * component. Here we created a new component JButton which, as name suggests,
		 * is a button. We need to create a new object in order to create a new button.
		 * It's pretty intuitive as with JFrame, each JFrame object is a frame and each
		 * JButton object is a button. It also has 2 constructors, one is empty and one
		 * with String which will be displayed in the center of a button.
		 */

		Sub2a buttonEar = new Sub2a();
		endButton.addActionListener(buttonEar);
		firstWindow.add(endButton);
		/*
		 * We need to create an object that will be a listener. For an object to be a
		 * listener it must import 2 classes: import java.awt.event.ActionEvent; import
		 * java.awt.event.ActionListener; and implement an ActionListener interface. See
		 * Sub1a definition for more. Our button that we created will be closing a
		 * program so the name of the listener class we created should be something like
		 * EndingListener, but for sake of this course consistency, we named it Sub2a.
		 * 
		 * Let's explain the code.
		 * 
		 * First we create a new object of Sub2a.
		 * 
		 * Then we invoke method addActionListener using endButton as our calling object
		 * and buttonEar as the argument to the method. This line of code connects a
		 * listener to the component. In other words, we connected action of pressing a
		 * button with an action that will be performed when the button is pressed. What
		 * action will happen when the button is pressed, is defined in Sub1a class. If
		 * you have a look at it now, the action it performs is System.exit(0);. So it
		 * simply closes the program when the button is pressed.
		 * 
		 * Last line is a method add with calling object firstWindow and an argument
		 * endButton. It is pretty straightforward. The button that we created is simply
		 * added to our window and will be displayed in it.
		 */

		firstWindow.setVisible(true);
		/*
		 * It may seem obvious, but for each window we need to decide whether it's
		 * visible or not, meaning whether the window is transparent or not.
		 */

		firstWindow.setLocationRelativeTo(null);
		/*
		 * Without this line, our window will always be created in top left corner of
		 * the screen. This code makes sure that this window will be created in the
		 * center of the screen.
		 */
	}
}
