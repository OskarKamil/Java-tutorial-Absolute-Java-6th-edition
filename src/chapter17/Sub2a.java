package chapter17;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sub2a implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
/*
 * For a class to be a listener we need to import these 2 classes and implement
 * this interface. Next we need to define a method actionPerformed with
 * ActionEvent e argument, and this is the only method that we need to define.
 * ActionListener interface has only one method heading. And in the body of this
 * method, decide what is going to happen. In this case, System.exit(0), is
 * performed, so it simply closes the program.
 * 
 * Note that this method must have an ActionEvent object as a parameter. It is
 * because the interface that this class implements says so, otherwise the
 * firing an event would not work as behind the scenes in SWING source code it
 * must be implemented that way.
 */
