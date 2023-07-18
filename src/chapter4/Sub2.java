package chapter4;

import java.util.Scanner;

public class Sub2 {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		Sub2a date01 = new Sub2a();
		
		while(!(date01.setDay(keyboard.nextInt())));
		while(!(date01.setMonth(keyboard.nextInt())));
		while(!(date01.setYear(keyboard.nextInt())));
		/* The program executes the method setDay which is a mutator in class Sub2a. This method gets argument as keyboard input of an int. And returns true if value was valid or false when there was an erorr. Loop while will loop as long as the invalid data is entered, which will result in false return, which must be negated to make the loop repeat with true result. */
		
		System.out.println(date01.getDay());
		System.out.println(date01.getMonth());
		System.out.println(date01.getYear());
		/* Simply outputs using accessors. */
}
}