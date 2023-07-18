package chapter10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Sub4c {

	public static void main(String[] args) {

		try {
			ObjectOutputStream outputSteam = new ObjectOutputStream(new FileOutputStream("chapter10Sub4c.dat"));
			System.out.println("Opening a file.\nSaving to a file");

			Sub4b object1 = new Sub4b("Sisi", 9);
			Sub4b object2 = new Sub4b("Kaia", 6);
			/* Standard creating objects. */

			outputSteam.writeObject(object1);
			outputSteam.writeObject(object2);
			/*
			 * You would save an object the same way as any other primitive data type. Using
			 * object outputStream, simply use method writeObject(object), to save an
			 * object. Remember. That object must be a type that is serializable.
			 */

			outputSteam.close();
			System.out.println("Saving to a file: OK");
		} catch (IOException e) {
			System.err.println("Could not save a file");
		}

		System.out.println("\n=========================================\n");

		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("chapter10Sub4c.dat"));
			System.out.println("Reading from a file.");
			Sub4c objFromFile1 = (Sub4c) inputStream.readObject();
			Sub4c objFromFile2 = (Sub4c) inputStream.readObject();
			/*
			 * Reading objects from a file. Note that the method readObject() returns an
			 * object of type object. That's why downcasting is present here. To cast from
			 * object to Sub4c.
			 */

			System.out.println("Read two objects:");
			System.out.println("1. " + objFromFile1);
			System.out.println("2. " + objFromFile2);
			inputStream.close();

		} catch (FileNotFoundException e) {
			System.err.println("Could not find a file.");
		} catch (ClassNotFoundException e) {
			System.err.println("Could not find a proper class file.");
		} catch (IOException e) {
			System.err.println("Could not read from a file.");
		}
		/*
		 * FileNotFoundException indicates that the file does not exists or could not be
		 * opened. ClassNotFoundException is thrown by readObject() method when trying
		 * to cast down to a Sub4c. This class also has to be serializable. If it is
		 * not, compiler will simply tell you that this class cannot be found.
		 */

	}

}

/*
 * Info. When you save the same object twice, the second time, and any another
 * after that, the only thing saved is only the serial number of the object.
 * Since the same object is already saved, just to save and optimise space, only
 * the serial number is saved.
 * 
 * Also don't mix data types. Store one type of data in one file. Don't mix
 * objects with primitive types.
 */