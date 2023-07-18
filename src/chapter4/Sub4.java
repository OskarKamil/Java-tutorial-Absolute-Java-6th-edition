package chapter4;

import java.util.StringTokenizer;
/* To use StringTokenizer class. */

public class Sub4 {
	public static void main(String[] args) {
		
		Sub4a pet001 = new Sub4a();
		/* Creating a variable of type Sub4a, and using no-argument constructor. That's why we put () at the end of defining new object. It is invoking default constructor which does nothing but create new object and initialize all instance variables to zeros and false if boolean and null to others. If we create our own constructor that takes argument, Java will remove default constructor and this initialization above would be illegal cuz we trying to invoke Sub4a() which does not exist cuz we created our own. */
		Sub4a pet002 = new Sub4a("Sisi");
		/* Here we used overloaded constructor. */
		
		StringTokenizer wordfactory = new StringTokenizer("Give me the word, my friend.", " \n.,");
		while(wordfactory.hasMoreTokens()) {
			System.out.println(wordfactory.nextToken());
		}
		/* Stringtokenizer is a class that splits String into words divided by spaces (or other custom symbols). Use new StringTokenizer(String, delimiters). In place of string, put literal "test" or String variable, and in place or delimiters place characters that will be used as a blank characters like space, tab, new line etc. Example " \n.," - this includes space, new line, dot, comma. This is a seconds argument. This is overloading as well. You can just enter String of text to divide and default white spaces will be used. tringTokenizer wordfactory = new StringTokenizer("Give me the word, my friend."). In place of delimiters you can also use variable. Let's say String delimiters = " \n()". Then brackets will also be taken as delimiter. */
	}
}
