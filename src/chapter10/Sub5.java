package chapter10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile; // new class

public class Sub5 {
	public static void main(String[] args) {

		try {
			RandomAccessFile ioStream = new RandomAccessFile("chapter10Sub5.txt", "rw");
			/*
			 * This is a Random access file stream. It works as both input and output
			 * stream. In the constructor we give name of the file. If the file doesn't
			 * exist. It will create it and we will be able to write into it. If the file
			 * exists. We will be overwriting it from the beginning of the file.
			 * 
			 * "rw" means that we will be reading and writing to the file. "r" would mean
			 * that we will be reading the file, and not making any changes.
			 */

			ioStream.setLength(0);
			/*
			 * If the file already exists. We will be overwriting bytes. This way we change
			 * length in bytes of the file to 0. This means that all the data that was there
			 * will be lost. Alternatively we may setLenght to for example 8, then all the
			 * data beyond 8th byte counting from the 0th byte will be lost.
			 */

			System.out.println("Writing 5 bytes to the file");
			ioStream.writeByte(1);
			ioStream.writeByte(2);
			ioStream.writeByte(127);
			ioStream.writeByte(128);
			ioStream.writeByte(129);
			System.out.println("The lenght of the file is " + ioStream.length());
			/*
			 * Writing into a random access file. Using method writeByte(byte b). You can
			 * use literal int number. But remember that byte range is from -128 to 127. If
			 * you go above that range. The value will roll over (127 is 127, 128 is -128,
			 * 129 is -127).
			 * 
			 * length() method returns length of the file in bytes.
			 */

			System.out.println("The file pointer location is " + ioStream.getFilePointer());
			/*
			 * getFilePointer() returns index at which the pointer is now. The pointer is a
			 * point where next byte will be saved. Here it returns 5 because we saved 5
			 * bytes and now it is at sixth place, but counting from 0, it is 5th index for
			 * 6th byte.
			 */

			ioStream.seek(3);
			byte a = ioStream.readByte();
			System.out.println(a);
			/*
			 * Method seek(int n) moves pointer the certain index. number 3 moves to index
			 * number 3, practically it is 4th variables because indexes are count from 0.
			 */

			ioStream.seek(3);
			System.out.println(ioStream.readByte());
			/*
			 * If you would readByte again, this will produce another byte in order, so here
			 * we used seek again to read same byte. This time printing value directly
			 * without assigning it to a variable.
			 */

			ioStream.seek(3);
			ioStream.writeByte(-50);
			ioStream.seek(3);
			System.out.println(ioStream.readByte());
			/*
			 * Here we moved pointer to 3 again and changed one byte of data. 4th and 5th
			 * variable are not changed.
			 */

			ioStream.seek(ioStream.length());
			/* Here we moved the pointer to the end of the file. */
			System.out.println("Pointer at " + ioStream.getFilePointer() + "\nFile length " + ioStream.length());

			ioStream.writeDouble(3.14159);
			/*
			 * There are various method for various data types. For string it is still
			 * writeUTF().
			 */

			System.out.println("The lenght of the file is now " + ioStream.length());
			/*
			 * The result is 13, previous was 5. This means that size of double variable is
			 * 8 bytes. Int is 4, and byte is 1 byte.
			 */

			ioStream.seek(5);
			System.out.println(ioStream.readDouble());
			/*
			 * The previous size of the file was 5. So at 5th index was double written. Now
			 * we go back to point 5 and read the same data type that we written.
			 */

			ioStream.seek(2);
			System.out.println(ioStream.read());
			/*
			 * Returns 127. Method read() returns a byte in type of integer between 0 and
			 * 255.
			 */
			ioStream.seek(3);
			System.out.println(ioStream.read());
			/*
			 * Returns 206. We wanted to write 128 and save as byte. But it was out of range
			 * for byte, so it was saved as -128. -128 was interpreted as 206 because this
			 * method only returns from 0 to 255.
			 */
			ioStream.seek(5);
			System.out.println(ioStream.readDouble());
			/* Double was saved at 5 and here read from 5. */
			ioStream.seek(6);
			System.out.println(ioStream.readDouble());
			/*
			 * Double takes 8 bytes to be saved. If you want to read double or any other
			 * type. Read from the beginning. This double variables takes space from 5-12
			 * (5, 6, 7, 8, 9, 10, 11, 12) bytes. If you want to read a variable. You need
			 * to read from first byte. If you start reading from 6th point. It will throw
			 * an exception.
			 */

			ioStream.close();
		} catch (FileNotFoundException e) {
			System.err.println("Problem opening file.");
		} catch (IOException e) {
			System.err.println("Could not write or read.");
		}
		System.out.println("End of program.");
	}
}
