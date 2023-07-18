package chapter2;

import java.util.Scanner; //we need to include Scanner class to read keyboard input

public class Sub2 {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        /* We need to create a new object, so we can use methods to input text. */

        int n1, n2;
        System.out.println("Enter 2 whole number:");
        n1 = keyboard.nextInt();
        n2 = keyboard.nextInt();
        System.out.println("You entered " + n1 + " and " + n2); // echo input. It's a good practise
        /* nextInt() lets us input an integer number. */

        double d1;
        System.out.println("Enter 1 decimal point number: ");
        d1 = keyboard.nextDouble(); //same but double
        System.out.println("You entered " + d1);

        String word1, word2;
        System.out.println("Enter 2 words separated either by space or enter:");
        word1 = keyboard.next();
        word2 = keyboard.next();
        System.out.println("You entered \"" + word1 + "\" and \"" + word2 + "\".");
        /* .next() reads string of characters, any white spaces (new line, space, tab etc.) terminates the read. Thus,
        first white space means end of input. */

        String junk = keyboard.nextLine();
        /* To send input to the program, we need to press enter [Return] key. Then all methods but nextLine() don't read
        white spaces. They read all characters but leave \n in the buffer. nextLine() reads input until it finds the
        next line symbol. Thus other methods leave \n in the buffer, nextLine() finds the first character as \n new line
        and that's how empty string appears. In short, either you empty the buffer before (explained later) you used any
        keyboard input that resulted in pressing Enter key. */

        String line1, line2;
        System.out.println("Now Enter 2 lines of text:");
        line1 = keyboard.nextLine();
        line2 = keyboard.nextLine();
        /* Reads all characters including spaces and tabs. When it finds \n, the string is formed. */

        System.out.println("Now enter a text with ## at any point:");
        keyboard.useDelimiter("##");
        line1 = keyboard.next();
        System.out.println(line1);
        /* Quick way to change the delimiter. .next() method will read the word until the next white space is met. Here
        we change from white spaces to ##. Now string variables will be able to hold characters with spaces. */
    }
}