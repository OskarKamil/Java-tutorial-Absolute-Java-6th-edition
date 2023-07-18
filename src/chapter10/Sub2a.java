package chapter10;

import java.util.Scanner;

public class Sub2a {

	public static void main(String[] args) {

		Scanner justInput = null;
		Scanner keyboard = new Scanner(System.in);
		String sentence = null;

		System.out.println("Enter a short sentence in one line");
		sentence = keyboard.nextLine();

		justInput = new Scanner(sentence);

		while (justInput.hasNext()) {
			System.out.print(justInput.next() + " [space] ");
		}
		System.out.println("\n");
		/*
		 * Parameter to a Scanner constructor may be a keyboard, a file, or simply
		 * another String.
		 */

		justInput = new Scanner("Today;is;a;nice;day");
		justInput.useDelimiter(";");
		/*
		 * Here we changed delimiter. Delimiter will no longer be set as white
		 * characters. To change it back to normal, you can use method reset(). It
		 * resets delimiters back to default value which are whitespace.
		 */

		while (justInput.hasNext()) {
			System.out.println(justInput.next());
		}
		System.out.print("\n");

		justInput = new Scanner("Life 20 Mana 10 Attack 7 Defense 13").reset();
		/*
		 * Here we are resetting delimiters to default value. We are calling a method at
		 * the same time when we created new object. Same thing can be done with
		 * useDelimiter method. justInput.reset();
		 */
		// justInput = new Scanner("Just-another-example-text").useDelimiter("-");

		String word1 = justInput.next();
		int hp = justInput.nextInt();
		String word2 = justInput.next();
		int mp = justInput.nextInt();
		System.out.println(word1 + hp + "\n" + word2 + mp);
		/*
		 * We are reading nextInt and next from Scanner. nextInt() and next() reads from
		 * Scanner as long as it finds delimiters. If your words or data are divided by
		 * other characters than space, it is good to change the delimiters to the right
		 * one. If the first word is String and you try to use nextInt(), then this
		 * method will throw unchecked exception. It is unchecked so you do not have to
		 * catch it.
		 */

	}

}
