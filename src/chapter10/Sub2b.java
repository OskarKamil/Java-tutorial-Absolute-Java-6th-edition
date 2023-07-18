package chapter10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Sub2b {

	public static void main(String[] args) {

		try {
			BufferedReader inputStream = new BufferedReader(new FileReader("chapter10Sub2.txt"));
			/* You do not use FileInputStream with BufferedReader. You use FileReader. */
			PrintWriter outputSteam = new PrintWriter(new FileOutputStream("chapter10Sub2a.txt"));

			String line = inputStream.readLine();
			while (line != null) {
				System.out.println(line);
				line = inputStream.readLine();
			}
			/*
			 * This is an example how to safely read lines from file using BufferedReader
			 * class. BufferedReader is still a pretty common class to read from text files.
			 * It is older than Scanner and has fewer methods. That's why you need workaround
			 * to check if the file has more lines.
			 * 
			 * If the line is empty in the text file. This will just return an empty string.
			 * Empty string is not the same as null string. It will return null string if
			 * text file is finished. And throw an exception if file is not accessible.
			 */

			inputStream.close();
			outputSteam.close();

		} catch (FileNotFoundException e) {
			System.out.println("Problem opening file");
		} catch (IOException e) {
			System.out.println("Error reading from a file");
		}
		/*
		 * When using buffered reader it is good to wrap whole code around in try and
		 * catch blocks because some of the methods of it can throw an exception. Like
		 * end of file and similar.
		 */

	}

}
/*
 * Also buffered reader doesn't have readInt() etc. Scanner has methods to read
 * numbers, but this one doesn't. You should combine it with StringTokenizer and
 * then using Integer.parseInt() or double and similar if you want to read
 * numbers from text.
 */
