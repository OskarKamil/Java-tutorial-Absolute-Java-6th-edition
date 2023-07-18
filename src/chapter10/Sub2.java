package chapter10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
/* Scanner to read lines from a file. PrintWriter to write lines to a file. FileInputStream to load a text a file, FileOutputStream to save a text to a file, FileNotFoundException to detect if file could not be saved/opened, StandardCharsets is for reading and writing UTF-8 characters like ĄĆĘŁÓŚŻ and other not English characters.
 * 
 * To import things faster. You can simply enter scann and continue with [CTRL] + [SPACE], and it will auto complete your query. No need to remember what package is in a given class. */

public class Sub2 {

	public static void main(String[] args) {

		Scanner inputStream = null;
		PrintWriter outputStream = null;
		/*
		 * We are creating the variables here because when we want to bind them with
		 * filenames, they use methods/constructors which may throw an exception. So
		 * they would have to be wrapped around try and catch blocks. And as other
		 * blocks, variables created in those blocks are local to those blocks only, so
		 * those variables would not be available outside of that block. That's why we
		 * create them outside the block, so we can use it when we finish catching an
		 * exception.
		 */

		try {
			inputStream = new Scanner(new FileInputStream("chapter10Sub2.txt"), StandardCharsets.UTF_8);
			outputStream = new PrintWriter(new FileOutputStream("chapter10Sub2a.txt"), false, StandardCharsets.UTF_8);
			/*
			 * Here we are assigning a value to a variables we just created. As usual,
			 * Scanner, new Scanner, then FileInputStream to create a new object of type
			 * FileInputStream, and then type of encoding, if your file contains special
			 * characters, it is good practise to include StandardCharsets.UTF_8. Same with
			 * OutputStream, with addition to add extra "false" parameter. This parameter
			 * indicates if you want to add lines to existing file with the given name or
			 * create new empty file. False means that you want to create new file. You can
			 * take this argument as "do you want to continue this file?" No means to create
			 * a new one.
			 */
		} catch (FileNotFoundException e) {
			System.out.println("Could not open a file");
			System.exit(0);
		}

		System.out.println("Read files successfully.");

		String line1 = null;
		String line2 = null;
		String line3 = null;

		line1 = inputStream.nextLine();
		line2 = inputStream.nextLine();
		line3 = inputStream.nextLine();
		System.out.println(line1 + "\n" + line2 + "\n" + line3);
		/*
		 * Reading from file using nextLine() of Scanner object. Scanner can read a line
		 * from keyboard, and also read lines from text. inputStream is an object of
		 * type Scanner. And this object is connected to input file. Every input we read
		 * using inputStream, will be from a file.
		 */

		outputStream.println(line1);
		outputStream.print(line2 + "\n");
		outputStream.print(line3 + " - this is the last line of the file");
		/*
		 * Writing to a file. outputStream is an object of type PrintWriter which is
		 * bound to a file output. It has print and println methods same as System.out.
		 */

		// System.out.println(inputStream.nextLine());
		/*
		 * This will throw an exception. This is an example of unchecked exception. This
		 * exception is not checked if it throws anything, and that's why you do not
		 * need to wrap it around try and catch blocks. If it throws an exception it is
		 * usually to change the code than catch an exception.
		 */
		System.out.println(inputStream.hasNextLine());
		/*
		 * Instead you can use method hasNextLine() which will return either true or
		 * false if the calling object, in this case, an input file, has next line. You
		 * can use this inside a while loop and read only when there is a next line.
		 */
		// while(inputStream.hasNextLine()) {
		// <some code>
		// }

		inputStream.close();
		outputStream.close();
		/*
		 * It is proper to always close your files when you do not need them. If you do
		 * not do that, the files may stay opened if your program doesn't close
		 * properly. They will remain opened in the background and saving them may
		 * result in an error because they may be opened in another program.
		 */

	}

}