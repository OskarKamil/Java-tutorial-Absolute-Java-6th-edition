package chapter10;

import java.io.File;
/* File is a class that can create files, delete files, create and delete directories (folders), check if file exists etc. */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sub3 {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		String line = null;
		String fileName = null;

		System.out.println("Enter a short sentence");
		// line = keyboard.nextLine();
		line = "short sentence";
		System.out.println(line);

		System.out.println("Enter a filename to store the sentence");
		// fileName = keyboard.nextLine();
		fileName = "chapter10Sub3.txt";
		System.out.println(fileName);

		File fileObject = new File(fileName);
		/*
		 * Creating an object of type File. This is not the same as creating new file.
		 * This is just an object that can check if the file already exists with given
		 * name and the eventually create it using methods.
		 */

		if (fileObject.exists()) {
			/*
			 * One of the methods of class File. exists() checks if a file already exists in
			 * given directory.
			 */
			System.out.println(
					"The file with given name already exists in this filepath. Do you want to delete first or choose new name?\n[1] delete first and create new file\n[2] choose new name");
			// code to enter option
			int option = 1;
			switch (option) {
			case 1:
				System.out.println("File deleted? " + fileObject.delete());
				/*
				 * One of the methods of class File. Method delete() tries to delete a file with
				 * filename given in the constructor and in the file path also given in the
				 * constructor. This method returns boolean value if the deletion was
				 * successful.
				 */
				break;
			case 2:
				// code to enter new name
				fileObject = new File("chapter10Sub3copy.txt");
				break;
			}
		}

		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream(fileObject));
			/*
			 * We will use PrintWriter as a tool to save lines to a file. Here we connect
			 * output stream with the file name we have chosen before. Using the object of
			 * type File, we give it as argument to constructor which will get its name. You
			 * can also use fileName string type instead. The effect will be the same.
			 */
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file " + fileName);
			System.exit(0);
		}

		outputStream.println(line);

		outputStream.close();
		System.out.println("File closed.");
	}

}
/* There are many more other methods for class File. */