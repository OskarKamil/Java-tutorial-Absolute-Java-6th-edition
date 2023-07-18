package chapter10;

import java.io.FileDescriptor;
/* To change the stream back to console instead of file. */

import java.io.PrintStream;
/* To redirect either error or standard console messages to a file. The stream (a file) needs to be connected to a PrintStream type. */

import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class Sub2c {

	public static void main(String[] args) {
		
		System.out.println("This is a standard white console message");
		System.err.println("This is a red error message");
		/* System.err is used to display errors and exceptions. When an exception is thrown and not caught you can notice a red text in the console. This red message in the console is printed by this method System.err. */
		
		PrintStream errStream = null;
		try {
			errStream = new PrintStream(new FileOutputStream("chapter10Sub2c.txt"));
		}catch(FileNotFoundException e) {
			System.err.println("Could not create a file");
			System.exit(0);
		}System.out.println("File created successfully");
		/* Just like a PrintWriter object can be connected to a console or a file as an output stream. Here we can connect a PrintStream object to a file. */
		
		System.setErr(errStream);
		/* Now error stream. This is, System.out is not connected to a errStream object. And errStream object is now connected to a file. */
				
		System.err.println("This error message will be saved to a file");
		/* This error message will now be saved directly to a file. It will not be displayed in the console anymore. */
		
//		System.setOut(errStream);
		/* You can do the same with standard output stream. With this. Everything you want to print will be sent to a file. In that case, nothing well ever be printed to the console. */
		
		errStream = new PrintStream(new FileOutputStream(FileDescriptor.err));
		System.setErr(errStream);
		System.err.println("And this should be printed to the screen again");
		/* Here we changed it back to default. The errStream object is now connected to FileDescriptor.err which is basically a standard error message console stream. Then we used method setErr to connect the error message stream to the object that references error message stream. */
		
		//outStream = new PrintStream(new FileOutputStream(FileDescriptor.out));
		/* If we redirected standard output instead of error stream. We would have to connect this PrintStream object to a standard output stream, not to a error stream. */
		
		errStream.close();
	}
	
	
	
}
