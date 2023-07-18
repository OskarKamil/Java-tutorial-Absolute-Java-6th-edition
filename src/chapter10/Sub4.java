package chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream; //to read a binary file
import java.io.ObjectOutputStream; //to save to binary file

public class Sub4 {

	public static void main(String[] args) {

		int n1 = 10;
		int n2 = 13;
		double d1 = 11.1;
		double d2 = 22.2;
		String s1 = "Hello";
		String s2 = "World";

		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("chapter10Sub4.dat"));
			System.out.println("Saving data...");
			outputStream.writeInt(n1);
			outputStream.writeInt(n2);
			outputStream.writeDouble(d1);
			outputStream.writeDouble(d2);
			outputStream.writeUTF(s1);
			outputStream.writeUTF(s2);
			/*
			 * To save data to a binary file, you pin the file stream to the
			 * ObjectOutputStream and use methods writeInt or any other method depending on
			 * the variable type. writeInt to write int and writeDouble to write double. For
			 * string, use writeUTF. When saving data, you do not need to include any spaces
			 * or new lines. Those variables are saved in the same way they are stored in
			 * program memory, in bytes. 0111011
			 */
			outputStream.close();
			System.out.println("Closed and saved file.");
		} catch (IOException e) {
			System.err.println("Problem with file output.");
		} /*
			 * Note that the try catch block wraps around all the methods used to write to a
			 * file. This is because each of those methods can throw an IOexception if the
			 * variable type is not as it should be. It is, if you use writeInt to write a
			 * double or any other way around.
			 */

		n1 = 0;
		n2 = 0;
		d1 = 0;
		d2 = 0;
		s1 = null;
		s2 = null; // resetting all variables
		System.out.println(n1 + " " + n2 + " " + d1 + " " + d2 + " " + s1 + " " + s2);

		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("chapter10Sub4.dat"));
			System.out.println("Reading from a file...");
			n1 = inputStream.readInt();
			n2 = inputStream.readInt();
			d1 = inputStream.readDouble();
			d2 = inputStream.readDouble();
			s1 = inputStream.readUTF();
			s2 = inputStream.readUTF();
			System.out.println(n1 + " " + n2 + " " + d1 + " " + d2 + " " + s1 + " " + s2);
			/*
			 * Similarly as saving data. Reading data, you use readInt to read int and so
			 * on. You need to remember in which order you save data and what types. This
			 * whole block is wrapped in try and catch because reading variable type and
			 * assigning it to a wrong variable type, will cause in exception. You cannot
			 * assign a string to an int. This will cause an exception, so it is important
			 * to read proper variable types.
			 */
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Could not open.");
		}

		System.out.println("Program closes.");
		System.exit(0);

	}

}