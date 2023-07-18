package chapter2;

import java.text.NumberFormat; //here we import NumberFormat class to format currency output
import java.util.Locale; //here we import class to choose other format option than default
import java.text.DecimalFormat; //powerful tool to format numbers

public class Sub1 {

	public static void main(String[] args) {

		NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
		System.out.println(moneyFormatter.format(19.8));
		System.out.println(moneyFormatter.format(19.86666));
		String price1 = moneyFormatter.format(0.99111);
		System.out.println(price1);
		/*
		 * Here we create a new object of a class NumberFormat and name it
		 * moneyFormatter. Then we assign a value that is on the right side. The right
		 * side determines what is our default currency format depending on our
		 * location. (if you're in the UK, it will be pounds, if USA, it will be
		 * dollars, etc). Then we use println to output a text.
		 * moneyFormatter.format(number) is a method. It takes a value number as an
		 * attribute, formats it in currency format, rounds up if necessary, then casts
		 * as string. Note that inside of println, you can use String price = method of
		 * NumberFormat.format.
		 */

		moneyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(moneyFormatter.format(19.8));
		/*
		 * Here we change the value of the moneyFormatter object. We use
		 * getCurrencyInstance(Locale.US). From now on, while using moneyFormatter and
		 * format method, all values will have a US format. You can always create two
		 * objects of NumberFormat, one for each local currency.
		 */

		DecimalFormat simplePrice = new DecimalFormat("0.00");
		DecimalFormat simplePrice2 = new DecimalFormat("#.00");
		System.out.println("price for coke: $" + simplePrice.format(0.99));
		System.out.println("price for chocolate bar: $" + simplePrice2.format(0.99));
		/*
		 * We are declaring a new object of DecimalFormat. We use 'new' as a keyword.
		 * then DecimalFormat(pattern) with the pattern we wish to use. In place of 0s
		 * must be put in the digit even if it's zero. In place of # there will be put a
		 * digit only if it's nonzero. At the end can be also put %, all numbers will be
		 * multiplied by 100 and % sign put at the end. Also E notation is available.
		 */

		System.out.println("Start of the line.");
		System.out.print("Start of the new line.");
		System.out.print(" Output in the same line.\n");
		/*
		 * println = print + \n . println puts \n at the end of the line so next output
		 * will start from the new line
		 */

		int n1 = 5;
		double price = 1 / 3.0;
		System.out.println("$ " + price);
		System.out.println();
		System.out.printf("$ %d", n1); // %d is used for integers
		System.out.printf("$ %.2f\n", price);
		/*
		 * printf is an old method that outputs text and formats number output. printf
		 * consists of 2 arguments separated by comma. How printf works.
		 * ("anything%6.2fanything", variable); this will output "anything" + variable +
		 * "anything"; %6.2f - 6 means at least six characters will be output in place
		 * of variable (if the output is actually less than that, blank spaces will be
		 * put at the beginning. If it's more, then nothing will change. 2f means that
		 * exactly 2 digits after point will be output, even if they are zero. If you
		 * don't want to include a minimum number of characters, leave that space blank
		 * (%.2f). Zero causes error. If you don't want to include the number of digits
		 * after point, leave it empty (%6f). Java default settings will take over.
		 */

		String word1 = "pub";
		String word2 = "restaurant";
		String word3 = "bed & breakfast";
		String word4 = "frequently asked questions";
		price = 30;

		System.out.printf("- %30s -\n", word1);
		System.out.printf("- %30s -\n", word2);
		System.out.printf("- %30s -\n", word3);
		System.out.printf("- %30s -\n", word4);

		System.out.printf("- %-30s -%n", word1);
		System.out.printf("- %-30s -%n", word2);
		System.out.printf("- %-30s -%n", word3);
		System.out.printf("- %-30s -%n", word4);
		/*
		 * printf doesn't work like println. You need to add a new line character
		 * manually. One of practical uses of printf with strings is text justified to
		 * either left or right. %30 means that the value whether string or number must
		 * be at least 30 characters long, if the variable is less than that, extra
		 * space will be added on the right side, or on the left (-) is used before the
		 * number. It is advised to use %n instead of \n because of readability and
		 * compatibility.
		 */

		System.out.printf("%n$ %.2f for %s%n", price, word3);
		/*
		 * %n - new line, $ - output dollar sign, %.2f - output double number with only
		 * 2 decimal point, %s - output string, %n - new line. In printf you can also
		 * use 2 variables, also of different types. One is double and one is string.
		 * First argument should use them in the same order as they are listed as latter
		 * arguments.
		 */
	}

}