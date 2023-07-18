package chapter11;

import java.io.File;

public class Sub3b {

	protected static String fileFinder(File directory, String target) {
		String result = "";

		if (!directory.isDirectory())
			return "Path is not a directory.";

		for (File currentFile : directory.listFiles()) {
			if (currentFile.isDirectory()) {
				result = fileFinder(currentFile, target);
				if (!result.equals(""))
					return result;
			} else {
				if (currentFile.getName().equals(target))
					return currentFile.getAbsolutePath();
			}
		}
		return "";
	}
	/*
	 * Explanation of this file search.
	 *
	 * First. We take parameters of type File and String. File will be used as name
	 * of the directory or path. And as this is a recursive method. With each found
	 * directory, we will open that directory and search it, and if we find another
	 * inside, we will repeat those steps. String is the name of the file that we
	 * are looking for.
	 * 
	 * Then we create String variable to store the path of the found file. First we
	 * make it empty to keep compiler happy.
	 * 
	 * Then we check if the File object that we passed as argument is a directory.
	 * This is. The argument should be a File object of "C:\\" constructor which
	 * will indicate where we want to look for for out file. We check if the File is
	 * a directory. If so, we go further with the code. If not, well, we cannot find
	 * a file inside a file obviously. We are searching folders for a file, not a
	 * file for a file.
	 *
	 * Next we use enhanced for loop. It iterates through all files in the File
	 * directory using method listFiles(). directory.listFiles() lists all files in
	 * an array, and thanks to enhanced for loop. We iterate through all the files
	 * in this folder. Using local variable of type File and name currentFile.
	 * 
	 * Then we check any of the listed files is a directory (a folder), if so, we
	 * repeat the process. We make a recursive call, this time with currentFile as
	 * directory to be searched, but with the same target String.
	 * 
	 * If the file we found is not a directory (is actually a file), we check if the
	 * name matches with getName() method and equals(string) method. If it returns
	 * true. If return currentFile.getAbsolutePath().
	 * 
	 * It may sound complicated so review this code in your own pace.
	 */

	public static void main(String[] args) {
		// File rootDir = new File("C:\\");
		// String where = fileFinder(rootDir, "myLesson.txt");
		// System.out.println(where);
		/*
		 * It will take a long time to find because partition C is large. It is better
		 * to focus on the algorithm than actually running the code.
		 */
	}
}
