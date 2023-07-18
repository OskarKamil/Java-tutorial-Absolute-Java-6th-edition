package chapter1;
/* Package is like a folder that groups similar classes. */

public class Sub1 {
    public static void main(String[] args) {
        /*
         * public class Sub1 is the main thing in a class. That's how a class starts.
         * Important thing is that a class name must be the same as the file name,
         * because one file is per one class only. Next line public static void
         * main(String[] args) is basically a standard line that starts a class. Inside
         * you put anything that you want to happen.
         */

        System.out.println("Hello reader.");
        System.out.println("Welcome to Java.");
        System.out.println("Let's demonstrate a simple calculation.");
        /*
         * System.out is an object. println(string) is a method. It is a functions that
         * prints out text in parentheses into a console. If it's a raw text it needs to
         * be in quotes.
         */

        int answer;
        answer = 2 + 2;
        /* Like any other language. Integer, assign new value. */

        System.out.println("2 plus 2 is " + answer);
        /*
         * In parentheses, you can add more strings to be printed to the console. String
         * must be in quotes followed by '+' sign and name of variable of int or any
         * other number.
         */
    }
}
