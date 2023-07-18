package chapter10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Sub4d {

	public static void main(String[] args) {

		Sub4b[] simpleList = new Sub4b[2];
		simpleList[0] = new Sub4b("Rambo", 6);
		simpleList[1] = new Sub4b("Dolar", 15);

		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("chapter10Sub4d.dat"));
			outputStream.writeObject(simpleList);
			/*
			 * If you remember. Arrays are just like an objects. So we can use writeObject()
			 * method to save an array into a binary file.
			 */

			outputStream.close();
			System.out.println("Created and saved a file.");
		} catch (IOException e) {
			System.err.println("Could not create and save a file.");
		}
		System.out.println("An array has been successfully written.");

		Sub4b[] emptyList = null;

		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("chapter10Sub4d.dat"));
			emptyList = (Sub4b[]) inputStream.readObject();
			/*
			 * Same here. Reading an object (an array), and casting it onto a Sub4b[] type.
			 */

			inputStream.close();
		} catch (FileNotFoundException e) {
			System.err.println("Could not find a file");
		} catch (ClassNotFoundException e) {
			System.err.println("Could not find the class of an object");
		} catch (IOException e) {
			System.err.println("Could not read from a file");
		}

		System.out.println("Successfully read from a file");

		for (int i = 0; i < emptyList.length; i++) {
			System.out.println(emptyList[i]);
		}

	}

}