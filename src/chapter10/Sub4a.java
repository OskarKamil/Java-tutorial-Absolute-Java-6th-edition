package chapter10;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Sub4a {

	public static void main(String[] args) {

		int n1 = 5;
		int n2 = 10;
		int n3 = 15;
		int n4 = 20;
		int n5 = 30;
		int[] nArray = { n1, n2, n3, n4, n5 };

		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("chapter10Sub4a.dat"));
			outputStream.writeInt(n1);
			outputStream.writeInt(n2);
			outputStream.writeInt(n3);
			outputStream.writeInt(n4);
			outputStream.writeInt(n5);
			for (int i : nArray) {
				outputStream.writeInt(i);
			}
			/*
			 * It is good to save one type of data into one binary file. Mixing data types
			 * in a binary file can be troublesome. It is good to save only integers with
			 * integers and double with double, string with string and so on.
			 * 
			 * Also one way to store an array is to use for each loop.
			 */
			outputStream.close();
			System.out.println("File saved successfully");

		} catch (IOException e) {
			System.err.println("Could not save");
		}

		int[] intArray = new int[50];

		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("chapter10Sub4a.dat"));
			System.out.println("Now reading from a file.");

			try {
				int i = 0;
				while (true) {
					intArray[i] = inputStream.readInt();
					System.out.println(intArray[i]);
					i++;
				}
			} catch (EOFException e) {
				System.out.println("End of file. Nothing more to read.");
			}
			/*
			 * Typical example of reading from a binary file and checking end of file.
			 * Basically you need to create another try catch block. And inside of it
			 * infinite loop that will be reading only integers from it (only integers
			 * because one file should have only one type of data). And when it read all the
			 * integers and try to read beyond the binary file. A EOFException is thrown.
			 * EOF is end of file exception. It is thrown when reading from a binary file.
			 * Then we can easily catch it and inform user that the end of file has been
			 * reached. Not always exceptions are bad. Sometimes they are the only way to
			 * detect events which are not able to be detected by methods.
			 * 
			 * Note that this kind of exception occurs with ObjectInputStream. When reading
			 * from a text file, this kind of exception is not thrown. With text files, you
			 * can use hasNext().
			 */

			inputStream.close();
		} catch (IOException e) {
			System.err.println("Could not read a file.");
		}

	}

}