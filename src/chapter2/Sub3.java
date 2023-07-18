package chapter2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sub3 {
    public static void main(String[] args) {

        Scanner fileIn = null;
        /* We create an empty object and make it empty. */

        try {
            fileIn = new Scanner(new FileInputStream("src/resources/player.txt"));
            /* We created Scanner fileIn empty. Now we are making a new way to use the stream. And new file input from file. More will be explained later. *
             */
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
            /* In short, if a file is not found, output error on screen and close problem with exit code. */
        }

        int highScore;
        String name;

        highScore = fileIn.nextInt();
        fileIn.nextLine();
        name = fileIn.nextLine();
        /* If we know how a text file looks, we can easily use the same method as from user input. */

        System.out.println("Name: " + name);
        System.out.println("High score: " + highScore);
        System.out.printf("%nEnd of file?: " + !(fileIn.hasNextLine()));
        fileIn.close();
        /* fileIn. has next line checks if the file has any more lines to read. If not, it means that we reached the end of the file. This method returns a boolean attribute. File has the next line? Answer no, if we negate it, the answer is yes (true). Then we use a method close() to close the file. */

    }
}