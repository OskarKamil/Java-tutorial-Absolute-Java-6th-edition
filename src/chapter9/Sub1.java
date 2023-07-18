package chapter9;

import java.util.Scanner;

public class Sub1 {

    protected static int getInt(Scanner keyboard) {
        int number = 0;
        boolean done = false;

        do {
            try {
                System.out.println("Enter a whole number: ");
                number = keyboard.nextInt();
                done = true;
            } catch (Exception e) {
                System.out.println("Wrong input. Try again.\n");
                keyboard.nextLine();
            }
            /* Example of try and catch block. Try block tries to catch an exception (an error). And when it is found, the control is passed to catch block with the exception snipped into e parameter in catch definition. When exception occurs, the try block is terminated and immediately catch block is run. If no exception occurs, then catch block is never run. If there was no try and catch block. The program would simply close due to exception. */

        } while (done == false); // or !done
        /* Example of "done" loop. It will be looped until the input is correctly entered. */

        return number;
    }
    /* Your method can also take Scanner type object as a parameter. */


    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("You have entered: " + getInt(keyboard));
        /* If you remember. First the method is being executed because with + operator, first on the first statements are executed. */

        int number1;

        System.out.println("Please do not enter number 0");
        try {
            number1 = keyboard.nextInt();
            if (number1 == 0) throw new Sub1a();
        } catch (Sub1a e) {
            System.out.println(e.getMessage());
        }
        /* Here is how we throw exceptions. We can throw a new exception anywhere in try block when we think we should throw. If it was code for division and one number would be zero. Here we detect if it is zero, and we throw new exception. The exception we throw is of type Sub1a which extends Exception so Sub1a is a type of Exception too. We threw exception using zero constructor. Sub1a is an object, and we created this object using zero constructor. When zero constructor is invoked, the string is passed to super constructor to its parent class which is Exception. All exception classes inherit getMessage() method which returns the message that we run with the constructor. When code results in exception, for example, something that causes an exception like accessing an array out of bounds, if it is inside try block, block catch is immediately run, or, you can manually force the cody to throw an exception by using keyword throw. And then using catch block, you decide whether program is closed or keeps running.
         *
         * In block catch we could have changed Sub1a for just Exception, and since Sub1a is of exception type, in this case it would make no difference. Parameter e can be of different name, but usually e is used.
         *
         *  Since Sub1a() is an object. We could have also created new Sub1a(). And then use throw Sub1a without using new because the Sub1a we created before. */

        int number2;
        System.out.println("Please enter 0, 1 or 2");
        try {
            number2 = keyboard.nextInt();
            if (number2 == 0) throw new Sub1a("You entered number 0");
            if (number2 == 1) throw new Sub1b(number2);
            if (number2 == 2) {
                Sub1b error = new Sub1b("Wrong number");
                throw error;
            }
        } catch (Sub1a e) {
            System.out.println(e.getMessage());
        } catch (Sub1b e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /* Here is a good example of how exceptions works. If exception occurs. Whether by dividing by zero or throwing an exception. The try code block is terminated and control is passed to catch block with the new object created (anonymous) snipped to parameter e in catch block. Each exception class inherits getMessage() method. Each try block can have more than one catch block. IMPORTANT rule is to properly order catch blocks. Parent exception classes, cannot be above derived classes. For example. If first catch block was Exception, then other catch blocks would never be executed because Exception is a parent class of all exception derived classes and when it happens, other catch blocks cannot be executed. Luckily the IDE will inform you about that. */


    }
}