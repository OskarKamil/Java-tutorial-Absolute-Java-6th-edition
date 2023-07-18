package chapter3;

import java.util.Scanner;

public class Sub1{
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int points;
		short select;
		
		System.out.println("Enter a number of point you received:");
		points = keyboard.nextInt();
		
		if(points>75)
			System.out.println("Great. You passed.");
		else
			System.out.println("You failed. Try again.");
		/* IF statement. Nothing really to explain. Can be nested if else if else if else. Works same as c++ or any other language. && both, || either etc.*/
		
		System.out.println("What would you like to do?\n\n"
				+ ""
				+ "[1] Say hello\n"
				+ "[2] Say goodbye\n"
				+ "[3] Repeat your exam result\n"
				+ "[0] Close the program\n");
		select = keyboard.nextShort();
		
		switch (select) {
		case 1:
			System.out.println("Hello user");
			break;
		case 2:
			System.out.println("Goodbye user");
			break;
		case 3:
			if(points>75)
				System.out.println("Great. You passed.");
			else
				System.out.println("You failed. Try again.");
			break;
		case 0:
			System.exit(0);
		default:
			System.out.println("Wrong choice\nThe Program will close.\n******************************************");
			System.exit(0);
		}
		/* Nothing really to explain. Switch here works same as c++. */
		
		String result;
		result = (points >75) ? "passed" : "failed";
		System.out.println(result);
		/* Conditional operator. Usually not used because it's not easy to read. Syntax
		 * (condition) ? valueiftrue : valueiftrue; 
		 * This will return either left or right side whether it's true or false.  */
	}
}